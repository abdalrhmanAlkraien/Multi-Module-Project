package com.project.multimodule.error.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * To handle all exceptions.
 *
 * @author Abd-alrhman Alkraien.
 * @version 1.0
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BusinessRoleException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public BusinessRoleException(String message) {
		super(message);
	}

	public BusinessRoleException(String message, Throwable throwable) {
		super(message, throwable);
	}
}
