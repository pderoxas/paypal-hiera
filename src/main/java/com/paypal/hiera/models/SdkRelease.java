package com.paypal.hiera.models;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;

import javax.persistence.*;

@Entity
@Table(name = "sdk_release")
@Scope("prototype")
@JsonSerialize(include= JsonSerialize.Inclusion.NON_NULL)
@Qualifier("SdkRelease")
public class SdkRelease implements Resource<Integer> {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id", nullable=false)
    private Integer id;

    @Column(name="version", nullable=false)
    private String version;

    @Column(name="platform", nullable=false)
    private String platform;

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

}
