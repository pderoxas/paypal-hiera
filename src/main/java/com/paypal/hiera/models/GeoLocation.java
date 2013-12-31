package com.paypal.hiera.models;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "geo_location")
@Scope("prototype")
@JsonSerialize(include= JsonSerialize.Inclusion.NON_NULL)
@Qualifier("GeoLocation")
public class GeoLocation implements Resource<Integer> {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="id", nullable=false)
    private Integer id;

    @Column(name="code", nullable=false)
    private String code;

    @Column(name="name", nullable=false)
    private String name;

    @Column(name="description", nullable=false)
    private String description;

    @OneToOne
    @JoinColumn(name="sdk_id")
    private Sdk sdk;

    @OneToMany (targetEntity = Store.class, fetch = FetchType.EAGER, mappedBy = "geo_location_id")
    private Set<Store> stores;

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Sdk getSdk() {
        return sdk;
    }

    public void setSdk(Sdk sdk) {
        this.sdk = sdk;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Set<Store> getStores() {
        return stores;
    }

    public void setStores(Set<Store> stores) {
        this.stores = stores;
    }
}
