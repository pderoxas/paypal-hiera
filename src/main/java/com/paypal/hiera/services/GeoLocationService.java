package com.paypal.hiera.services;

import com.paypal.common.exceptions.DalException;
import com.paypal.common.utils.StringUtils;
import com.paypal.hiera.dal.ResourceDAO;
import com.paypal.hiera.exceptions.ExceptionCode;
import com.paypal.hiera.exceptions.ResourceNotFoundException;
import com.paypal.hiera.models.GeoLocation;
import com.paypal.hiera.models.Sdk;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
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
public class GeoLocationService {
    private Logger logger = Logger.getLogger(this.getClass());

    @Autowired
    @Qualifier("GeoLocationDAO")
    private ResourceDAO<GeoLocation, Integer> resourceDAO;

    public Iterable<GeoLocation> getAllGeoLocations() throws DalException {
        return resourceDAO.getAll();
    }

    public Iterable<GeoLocation> getGeoLocationByCode(String geoLocationCode) throws DalException {
        if(!StringUtils.isBlank(geoLocationCode)){
            return resourceDAO.getList(Restrictions.eq("code", geoLocationCode));
        }
        return resourceDAO.getAll();
    }

    public Iterable<GeoLocation> getGeoLocations(List<Integer> idList) throws DalException {
        return resourceDAO.getByIdList(idList);
    }

    public GeoLocation getGeoLocation(Integer id) throws DalException, ResourceNotFoundException {
        GeoLocation resource = resourceDAO.getById(id);
        if(resource == null){
            ResourceNotFoundException e = new ResourceNotFoundException("GeoLocation Resource (" + id + ") does not exist.", ExceptionCode.RESOURCE_NOT_FOUND);
            logger.info(e.getMessage(), e);
            throw e;
        }
        return resource;
    }

    public GeoLocation saveGeoLocation(GeoLocation geoLocation) throws DalException {
        if(geoLocation.getId() > 0){
            resourceDAO.updateResource(geoLocation);
        } else {
            resourceDAO.addResource(geoLocation);
        }
        return geoLocation;
    }

}
