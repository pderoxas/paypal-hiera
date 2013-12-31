package com.paypal.hiera.models;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "store")
@Scope("prototype")
@JsonSerialize(include= JsonSerialize.Inclusion.NON_NULL)
@Qualifier("Store")
public class Store implements Resource<Integer> {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="id", nullable=false)
    private Integer id;

    @Column(name="number", nullable=false)
    private String number;

    @Column(name="name", nullable=false)
    private String name;

    @Column(name="description", nullable=false)
    private String description;

    @Column(name="sdk_root_dir", nullable=false)
    private String sdkRootDir;

    @OneToOne
    @JoinColumn(name="sdk_id")
    private Sdk sdk;

    @JoinColumn(name="geo_location_id")
    private int geo_location_id;

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
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

    public int getGeo_location_id() {
        return geo_location_id;
    }

    public void setGeo_location_id(int geo_location_id) {
        this.geo_location_id = geo_location_id;
    }

    public String getSdkRootDir() {
        return sdkRootDir;
    }

    public void setSdkRootDir(String sdkRootDir) {
        this.sdkRootDir = sdkRootDir;
    }
}
