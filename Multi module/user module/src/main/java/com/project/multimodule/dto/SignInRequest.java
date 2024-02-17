package com.project.multimodule.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author: Abd-alrhman Alkraien.
 * @Date: 2/10/2024
 * @Time: 6:19 PM
 */
@Data
@AllArgsConstructor
public class SignInRequest {

    private String email;
    private String password;
}
