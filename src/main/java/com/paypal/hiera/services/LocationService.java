package com.paypal.hiera.services;

import com.paypal.common.exceptions.DalException;
import com.paypal.common.utils.StringUtils;
import com.paypal.hiera.dal.ResourceDAO;
import com.paypal.hiera.exceptions.ExceptionCode;
import com.paypal.hiera.exceptions.ResourceNotFoundException;
import com.paypal.hiera.models.LocationConfig;
import org.apache.log4j.Logger;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

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
    private ResourceDAO<LocationConfig, String> resourceDAO;

    public Iterable<LocationConfig> getAllLocations() throws DalException {
        return resourceDAO.getAll();
    }

    public Iterable<LocationConfig> getLocationByCode(String geoLocationCode) throws DalException {
        if(!StringUtils.isBlank(geoLocationCode)){
            return resourceDAO.getList(Restrictions.eq("code", geoLocationCode));
        }
        return resourceDAO.getAll();
    }

    public Iterable<LocationConfig> getGeoLocations(List<String> idList) throws DalException {
        return resourceDAO.getByIdList(idList);
    }

    public LocationConfig getLocation(String id) throws DalException, ResourceNotFoundException {
        LocationConfig resource = resourceDAO.getById(id);
        if(resource == null){
            ResourceNotFoundException e = new ResourceNotFoundException("LocationConfig Resource (" + id + ") does not exist.", ExceptionCode.RESOURCE_NOT_FOUND);
            logger.info(e.getMessage(), e);
            throw e;
        }
        return resource;
    }

    public LocationConfig saveLocation(LocationConfig locationConfig) throws DalException {
        resourceDAO.saveOrUpdateResource(locationConfig);
        return locationConfig;
    }

    public void deleteLocation(LocationConfig locationConfig) throws DalException {
        resourceDAO.deleteResource(locationConfig);
    }

}
