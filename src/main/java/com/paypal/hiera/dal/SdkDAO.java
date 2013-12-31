package com.paypal.hiera.dal;

import com.google.common.base.Predicate;
import com.paypal.common.exceptions.DalException;
import com.paypal.hiera.models.Sdk;
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
@Qualifier("SdkDAO")
@Transactional

public class SdkDAO implements ResourceDAO<Sdk, Integer> {
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
    public Iterable<Sdk> getAll() throws DalException {
        return this.getList(null);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Sdk> getByIdList(List<Integer> idList) throws DalException {
        return this.getList(Restrictions.in("id", idList));
    }

    @Override
    public Iterable<Sdk> getByPredicate(Predicate<Sdk> predicate) throws DalException {
        throw new NotImplementedException("This method is not implemented.");
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Sdk> getList(Criterion criterion) throws DalException {
        Criteria criteria = this.getCriteriaInstance();
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        if(criterion != null) criteria.add(criterion);
        return criteria.list();
    }

    @Override
    public Criteria getCriteriaInstance() throws DalException {
        return this.getCurrentSession().createCriteria(Sdk.class);
    }

    @Override
    @Transactional(readOnly = true)
    public Sdk getById(Integer id) throws DalException {
        return (Sdk) getCurrentSession().get(Sdk.class, id);
    }

    @Override
    @Transactional
    public Integer addResource(Sdk sdk) throws DalException {
        try {
            getCurrentSession().save(sdk);
            return sdk.getId();
        } catch (Exception e){
            logger.error(e.getMessage(), e);
            throw new DalException("Failed to add sdk.", e);
        }
    }

    @Override
    @Transactional
    public Integer updateResource(Sdk sdk) throws DalException {
        try {
            getCurrentSession().update(sdk);
            return sdk.getId();
        } catch (Exception e){
            logger.error(e.getMessage(), e);
            throw new DalException("Failed to update sdk.", e);
        }
    }
}
