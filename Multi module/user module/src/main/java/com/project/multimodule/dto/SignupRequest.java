package com.project.multimodule.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author: Abd-alrhman Alkraien.
 * @Date: 2/10/2024
 * @Time: 6:20 PM
 */
@Data
@AllArgsConstructor
public class SignupRequest {

    private String email;
    private String password;
    private String username;
    private String mobile;
    private String firstName;
    private String lastName;
}
