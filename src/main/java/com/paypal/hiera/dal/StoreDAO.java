package com.paypal.hiera.dal;

import com.paypal.common.exceptions.DalException;
import com.google.common.base.Predicate;
import com.paypal.hiera.models.Store;
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
@Qualifier("StoreDAO")
@Transactional

public class StoreDAO implements ResourceDAO<Store, Integer> {
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
    public Iterable<Store> getAll() throws DalException {
        return this.getList(null);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Store> getByIdList(List<Integer> idList) throws DalException {
        return this.getList(Restrictions.in("id", idList));
    }

    @Override
    public Iterable<Store> getByPredicate(Predicate<Store> predicate) throws DalException {
        throw new NotImplementedException("This method is not implemented.");
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Store> getList(Criterion criterion) throws DalException {
        Criteria criteria = this.getCriteriaInstance();
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        if(criterion != null) criteria.add(criterion);
        return criteria.list();
    }

    @Override
    public Criteria getCriteriaInstance() throws DalException {
        return this.getCurrentSession().createCriteria(Store.class);
    }

    @Override
    @Transactional(readOnly = true)
    public Store getById(Integer id) throws DalException {
        return (Store) getCurrentSession().get(Store.class, id);
    }

    @Override
    @Transactional
    public Integer addResource(Store store) throws DalException {
        try {
            getCurrentSession().save(store);
            return store.getId();
        } catch (Exception e){
            logger.error(e.getMessage(), e);
            throw new DalException("Failed to add hiera.", e);
        }
    }

    @Override
    @Transactional
    public Integer updateResource(Store store) throws DalException {
        try {
            getCurrentSession().update(store);
            return store.getId();
        } catch (Exception e){
            logger.error(e.getMessage(), e);
            throw new DalException("Failed to update hiera.", e);
        }
    }
}
