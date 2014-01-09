package com.paypal.hiera.dal;

import com.google.common.base.Predicate;
import com.paypal.common.exceptions.DalException;
import com.paypal.hiera.models.GroupConfig;
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
@Qualifier("GroupDAO")
@Transactional

public class GroupDAO implements ResourceDAO<GroupConfig, String> {
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
    public Iterable<GroupConfig> getAll() throws DalException {
        return this.getList(null);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<GroupConfig> getByIdList(List<String> idList) throws DalException {
        return this.getList(Restrictions.in("id", idList));
    }

    @Override
    public Iterable<GroupConfig> getByPredicate(Predicate<GroupConfig> predicate) throws DalException {
        throw new NotImplementedException("This method is not implemented.");
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<GroupConfig> getList(Criterion criterion) throws DalException {
        Criteria criteria = this.getCriteriaInstance();
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        if(criterion != null) criteria.add(criterion);
        return criteria.list();
    }

    @Override
    public Criteria getCriteriaInstance() throws DalException {
        return this.getCurrentSession().createCriteria(GroupConfig.class);
    }

    @Override
    @Transactional(readOnly = true)
    public GroupConfig getById(String id) throws DalException {
        return (GroupConfig) getCurrentSession().get(GroupConfig.class, id);
    }

    @Override
    @Transactional
    public String addResource(GroupConfig groupConfig) throws DalException {
        try {
            getCurrentSession().save(groupConfig);
            return groupConfig.getId();
        } catch (Exception e){
            logger.error(e.getMessage(), e);
            throw new DalException("Failed to add hiera.", e);
        }
    }

    @Override
    @Transactional
    public String updateResource(GroupConfig groupConfig) throws DalException {
        try {
            getCurrentSession().update(groupConfig);
            return groupConfig.getId();
        } catch (Exception e){
            logger.error(e.getMessage(), e);
            throw new DalException("Failed to update GroupConfig.", e);
        }
    }

    @Override
    @Transactional
    public String saveOrUpdateResource(GroupConfig groupConfig) throws DalException {
        try {
            getCurrentSession().saveOrUpdate(groupConfig);
            return groupConfig.getId();
        } catch (Exception e){
            logger.error(e.getMessage(), e);
            throw new DalException("Failed to update GroupConfig.", e);
        }
    }

    @Override
    @Transactional
    public void deleteResource(GroupConfig groupConfig) throws DalException {
        try {
            getCurrentSession().delete(groupConfig);
        } catch (Exception e){
            logger.error(e.getMessage(), e);
            throw new DalException("Failed to delete GroupConfig.", e);
        }
    }
}
