package com.paypal.hiera.models;

import java.util.List;

/**
 * Created by pderoxas on 1/2/14.
 */
public class HieraData {

    private Iterable<LocationConfig> defaultConfigs;
    private Iterable<GroupConfig> groupConfigs;
    private Iterable<StoreConfig> customConfigs;

    public Iterable<LocationConfig> getDefaultConfigs() {
        return defaultConfigs;
    }

    public void setDefaultConfigs(Iterable<LocationConfig> defaultConfigs) {
        this.defaultConfigs = defaultConfigs;
    }

    public Iterable<GroupConfig> getGroupConfigs() {
        return groupConfigs;
    }

    public void setGroupConfigs(Iterable<GroupConfig> groupConfigs) {
        this.groupConfigs = groupConfigs;
    }

    public Iterable<StoreConfig> getCustomConfigs() {
        return customConfigs;
    }

    public void setCustomConfigs(Iterable<StoreConfig> customConfigs) {
        this.customConfigs = customConfigs;
    }
}
