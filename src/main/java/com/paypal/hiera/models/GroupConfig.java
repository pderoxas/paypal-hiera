package com.paypal.hiera.models;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;

import javax.persistence.*;

@Entity
@Table(name = "group_config" )
@Scope("prototype")
@JsonSerialize(include= JsonSerialize.Inclusion.NON_NULL)
@Qualifier("GroupConfig")
public class GroupConfig implements Resource<String> {
    @Id
    @Column(name="id", nullable=false)
    private String id;

    @Column(name="sdk_release_id", nullable=false)
    private int sdkReleaseId;

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

    public int getSdkReleaseId() {
        return sdkReleaseId;
    }

    public void setSdkReleaseId(int sdkReleaseId) {
        this.sdkReleaseId = sdkReleaseId;
    }
}
