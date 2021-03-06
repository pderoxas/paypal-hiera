package com.paypal.hiera.dal;

import com.google.common.base.Predicate;
import com.paypal.common.exceptions.DalException;
import com.paypal.hiera.models.SdkRelease;
import com.paypal.hiera.models.StoreConfig;
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
@Qualifier("SdkReleaseDAO")
@Transactional

public class SdkReleaseDAO implements ResourceDAO<SdkRelease, Integer> {
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
    public Iterable<SdkRelease> getAll() throws DalException {
        return this.getList(null);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<SdkRelease> getByIdList(List<Integer> idList) throws DalException {
        return this.getList(Restrictions.in("id", idList));
    }

    @Override
    public Iterable<SdkRelease> getByPredicate(Predicate<SdkRelease> predicate) throws DalException {
        throw new NotImplementedException("This method is not implemented.");
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<SdkRelease> getList(Criterion criterion) throws DalException {
        Criteria criteria = this.getCriteriaInstance();
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        if(criterion != null) criteria.add(criterion);
        return criteria.list();
    }

    @Override
    public Criteria getCriteriaInstance() throws DalException {
        return this.getCurrentSession().createCriteria(SdkRelease.class);
    }

    @Override
    @Transactional(readOnly = true)
    public SdkRelease getById(Integer id) throws DalException {
        return (SdkRelease) getCurrentSession().get(SdkRelease.class, id);
    }

    @Override
    @Transactional
    public Integer addResource(SdkRelease sdkRelease) throws DalException {
        try {
            getCurrentSession().save(sdkRelease);
            return sdkRelease.getId();
        } catch (Exception e){
            logger.error(e.getMessage(), e);
            throw new DalException("Failed to add SdkRelease.", e);
        }
    }

    @Override
    @Transactional
    public Integer updateResource(SdkRelease sdkRelease) throws DalException {
        try {
            getCurrentSession().update(sdkRelease);
            return sdkRelease.getId();
        } catch (Exception e){
            logger.error(e.getMessage(), e);
            throw new DalException("Failed to update SdkRelease.", e);
        }
    }

    @Override
    @Transactional
    public Integer saveOrUpdateResource(SdkRelease sdkRelease) throws DalException {
        try {
            getCurrentSession().saveOrUpdate(sdkRelease);
            return sdkRelease.getId();
        } catch (Exception e){
            logger.error(e.getMessage(), e);
            throw new DalException("Failed to update SdkRelease.", e);
        }
    }

    @Override
    @Transactional
    public void deleteResource(SdkRelease sdkRelease) throws DalException {
        try {
            getCurrentSession().delete(sdkRelease);
        } catch (Exception e){
            logger.error(e.getMessage(), e);
            throw new DalException("Failed to update SdkRelease.", e);
        }
    }
}
