package com.project.multimodule.service;

import com.project.multimodule.dto.SignInRequest;
import com.project.multimodule.dto.SignupRequest;
import com.project.multimodule.dto.response.SignInResponse;

/**
 * @author: Abd-alrhman Alkraien.
 * @Date: 2/10/2024
 * @Time: 6:16 PM
 */
public interface AuthenticationService {

    void signUp(SignupRequest request);

    SignInResponse signIn(SignInRequest request) throws Exception;

    void createAdminUser(SignupRequest request);
}
