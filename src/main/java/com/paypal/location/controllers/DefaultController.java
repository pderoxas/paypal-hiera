package com.paypal.location.controllers;

import com.paypal.location.exceptions.ExceptionCode;
import com.paypal.location.exceptions.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * User: pderoxas
 * Date: 8/15/13
 * Time: 9:56 AM
 * Default Controller - should handle any URL pattern not explicitly handled and throw a ResourceNotFoundException
 */
@Controller
@RequestMapping("{path:(?!resources).*$}/**")  // we shouldn't process resources(css, js, images) by controller, we need to send it directly to client
public class DefaultController {

    public DefaultController() {
        super();
    }

    /**
     * This is the default controller that is meant to handle any
     * url mappings that have not been explicitly handled.
     * @return ResponseEntity
     * @throws ResourceNotFoundException
     */
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Object> resourceListNotFound() throws ResourceNotFoundException {
        throw new ResourceNotFoundException("The requested resource could not be found!", ExceptionCode.RESOURCE_NOT_FOUND);
    }
}
