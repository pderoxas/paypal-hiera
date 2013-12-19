package com.paypal.location.exceptions;

/**
 * User: pderoxas
 * Date: 2/25/13
 * Time: 11:43 AM
 * Implementation of Exception specific to Application Configuration not found
 */
public class ApplicationConfigException extends ApplicationException {
    public ApplicationConfigException(String message, ExceptionCode exceptionCode) {
        super(message, exceptionCode);    //To change body of overridden methods use File | Settings | File Templates.
    }

    public ApplicationConfigException(String message, ExceptionCode exceptionCode, Throwable cause) {
        super(message, exceptionCode, cause);    //To change body of overridden methods use File | Settings | File Templates.
    }
}
