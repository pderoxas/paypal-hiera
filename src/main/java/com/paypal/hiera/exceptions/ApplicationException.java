package com.paypal.hiera.exceptions;

/**
 * Base class for Ops Console Exceptions
 * User: pderoxas
 * Date: 10/7/13
 * Time: 2:08 PM
 */
public abstract class ApplicationException extends Exception {
    private ExceptionCode exceptionCode;

    public ExceptionCode getExceptionCode() {
        return exceptionCode;
    }

    public ApplicationException(String message, ExceptionCode exceptionCode) {
        super(message);
        this.exceptionCode = exceptionCode;
    }

    public ApplicationException(String message, ExceptionCode exceptionCode, Throwable cause) {
        super(message, cause);
        this.exceptionCode = exceptionCode;
    }
}
