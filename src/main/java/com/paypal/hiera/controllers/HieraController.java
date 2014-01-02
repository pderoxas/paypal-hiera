package com.paypal.hiera.controllers;

import com.paypal.common.exceptions.DalException;
import com.paypal.hiera.exceptions.ResourceNotFoundException;
import com.paypal.hiera.models.HieraData;
import com.paypal.hiera.models.LocationConfig;
import com.paypal.hiera.models.GroupConfig;
import com.paypal.hiera.models.StoreConfig;
import com.paypal.hiera.services.LocationService;
import com.paypal.hiera.services.GroupService;
import com.paypal.hiera.services.StoreService;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created with IntelliJ IDEA.
 * User: pderoxas
 * Date: 8/15/13
 * Time: 9:56 AM
 * Controller class for StoreConfig Resource
 */
@Controller
@RequestMapping("")
public class HieraController {
    private Logger logger = Logger.getLogger(this.getClass());

    @Autowired
    private LocationService locationService;

    @Autowired
    private GroupService groupService;
    
    @Autowired
    private StoreService storeService;


    //GeoLocations===================================================
    @RequestMapping(value = "/hieraData", method = RequestMethod.GET)
    @ResponseBody
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public HieraData getHieraData() throws DalException {
        HieraData hieraData = new HieraData();
        hieraData.setDefaultConfigs(locationService.getLocationByCode(null));
        hieraData.setGroupConfigs(groupService.getAllGroups());
        hieraData.setCustomConfigs(storeService.getAllStores());
        return hieraData;
    }

    //GeoLocations===================================================
    @RequestMapping(value = "/locations", method = RequestMethod.GET)
    @ResponseBody
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public Iterable<LocationConfig> getGeoLocations(@RequestParam(value = "code", required=false) String geoLocationCode) throws DalException {
        return locationService.getLocationByCode(geoLocationCode);
    }

    @RequestMapping(value = "/locations/{id}", method = RequestMethod.GET)
    @ResponseBody
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public LocationConfig getGeoLocation(@PathVariable Integer id) throws DalException, ResourceNotFoundException {
        return locationService.getLocation(id);
    }

    @RequestMapping(value = "/locations", method = RequestMethod.POST)
    public String updateGeoLocation(@RequestBody LocationConfig locationConfig) throws DalException, ResourceNotFoundException {
        String id = locationService.saveLocation(locationConfig).getId();
        return "redirect:/locations/" + id;
    }

    //Groups===================================================
    @RequestMapping(value = "/groups", method = RequestMethod.GET)
    @ResponseBody
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public Iterable<GroupConfig> getGroups() throws DalException {
        return groupService.getAllGroups();
    }

    @RequestMapping(value = "/groups/{id}", method = RequestMethod.GET)
    @ResponseBody
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public GroupConfig getGroup(@PathVariable Integer id) throws DalException, ResourceNotFoundException {
        return groupService.getGroup(id);
    }

    @RequestMapping(value = "/groups", method = RequestMethod.POST)
    public String updateGroup(@RequestBody GroupConfig groupConfig) throws DalException, ResourceNotFoundException {
        String id = groupService.saveGroup(groupConfig).getId();
        return "redirect:/groups/" + id;
    }

    //Stores===================================================
    @RequestMapping(value = "/stores", method = RequestMethod.GET)
    @ResponseBody
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public Iterable<StoreConfig> getStores() throws DalException {
        return storeService.getAllStores();
    }

    @RequestMapping(value = "/stores/{id}", method = RequestMethod.GET)
    @ResponseBody
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public StoreConfig getStore(@PathVariable Integer id) throws DalException, ResourceNotFoundException {
        return storeService.getStore(id);
    }

    @RequestMapping(value = "/stores", method = RequestMethod.POST)
    public String updateStore(@RequestBody StoreConfig storeConfig) throws DalException, ResourceNotFoundException {
        String id = storeService.saveStore(storeConfig).getId();
        return "redirect:/stores/" + id;
    }

}
