package com.paypal.hiera.exceptions;

/**
 * User: pderoxas
 * Date: 2/25/13
 * Time: 11:43 AM
 * Implementation of Exception specific to Resource Not Found
 */
public class ResourceNotFoundException extends ApplicationException {

    public ResourceNotFoundException(String message, ExceptionCode exceptionCode) {
        super(message, exceptionCode);
    }

    public ResourceNotFoundException(String message, ExceptionCode exceptionCode, Throwable cause) {
        super(message, exceptionCode, cause);
    }
}
