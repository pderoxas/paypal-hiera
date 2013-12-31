package com.paypal.hiera.exceptions;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * Created with IntelliJ IDEA.
 * User: dev
 * Date: 9/23/13
 * Time: 2:40 PM
 * To change this template use File | Settings | File Templates.
 */
@Component
@Scope("prototype")
@JsonSerialize(include= JsonSerialize.Inclusion.NON_NULL)
public class ExceptionDetails {
    private String code;
    private String exception;
    private String message;

    public ExceptionDetails(ExceptionCode code, Exception exception) {
        this.code = code.name();
        this.message = code.toString() + exception.getMessage();
        StringWriter stackTrace = new StringWriter();
        exception.printStackTrace(new PrintWriter(stackTrace));
        this.exception = stackTrace.toString();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
