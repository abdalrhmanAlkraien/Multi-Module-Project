package com.project.multimodule.controller.module.user;

import com.project.multimodule.controller.AuthController;
import com.project.multimodule.dto.SignInRequest;
import com.project.multimodule.dto.SignupRequest;
import com.project.multimodule.dto.response.SignInResponse;
import com.project.multimodule.service.AuthenticationService;
import com.project.multimodule.util.GenericResponse;
import com.project.multimodule.util.PathConstant;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Abd-alrhman Alkraien.
 * @Date: 2/10/2024
 * @Time: 9:32 PM
 */
@RestController
@RequestMapping(PathConstant.API_V1 + PathConstant.AUTH_PATH)
@RequiredArgsConstructor
public class AuthControllerImpl implements AuthController {

    private final AuthenticationService authenticationService;

    @Override
    @PostMapping("/signup")
    public ResponseEntity<GenericResponse> signUp(@RequestBody SignupRequest signupRequest) {

        authenticationService.signUp(signupRequest);
        return ResponseEntity.ok(
                GenericResponse.success());
    }

    @Override
    @PostMapping("/login")
    public ResponseEntity<GenericResponse<SignInResponse>> login(@RequestBody SignInRequest signInRequest) throws Exception {

        return ResponseEntity.ok(GenericResponse.success(authenticationService.signIn(signInRequest)));
    }
}
