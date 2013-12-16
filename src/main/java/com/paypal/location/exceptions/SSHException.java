package com.paypal.location.exceptions;

/**
 * User: pderoxas
 * Date: 2/25/13
 * Time: 11:43 AM
 * Implementation of Exception specific to ssh-related classes
 */
public class SSHException extends OpsConsoleException {
    public SSHException(String message, ExceptionCode exceptionCode) {
        super(message, exceptionCode);
    }

    public SSHException(String message, ExceptionCode exceptionCode, Throwable cause) {
        super(message, exceptionCode, cause);
    }
}
