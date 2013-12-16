package com.paypal.location.exceptions;

/**
 * Base class for Ops Console Exceptions
 * User: pderoxas
 * Date: 10/7/13
 * Time: 2:08 PM
 */
public abstract class OpsConsoleException extends Exception {
    private ExceptionCode exceptionCode;

    public ExceptionCode getExceptionCode() {
        return exceptionCode;
    }

    public OpsConsoleException(String message, ExceptionCode exceptionCode) {
        super(message);
        this.exceptionCode = exceptionCode;
    }

    public OpsConsoleException(String message, ExceptionCode exceptionCode, Throwable cause) {
        super(message, cause);
        this.exceptionCode = exceptionCode;
    }
}
