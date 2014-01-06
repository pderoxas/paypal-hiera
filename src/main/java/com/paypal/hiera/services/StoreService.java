package com.paypal.hiera.services;

import com.paypal.common.exceptions.DalException;
import com.paypal.hiera.dal.ResourceDAO;
import com.paypal.hiera.exceptions.ExceptionCode;
import com.paypal.hiera.exceptions.ResourceNotFoundException;
import com.paypal.hiera.models.StoreConfig;
import org.apache.log4j.Logger;
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
public class StoreService {
    private Logger logger = Logger.getLogger(this.getClass());

    @Autowired
    @Qualifier("StoreDAO")
    private ResourceDAO<StoreConfig, String> resourceDAO;

    public Iterable<StoreConfig> getAllStores() throws DalException {
        return resourceDAO.getAll();
    }

    public Iterable<StoreConfig> getStores(List<String> idList) throws DalException {
        return resourceDAO.getByIdList(idList);
    }

    public StoreConfig getStore(String id) throws DalException, ResourceNotFoundException {
        StoreConfig resource = resourceDAO.getById(id);
        if(resource == null){
            ResourceNotFoundException e = new ResourceNotFoundException("StoreConfig Resource (" + id + ") does not exist.", ExceptionCode.RESOURCE_NOT_FOUND);
            logger.info(e.getMessage(), e);
            throw e;
        }
        return resource;
    }

    public StoreConfig saveStore(StoreConfig storeConfig) throws DalException {
        resourceDAO.saveOrUpdateResource(storeConfig);
        return storeConfig;
    }

}
