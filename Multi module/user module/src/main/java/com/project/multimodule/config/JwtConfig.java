package com.project.multimodule.config;

import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Getter;
import org.springframework.stereotype.Component;

/**
 * @author: Abd-alrhman Alkraien.
 * @Date: 2/11/2024
 * @Time: 11:45 AM
 */
@Component
@Getter
public class JwtConfig {

    private final SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS512;
    // It should be kept encoded in an environment variable
    private final String secret =
            """
                    5s2BCxpNxdI58mAaAllBr/psyu91aCusvXy+kew9ytxQ/zh\
                    RtvcZMxVAjmkq8pVkSMA81+9Y0D4W06qGre+hYg==""";
    private final String tokenPrefix = "Bearer ";
    private final String issuer = "marinabits.com";
    private final int tokenExpireDuration = 5; // In days

    private final int refreshTokenExpiration = 14; // In days

}
