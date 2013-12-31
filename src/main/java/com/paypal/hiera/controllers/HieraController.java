package com.paypal.hiera.controllers;

import com.paypal.common.exceptions.DalException;
import com.paypal.hiera.exceptions.ResourceNotFoundException;
import com.paypal.hiera.models.GeoLocation;
import com.paypal.hiera.models.Sdk;
import com.paypal.hiera.models.Store;
import com.paypal.hiera.services.GeoLocationService;
import com.paypal.hiera.services.SdkService;
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
 * Controller class for Store Resource
 */
@Controller
@RequestMapping("")
public class HieraController {
    private Logger logger = Logger.getLogger(this.getClass());

    @Autowired
    private GeoLocationService geoLocationService;

    @Autowired
    private StoreService storeService;

    @Autowired
    private SdkService sdkService;

    @RequestMapping(value = "/geoLocations", method = RequestMethod.GET)
    @ResponseBody
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public Iterable<GeoLocation> getGeoLocations(@RequestParam(value = "code", required=false) String geoLocationCode) throws DalException {
        return geoLocationService.getGeoLocationByCode(geoLocationCode);
    }

    @RequestMapping(value = "/geoLocations/{id}", method = RequestMethod.GET)
    @ResponseBody
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public GeoLocation getGeoLocation(@PathVariable Integer id) throws DalException, ResourceNotFoundException {
        return geoLocationService.getGeoLocation(id);
    }

    @RequestMapping(value = "/geoLocations", method = RequestMethod.POST)
    public String updateGeoLocation(@RequestBody GeoLocation geoLocation) throws DalException, ResourceNotFoundException {
        int id = geoLocationService.saveGeoLocation(geoLocation).getId();
        return "redirect:/geoLocations/" + id;
    }

    @RequestMapping(value = "/stores", method = RequestMethod.GET)
    @ResponseBody
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public Iterable<Store> getStores() throws DalException {
        return storeService.getAllStores();
    }

    @RequestMapping(value = "/stores/{id}", method = RequestMethod.GET)
    @ResponseBody
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public Store getStore(@PathVariable Integer id) throws DalException, ResourceNotFoundException {
        return storeService.getStore(id);
    }

    @RequestMapping(value = "/stores", method = RequestMethod.POST)
    public String updateStore(@RequestBody Store store) throws DalException, ResourceNotFoundException {
        int id = storeService.saveStore(store).getId();
        return "redirect:/stores/" + id;
    }

    @RequestMapping(value = "/sdks", method = RequestMethod.GET)
    @ResponseBody
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public Iterable<Sdk> getSdks() throws DalException {
        return sdkService.getAllSdks();
    }

    @RequestMapping(value = "/sdks/{id}", method = RequestMethod.GET)
    @ResponseBody
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public Sdk getSdk(@PathVariable Integer id) throws DalException, ResourceNotFoundException {
        return sdkService.getSdk(id);
    }

    @RequestMapping(value = "/sdks", method = RequestMethod.POST)
    public String updateSdk(@RequestBody Sdk sdk) throws DalException, ResourceNotFoundException {
        int id = sdkService.saveSdk(sdk).getId();
        return "redirect:/sdks/" + id;
    }
}
