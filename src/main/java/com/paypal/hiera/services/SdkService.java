package com.paypal.hiera.services;

import com.paypal.common.exceptions.DalException;
import com.paypal.hiera.dal.ResourceDAO;
import com.paypal.hiera.exceptions.ExceptionCode;
import com.paypal.hiera.exceptions.ResourceNotFoundException;
import com.paypal.hiera.models.Sdk;
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
public class SdkService {
    private Logger logger = Logger.getLogger(this.getClass());

    @Autowired
    @Qualifier("SdkDAO")
    private ResourceDAO<Sdk, Integer> resourceDAO;

    public Iterable<Sdk> getAllSdks() throws DalException {
        return resourceDAO.getAll();
    }

    public Iterable<Sdk> getSdks(List<Integer> idList) throws DalException {
        return resourceDAO.getByIdList(idList);
    }

    public Sdk getSdk(Integer id) throws DalException, ResourceNotFoundException {
        Sdk resource = resourceDAO.getById(id);
        if(resource == null){
            ResourceNotFoundException e = new ResourceNotFoundException("SDK (" + id + ") does not exist.", ExceptionCode.RESOURCE_NOT_FOUND);
            logger.info(e.getMessage(), e);
            throw e;
        }
        return resource;
    }

    public Sdk saveSdk(Sdk sdk) throws DalException {
        if(sdk.getId() > 0){
            resourceDAO.updateResource(sdk);
        } else {
            resourceDAO.addResource(sdk);
        }
        return sdk;
    }

}
