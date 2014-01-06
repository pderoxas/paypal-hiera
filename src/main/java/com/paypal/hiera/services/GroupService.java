package com.paypal.hiera.services;

import com.paypal.common.exceptions.DalException;
import com.paypal.hiera.dal.ResourceDAO;
import com.paypal.hiera.exceptions.ExceptionCode;
import com.paypal.hiera.exceptions.ResourceNotFoundException;
import com.paypal.hiera.models.GroupConfig;
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
public class GroupService {
    private Logger logger = Logger.getLogger(this.getClass());

    @Autowired
    @Qualifier("GroupDAO")
    private ResourceDAO<GroupConfig, String> resourceDAO;

    public Iterable<GroupConfig> getAllGroups() throws DalException {
        return resourceDAO.getAll();
    }

    public Iterable<GroupConfig> getGroups (List<String> idList) throws DalException {
        return resourceDAO.getByIdList(idList);
    }

    public GroupConfig getGroup(String id) throws DalException, ResourceNotFoundException {
        GroupConfig resource = resourceDAO.getById(id);
        if(resource == null){
            ResourceNotFoundException e = new ResourceNotFoundException("GroupConfig Resource (" + id + ") does not exist.", ExceptionCode.RESOURCE_NOT_FOUND);
            logger.info(e.getMessage(), e);
            throw e;
        }
        return resource;
    }

    public GroupConfig saveGroup(GroupConfig groupConfig) throws DalException {
        resourceDAO.saveOrUpdateResource(groupConfig);
        return groupConfig;
    }

}
