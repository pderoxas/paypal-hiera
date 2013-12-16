package com.paypal.location.dal;

import com.paypal.common.exceptions.DalException;
import com.google.common.base.Predicate;
import com.paypal.location.config.app.ApplicationConfig;
import com.paypal.location.models.Location;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * User: pderoxas
 * Date: 8/30/13
 * Time: 10:05 AM
 * DAO Implementation for Resource
 */
@Repository
@Qualifier("LocationDAO")
public class LocationDAO implements ResourceDAO<Location, String> {
    private Logger logger = Logger.getLogger(this.getClass());


    @Autowired
    private ApplicationConfig applicationConfig;


    @Override
    public Iterable<Location> getAll() throws DalException {
        return null;
    }

    @Override
    public Iterable<Location> getByIdList(List<String> idList) throws DalException {
        return null;
    }

    @Override
    public Iterable<Location> getByPredicate(Predicate<Location> predicate) throws DalException {
        return null;
    }

    @Override
    public Iterable<Location> getList(Criteria criteria) throws DalException {
        return null;
    }

    @Override
    public Criteria getCriteriaInstance() throws DalException {
        return null;
    }

    @Override
    public Location getById(String id) throws DalException {
        return null;
    }

    @Override
    public String addResource(Location resource) throws DalException {
        return null;
    }

    @Override
    public String updateResource(Location resource) throws DalException {
        return null;
    }
}
