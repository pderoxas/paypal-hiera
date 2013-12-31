package com.paypal.hiera.services;

import com.paypal.common.exceptions.DalException;
import com.paypal.hiera.dal.ResourceDAO;
import com.paypal.hiera.exceptions.ExceptionCode;
import com.paypal.hiera.exceptions.ResourceNotFoundException;
import com.paypal.hiera.models.Store;
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
    private ResourceDAO<Store, Integer> resourceDAO;

    public Iterable<Store> getAllStores() throws DalException {
        return resourceDAO.getAll();
    }

    public Iterable<Store> getStores(List<Integer> idList) throws DalException {
        return resourceDAO.getByIdList(idList);
    }

    public Store getStore(Integer id) throws DalException, ResourceNotFoundException {
        Store resource = resourceDAO.getById(id);
        if(resource == null){
            ResourceNotFoundException e = new ResourceNotFoundException("Store Resource (" + id + ") does not exist.", ExceptionCode.RESOURCE_NOT_FOUND);
            logger.info(e.getMessage(), e);
            throw e;
        }
        return resource;
    }

    public Store saveStore(Store store) throws DalException {
        if(store.getId() > 0){
            resourceDAO.updateResource(store);
        } else {
            resourceDAO.addResource(store);
        }
        return store;
    }

}
