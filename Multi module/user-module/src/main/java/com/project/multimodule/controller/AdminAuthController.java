package com.project.multimodule.controller;

import com.project.multimodule.dto.SignupRequest;
import org.springframework.http.ResponseEntity;

import java.net.URISyntaxException;

/**
 * @author: Abd-alrhman Alkraien.
 * @Date: 2/12/2024
 * @Time: 5:29 PM
 */
public interface AdminAuthController {

    ResponseEntity createAdminUser(SignupRequest request) throws URISyntaxException;
}
