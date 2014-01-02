package com.paypal.hiera.dal;

import com.google.common.base.Predicate;
import com.paypal.common.exceptions.DalException;
import com.paypal.hiera.models.LocationConfig;
import org.apache.commons.lang.NotImplementedException;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * User: pderoxas
 * Date: 8/30/13
 * Time: 10:05 AM
 * DAO Implementation for Resource
 */
@Repository
@Qualifier("LocationDAO")
@Transactional

public class LocationDAO implements ResourceDAO<LocationConfig, String> {
    private Logger logger = Logger.getLogger(this.getClass());

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private HibernateTransactionManager transactionManager;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    public Iterable<LocationConfig> getAll() throws DalException {
        return this.getList(null);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<LocationConfig> getByIdList(List<String> idList) throws DalException {
        return this.getList(Restrictions.in("id", idList));
    }

    @Override
    public Iterable<LocationConfig> getByPredicate(Predicate<LocationConfig> predicate) throws DalException {
        throw new NotImplementedException("This method is not implemented.");
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<LocationConfig> getList(Criterion criterion) throws DalException {
        Criteria criteria = this.getCriteriaInstance();
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        if(criterion != null) criteria.add(criterion);
        return criteria.list();
    }

    @Override
    public Criteria getCriteriaInstance() throws DalException {
        return this.getCurrentSession().createCriteria(LocationConfig.class);
    }

    @Override
    @Transactional(readOnly = true)
    public LocationConfig getById(String id) throws DalException {
        return (LocationConfig) getCurrentSession().get(LocationConfig.class, id);
    }

    @Override
    @Transactional
    public String addResource(LocationConfig locationConfig) throws DalException {
        try {
            getCurrentSession().save(locationConfig);
            return locationConfig.getId();
        } catch (Exception e){
            logger.error(e.getMessage(), e);
            throw new DalException("Failed to add locationConfig.", e);
        }
    }

    @Override
    @Transactional
    public String updateResource(LocationConfig locationConfig) throws DalException {
        try {
            getCurrentSession().update(locationConfig);
            return locationConfig.getId();
        } catch (Exception e){
            logger.error(e.getMessage(), e);
            throw new DalException("Failed to update locationConfig.", e);
        }
    }

    @Override
    @Transactional
    public String saveOrUpdateResource(LocationConfig locationConfig) throws DalException {
        try {
            getCurrentSession().saveOrUpdate(locationConfig);
            return locationConfig.getId();
        } catch (Exception e){
            logger.error(e.getMessage(), e);
            throw new DalException("Failed to update locationConfig.", e);
        }
    }
}
