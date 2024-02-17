package com.project.multimodule.error.exception;


import com.project.multimodule.error.exception.error.BusinessErrorCodes;
import com.project.multimodule.error.exception.error.ErrorCategories;

/**
 * General Common exception.
 *
 * @author Abd-alrhman Alkraien.
 * @version 1.0
 */
public class CommonException extends ApiException {

    private BusinessErrorCodes businessErrorCode;
    private String errorMessage;
    private Object[] args;

    /**
     * constructor.
     *
     * @param businessErrorCode Business role exception details
     */
    public CommonException(final ErrorCategories errorCategories, final BusinessErrorCodes businessErrorCode) {
        this(errorCategories, businessErrorCode, null);
    }

    /**
     * constructor.
     *
     * @param businessErrorCode Business role exception details
     * @param args              message placeholder arguments
     */
    public CommonException(final ErrorCategories errorCategories, final BusinessErrorCodes businessErrorCode,
                           final Object... args) {
        super(errorCategories);
        this.businessErrorCode = businessErrorCode;
        this.args = args;
    }

    /**
     * constructor.
     *
     * @param businessErrorCode Business role exception details
     * @param args              message placeholder arguments
     */
    public CommonException(final ErrorCategories errorCategories, final String errorMessage,
                           final Object... args) {
        super(errorCategories);
        this.errorMessage = errorMessage;
        this.args = args;
    }

    public BusinessErrorCodes getBusinessErrorCode() {
        return businessErrorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
