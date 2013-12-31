package com.paypal.hiera.dal;

import com.google.common.base.Predicate;
import com.paypal.common.exceptions.DalException;
import com.paypal.hiera.models.GeoLocation;
import org.apache.commons.lang.NotImplementedException;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
@Qualifier("GeoLocationDAO")
@Transactional

public class GeoLocationDAO implements ResourceDAO<GeoLocation, Integer> {
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
    public Iterable<GeoLocation> getAll() throws DalException {
        Criteria criteria = this.getCriteriaInstance();
        return this.getList(criteria);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<GeoLocation> getByIdList(List<Integer> idList) throws DalException {
        Criteria criteria = this.getCriteriaInstance();
        criteria.add(Restrictions.in("id", idList));
        return this.getList(criteria);
    }

    @Override
    public Iterable<GeoLocation> getByPredicate(Predicate<GeoLocation> predicate) throws DalException {
        throw new NotImplementedException("This method is not implemented.");
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<GeoLocation> getList(Criteria criteria) throws DalException {
        return criteria.list();
    }

    @Override
    public Criteria getCriteriaInstance() throws DalException {
        return this.getCurrentSession().createCriteria(GeoLocation.class);
    }

    @Override
    @Transactional(readOnly = true)
    public GeoLocation getById(Integer id) throws DalException {
        return (GeoLocation) getCurrentSession().get(GeoLocation.class, id);
    }

    @Override
    @Transactional
    public Integer addResource(GeoLocation geoLocation) throws DalException {
        try {
            getCurrentSession().save(geoLocation);
            return geoLocation.getId();
        } catch (Exception e){
            logger.error(e.getMessage(), e);
            throw new DalException("Failed to add geoLocation.", e);
        }
    }

    @Override
    @Transactional
    public Integer updateResource(GeoLocation geoLocation) throws DalException {
        try {
            getCurrentSession().update(geoLocation);
            return geoLocation.getId();
        } catch (Exception e){
            logger.error(e.getMessage(), e);
            throw new DalException("Failed to update geoLocation.", e);
        }
    }
}
