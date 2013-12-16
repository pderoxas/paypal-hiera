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
 * Date: 9/1/13
 * Time: 9:15 AM
 * Service Layer for resource
 */

@Service
public class LocationService {
    private Logger logger = Logger.getLogger(this.getClass());

    @Autowired
    @Qualifier("LocationDAO")
    private ResourceDAO<Location, String> locationDAO;

    public Iterable<Location> getLocations() throws DalException {
        return locationDAO.getAll();
    }

    public Location getLocation(String locationId) throws DalException, ResourceNotFoundException {
        //Location resource = locationDAO.getById(locationId);
        Location resource = null;
        locationId.replace(".localdomain","");
        if(locationId.equals("lenovo-y510p")){
            resource = new Location(locationId, "Boston, MA", "Store location in Faneuil Hall", "1.0.0", "v1.0.0");
        } else if(locationId.equals("ri-01")){
            resource = new Location(locationId, "Providence, RI", "Store #1", "1.1.0", "v1.1.0");
        } else if(locationId.equals("ri-02")){
            resource = new Location(locationId, "Providence, RI", "Store #2", "1.1.0", "v1.1.0");
        } else if(locationId.equals("ny-01")){
            resource = new Location(locationId, "New York, NY", "Store #1", "1.2.0", "v1.2.0");
        } else if(locationId.equals("ny-02")){
            resource = new Location(locationId, "West Islip, NY", "Store #2", "1.2.0", "v1.2.0");
        } else if(locationId.equals("ny-03")){
            resource = new Location(locationId, "Brooklyn, NY", "Store #3", "1.2.0", "v1.2.0");
        } else if(locationId.equals("ca-01")){
            resource = new Location(locationId, "San Francisco, CA", "Store #1", "1.2.1", "v1.2.1");
        } else if(locationId.equals("ca-02")){
            resource = new Location(locationId, "Los Angeles, CA", "Store #2", "1.2.1", "v1.2.1");
        } else if(locationId.equals("ca-03")){
            resource = new Location(locationId, "Sacramento, CA", "Store #3", "1.2.1", "v1.2.1");
        } else if(locationId.equals("ca-04")){
            resource = new Location(locationId, "San Jose, CA", "Store #4", "1.2.1", "v1.2.1");
        } else if(StringUtils.isBlank(locationId)) {
            resource = new Location(locationId, "default", "Default Store", "1.0.0", "v1.0.0");
        }


        if(resource == null){
            ResourceNotFoundException e = new ResourceNotFoundException("Location Resource (" + locationId + ") does not exist.", ExceptionCode.RESOURCE_NOT_FOUND);
            logger.info(e.getMessage(), e);
            throw e;
        }
        return resource;
    }
}
