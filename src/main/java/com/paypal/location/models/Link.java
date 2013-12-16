package com.paypal.location.models;

/**
 * User: pderoxas
 * Date: 8/26/13
 * Time: 5:11 PM
 * POJO for link-related attributes
 */
public class Link {
    String resourceType;
    String uri;

    public Link( String resourceType, String uri) {

        this.resourceType = resourceType;
        this.uri = uri;
    }

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }
}
