package com.project.multimodule.error.exception.error;


import com.project.multimodule.error.exception.CommonException;

/**
 * Business role exception used to handle role exception.
 *
 * @author Abd-alrhman Alkraien.
 * @version 1.0
 */
public class BusinessRoleException extends CommonException {

    /**
     * Constructor.
     *
     * @param businessErrorCode businessErrorCode
     */
    public BusinessRoleException(final BusinessErrorCodes businessErrorCode) {
        super(ErrorCategories.BUSINESS_ROLE_ERROR, businessErrorCode);
    }

    /**
     * Constructor.
     *
     * @param businessErrorCode businessErrorCode
     * @param args              args
     */
    public BusinessRoleException(final BusinessErrorCodes businessErrorCode, final Object... args) {
        super(ErrorCategories.BUSINESS_ROLE_ERROR, businessErrorCode, args);
    }
}
