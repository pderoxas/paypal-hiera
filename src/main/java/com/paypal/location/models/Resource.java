package com.paypal.location.models;

import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: dev
 * Date: 9/20/13
 * Time: 11:17 PM
 * To change this template use File | Settings | File Templates.
 */
public interface Resource<K> {
    public K getId();
    public Collection<Link> getLinks();
}
