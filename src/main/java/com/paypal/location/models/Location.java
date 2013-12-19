package com.paypal.location.models;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
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
    private String scmTag;;

    public Location(String id, String scmTag) {
        this.id = id;
        this.scmTag = scmTag;

    }

    @Override
    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getScmTag() {
        return scmTag;
    }

    public void setScmTag(String scmTag) {
        this.scmTag = scmTag;
    }
}
