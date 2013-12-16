package com.paypal.location.models;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

/**
 * Created by pderoxas on 12/16/13.
 */
@Component
@Scope("prototype")
@JsonSerialize(include= JsonSerialize.Inclusion.NON_NULL)
@Qualifier("Location")
public class Location implements Resource<String>  {
    private String id;
    private String name;
    private String description;
    private String version;
    private String scmTag;
    private Collection<Link> links;

    public Location(String id, String version) {
        this.id = id;
        this.version = version;
    }

    public Location(String id, String name, String description, String version, String scmTag) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.version = version;
        this.scmTag = scmTag;
    }

    @Override
    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public Collection<Link> getLinks() {
        this.links = new ArrayList<Link>();
        this.links.add(new Link("location", "/locations/" + id));
        return links;
    }

    public void setLinks(Collection<Link> links) {
        this.links = links;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getScmTag() {
        return scmTag;
    }

    public void setScmTag(String scmTag) {
        this.scmTag = scmTag;
    }
}
