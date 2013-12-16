package com.paypal.location.controllers;

import com.paypal.common.exceptions.DalException;
import com.paypal.location.exceptions.ResourceNotFoundException;
import com.paypal.location.models.Location;
import com.paypal.location.services.LocationService;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: pderoxas
 * Date: 8/15/13
 * Time: 9:56 AM
 * Controller class for Location Resource
 */
@Controller
@RequestMapping("/locations")
public class LocationController {
    private Logger logger = Logger.getLogger(this.getClass());

    @Autowired
    private LocationService locationService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public Iterable<Location> getLocation(@RequestParam("id") String id) throws DalException, ResourceNotFoundException {
        Collection<Location> resourceList = new ArrayList<Location>();
        resourceList.add(locationService.getLocation(id));
        return resourceList;
    }
}
