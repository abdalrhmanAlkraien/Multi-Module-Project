package com.project.multimodule.error.exception.error;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * ENTECH error response structure.
 *
 * @author Abd-alrhman Alkraien.
 * @version 1.0
 */
@Getter
@Setter
@Builder
public class ErrorResponse {

    private String code;
    private String id;
    private String message;
    private List<java.lang.Error> errors;
}
