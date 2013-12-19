package com.paypal.location.exceptions;

import org.hibernate.AssertionFailure;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.servlet.mvc.multiaction.NoSuchRequestHandlingMethodException;

/**
 * User: pderoxas
 * Date: 8/21/13
 * Time: 10:09 AM
 * Common exception handler that will return a common ResponseEntity object.
 */
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    public GlobalExceptionHandler() {
        super();
    }

    //Custom Exceptions
    @ExceptionHandler(value = { ResourceNotFoundException.class })
    public ResponseEntity<Object> handleResourceNotFoundException(ApplicationException ex) {
        logger.info("Catching: " + ex.getClass().getSimpleName());
        return createErrorResponse(HttpStatus.NOT_FOUND, ex);
    }

    @ExceptionHandler(value = { InvalidStateException.class })
    public ResponseEntity<Object> handleNoAvailableSlotsException(ApplicationException ex) {
        logger.info("Catching: " + ex.getClass().getSimpleName());
        return createErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, ex);
    }
    @ExceptionHandler(value = { InvalidResourceAttributeValueException.class })
    public ResponseEntity<Object> handleInvalidResourceAttributeValueException(ApplicationException ex) {
        logger.info("Catching: " + ex.getClass().getSimpleName());
        return createErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, ex);
    }
    @ExceptionHandler(value = { ApplicationConfigException.class })
    public ResponseEntity<Object> handleConfigNotFoundException(ApplicationException ex) {
        logger.info("Catching: " + ex.getClass().getSimpleName());
        return createErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, ex);
    }
    @ExceptionHandler(value = { AssertionFailure.class })
    public ResponseEntity<Object> handlePropertyValueException(AssertionFailure ex) {
        logger.info("Catching: " + ex.getClass().getSimpleName());
        return createErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, ExceptionCode.BAD_REQUEST, ex);
    }
    //catch all others
    @ExceptionHandler(value = { Exception.class })
    public ResponseEntity<Object> handleException(Exception ex)  {
        logger.info("Catching: " + ex.getClass().getSimpleName());
        return createErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, ExceptionCode.UNKNOWN_EXCEPTION, ex);
    }


    //Custom Overrides
    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex,
                                                                          HttpHeaders headers,
                                                                          HttpStatus status,
                                                                          WebRequest request) {
        logger.info("Catching: " + ex.getClass().getSimpleName());
        return createErrorResponse(HttpStatus.BAD_REQUEST, ExceptionCode.BAD_REQUEST, ex);
    }

    // 404
    @Override
    protected ResponseEntity<Object> handleNoSuchRequestHandlingMethod(NoSuchRequestHandlingMethodException ex,
                                                            HttpHeaders headers,
                                                            HttpStatus status,
                                                            WebRequest request) {
        logger.info("Catching: " + ex.getClass().getSimpleName());
        return createErrorResponse(HttpStatus.NOT_FOUND, ExceptionCode.RESOURCE_NOT_FOUND, ex);
    }

    // 405
    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
                                                                         HttpHeaders headers,
                                                                         HttpStatus status,
                                                                         WebRequest request) {
        logger.info("Catching: " + ex.getClass().getSimpleName());
        return createErrorResponse(HttpStatus.METHOD_NOT_ALLOWED, ExceptionCode.METHOD_NOT_ALLOWED, ex);
    }


    //415
    @Override
    protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex,
                                                                         HttpHeaders headers,
                                                                         HttpStatus status,
                                                                         WebRequest request) {
        logger.info("Catching: " + ex.getClass().getSimpleName());
        return createErrorResponse(HttpStatus.UNSUPPORTED_MEDIA_TYPE, ExceptionCode.UNSUPPORTED_CONTENT_TYPE, ex);
    }

    /**
     * This overrides the common ResponseEntity constructor of the super class.
     * We will use it to handle any Exceptions that we don't explicitly handle above.
     * @param ex
     * @param body
     * @param headers
     * @param status
     * @param request
     * @return
     */
    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex,
                                                             Object body,
                                                             HttpHeaders headers,
                                                             HttpStatus status,
                                                             WebRequest request) {
        logger.info("Catching: " + ex.getClass().getSimpleName());
        return createErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, ExceptionCode.UNKNOWN_EXCEPTION, ex);
    }

    /**
     * Constructs the error response data structure
     * @param httpStatus - HttpStatus object
     * @param ex - Exception object
     * @return ResponseEntity object
     */
    private ResponseEntity<Object> createErrorResponse(HttpStatus httpStatus, ApplicationException ex) {
        return createErrorResponse(httpStatus, ex.getExceptionCode(), ex);
    }

    /**
     * Constructs the error response data structure
     * @param httpStatus - HttpStatus object
     * @param exceptionCode - ExceptionCode object
     * @param ex - Exception object
     * @return ResponseEntity object
     */
    private ResponseEntity<Object> createErrorResponse(HttpStatus httpStatus, ExceptionCode exceptionCode, Exception ex) {
        HttpHeaders responseHeaders = new HttpHeaders();
        ExceptionDetails exceptionDetails = new ExceptionDetails(exceptionCode, ex);
        return new ResponseEntity<Object>(exceptionDetails, responseHeaders, httpStatus);
    }
}

