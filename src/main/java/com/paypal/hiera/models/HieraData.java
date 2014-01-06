package com.paypal.hiera.models;

/**
 * Created by pderoxas on 1/2/14.
 */
public class HieraData {

    private Iterable<LocationConfig> locationConfigs;
    private Iterable<GroupConfig> groupConfigs;
    private Iterable<StoreConfig> storeConfigs;

    public Iterable<LocationConfig> getLocationConfigs() {
        return locationConfigs;
    }

    public void setLocationConfigs(Iterable<LocationConfig> locationConfigs) {
        this.locationConfigs = locationConfigs;
    }

    public Iterable<GroupConfig> getGroupConfigs() {
        return groupConfigs;
    }

    public void setGroupConfigs(Iterable<GroupConfig> groupConfigs) {
        this.groupConfigs = groupConfigs;
    }

    public Iterable<StoreConfig> getStoreConfigs() {
        return storeConfigs;
    }

    public void setStoreConfigs(Iterable<StoreConfig> storeConfigs) {
        this.storeConfigs = storeConfigs;
    }
}
