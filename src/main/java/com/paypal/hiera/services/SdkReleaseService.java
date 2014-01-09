package com.paypal.hiera.services;

import com.paypal.common.exceptions.DalException;
import com.paypal.hiera.dal.ResourceDAO;
import com.paypal.hiera.exceptions.ExceptionCode;
import com.paypal.hiera.exceptions.ResourceNotFoundException;
import com.paypal.hiera.models.SdkRelease;
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
public class SdkReleaseService {
    private Logger logger = Logger.getLogger(this.getClass());

    @Autowired
    @Qualifier("SdkReleaseDAO")
    private ResourceDAO<SdkRelease, Integer> resourceDAO;

    public Iterable<SdkRelease> getAllSdkReleases() throws DalException {
        return resourceDAO.getAll();
    }

    public Iterable<SdkRelease> getSdkReleases(List<Integer> idList) throws DalException {
        return resourceDAO.getByIdList(idList);
    }

    public SdkRelease getSdkRelease(Integer id) throws DalException, ResourceNotFoundException {
        SdkRelease resource = resourceDAO.getById(id);
        if(resource == null){
            ResourceNotFoundException e = new ResourceNotFoundException("SdkRelease Resource (" + id + ") does not exist.", ExceptionCode.RESOURCE_NOT_FOUND);
            logger.info(e.getMessage(), e);
            throw e;
        }
        return resource;
    }

    public SdkRelease saveSdkRelease(SdkRelease sdkRelease) throws DalException {
        resourceDAO.saveOrUpdateResource(sdkRelease);
        return sdkRelease;
    }

    public void deleteSdkRelease(SdkRelease sdkRelease) throws DalException {
        resourceDAO.deleteResource(sdkRelease);
    }
}
