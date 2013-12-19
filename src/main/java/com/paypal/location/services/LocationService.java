package com.paypal.location.services;

import com.paypal.common.exceptions.DalException;
import com.paypal.common.utils.StringUtils;
import com.paypal.location.dal.ResourceDAO;
import com.paypal.location.exceptions.ExceptionCode;
import com.paypal.location.exceptions.ResourceNotFoundException;
import com.paypal.location.models.Location;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * User: pderoxas
 * Date: 12/16/13
 * Time: 9:15 AM
 * Service Layer for resource
 */

@Service
public class LocationService {
    private Logger logger = Logger.getLogger(this.getClass());

    @Autowired
    @Qualifier("LocationDAO")
    private ResourceDAO<Location, String> locationDAO;

    public Iterable<Location> getAllLocations() throws DalException {
        return locationDAO.getAll();
    }

    public Location getLocation(String locationId) throws DalException, ResourceNotFoundException {
        Location resource = locationDAO.getById(locationId);
        if(resource == null){
            ResourceNotFoundException e = new ResourceNotFoundException("Location Resource (" + locationId + ") does not exist.", ExceptionCode.RESOURCE_NOT_FOUND);
            logger.info(e.getMessage(), e);
            throw e;
        }
        return resource;
    }
}
