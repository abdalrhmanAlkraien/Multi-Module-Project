package com.project.multimodule.controller;

import com.project.multimodule.dto.SignInRequest;
import com.project.multimodule.dto.SignupRequest;
import org.springframework.http.ResponseEntity;

/**
 * @author: Abd-alrhman Alkraien.
 * @Date: 2/10/2024
 * @Time: 9:30 PM
 */
public interface AuthController {

    ResponseEntity signUp(final SignupRequest signupRequest);
    ResponseEntity login(final SignInRequest signInRequest) throws Exception;
}
