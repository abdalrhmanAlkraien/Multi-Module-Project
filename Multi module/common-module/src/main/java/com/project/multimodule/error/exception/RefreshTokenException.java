package com.project.multimodule.error.exception;

import java.io.Serial;

/**
 * RefreshTokenException error exception.
 *
 * @author Abd-alrhman Alkraien.
 * @version 1.0
 */
public class RefreshTokenException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 8896944115746520398L;

    public RefreshTokenException(String token, String message) {
        super(String.format("Failed for [%s]: %s", token, message));
    }
}
