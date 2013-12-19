package com.paypal.location.exceptions;

/**
 * User: pderoxas
 * Date: 2/25/13
 * Time: 11:43 AM
 * Implementation of Exception specific to request parameter classes
 */
public class InvalidResourceAttributeValueException extends ApplicationException {

    public InvalidResourceAttributeValueException(String message, ExceptionCode exceptionCode) {
        super(message, exceptionCode);
    }

    public InvalidResourceAttributeValueException(String message, ExceptionCode exceptionCode, Throwable cause) {
        super(message, exceptionCode, cause);
    }
}
