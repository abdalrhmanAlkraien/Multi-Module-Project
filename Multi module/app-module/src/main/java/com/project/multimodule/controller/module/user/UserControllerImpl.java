package com.project.multimodule.controller.module.user;

import com.project.multimodule.controller.UserController;
import com.project.multimodule.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Abd-alrhman Alkraien.
 * @Date: 2/10/2024
 * @Time: 1:59 AM
 */
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserControllerImpl implements UserController {

    private final UserServiceImpl userServiceImpl;

    @Override
    @GetMapping
    public ResponseEntity<String> test() {

       return ResponseEntity.ok(userServiceImpl.createUser());
    }
}
