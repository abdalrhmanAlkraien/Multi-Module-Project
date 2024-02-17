package com.project.multimodule.controller.module.user;

import com.project.multimodule.controller.AdminAuthController;
import com.project.multimodule.dto.SignupRequest;
import com.project.multimodule.service.AuthenticationService;
import com.project.multimodule.util.GenericResponse;
import com.project.multimodule.util.PathConstant;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * @author: Abd-alrhman Alkraien.
 * @Date: 2/12/2024
 * @Time: 5:33 PM
*/
@RestController
@RequestMapping(PathConstant.ADMIN_PATH + PathConstant.AUTH_PATH)
@Log4j2
@RequiredArgsConstructor
public class AdminAuthControllerImpl implements AdminAuthController {

    private final AuthenticationService authenticationService;
    @Override
    @PostMapping
    public ResponseEntity<GenericResponse> createAdminUser(@RequestBody SignupRequest request) throws URISyntaxException {

        authenticationService.createAdminUser(request);
        return ResponseEntity.created(new URI(PathConstant.ADMIN_PATH + PathConstant.AUTH_PATH)).body(
                GenericResponse.success());
    }
}
