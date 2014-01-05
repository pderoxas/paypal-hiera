package com.paypal.hiera.models;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "location_config" )
@Scope("prototype")
@JsonSerialize(include= JsonSerialize.Inclusion.NON_NULL)
@Qualifier("LocationConfig")
public class LocationConfig implements Resource<String> {
    @Id
    @Column(name="id", nullable=false)
    private String id;

    @ManyToOne
    @JoinColumn(name="sdk_release_id",
            insertable=false, updatable=false,
            nullable=false)
    private SdkRelease sdk;

    @Column(name="root_dir", nullable=false)
    private String rootDir;

    @Column(name="description", nullable=false)
    private String description;

    @Override
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRootDir() {
        return rootDir;
    }

    public void setRootDir(String rootDir) {
        this.rootDir = rootDir;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public SdkRelease getSdk() { return sdk; }

    public void setSdk(SdkRelease sdk) { this.sdk = sdk; }
}
