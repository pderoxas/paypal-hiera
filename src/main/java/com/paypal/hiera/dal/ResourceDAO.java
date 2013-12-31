package com.paypal.hiera.dal;

import com.paypal.common.exceptions.DalException;
import com.paypal.hiera.models.Resource;
import com.google.common.base.Predicate;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * User: pderoxas
 * Date: 8/30/13
 * Time: 9:48 AM
 * DAO interface for the Resources
 */
@Repository
public interface ResourceDAO<T extends Resource, K extends Serializable> {

    /**
     * Return a List of all instances of a given resource type
     * @return List of Resource Objects
     */
    Iterable<T> getAll() throws DalException;

    /**
     * Return a list of resources given a list of ids
     * @param idList - The list of ids to get
     * @return List of Resource Objects
     */
    Iterable<T> getByIdList(List<K> idList) throws DalException;

    /**
     * Return a list of resources given a Predicate
     * @param predicate - The Predicate object to filter with
     * @return List of Resource Objects
     */
    Iterable<T> getByPredicate(Predicate<T> predicate) throws DalException;


    /**
     * Return a list of resources given a Criteria object
     * @param criteria CriteriaQuery instance
     * @return List of Resource Objects
     * @throws DalException
     */
    Iterable<T> getList(Criteria criteria) throws DalException;

    /**
     * Returns an instance of a Criteria that can be used to
     * set query criteria which can then be passed to the getList(Criteria) method
     * @return Criteria instance
     * @throws DalException
     */
    Criteria getCriteriaInstance() throws DalException;

    /**
     * Return a specific resource object by id
     * @param id - The ID of the resource
     * @return Single Resource Object
     */
    T getById(K id) throws DalException;

    /**
     * Adds a new instance of a resource
     * @param resource - The resource to add
     * @return primary key of the resource
     * @throws DalException
     */
    K addResource(T resource) throws DalException;

    /**
     * Updates an existing instance of a resource
     * @param resource - The resource to update
     * @return primary key of the resource
     * @throws DalException
     */
    K updateResource(T resource) throws DalException;
}
