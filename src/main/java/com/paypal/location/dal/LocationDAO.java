package com.paypal.location.dal;

import com.paypal.common.exceptions.DalException;
import com.google.common.base.Predicate;
import com.paypal.common.utils.StringUtils;
import com.paypal.location.exceptions.ExceptionCode;
import com.paypal.location.exceptions.ResourceNotFoundException;
import com.paypal.location.models.Location;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * User: pderoxas
 * Date: 8/30/13
 * Time: 10:05 AM
 * DAO Implementation for Resource
 */
@Repository
@Qualifier("LocationDAO")
public class LocationDAO implements ResourceDAO<Location, String> {
    private Logger logger = Logger.getLogger(this.getClass());

    @Autowired
    private Properties runtimeProperties;

    @Override
    public List<Location> getAll() throws DalException {
        //Hard-coded - could pull from database, xml, json, etc....
        List<Location> locations = new ArrayList<Location>();
        try {
            String locationPropertiesFile = runtimeProperties.getProperty("location.properties.file");

            logger.debug("####################### locationPropertiesFile: " + locationPropertiesFile + "#######################");

            InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(locationPropertiesFile);
            Reader reader = new InputStreamReader(inputStream);

            JSONParser parser = new JSONParser();
            Object obj = null;
            obj = parser.parse(reader);
            JSONArray locationData = (JSONArray) obj;
            for(Object location : locationData){
                JSONObject fileObject = (JSONObject) location;
                String curId = (String) fileObject.get("id");
                String scmTag = (String) fileObject.get("scmTag");
                locations.add(new Location(curId, scmTag));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return locations;
    }

    @Override
    public Iterable<Location> getByIdList(List<String> idList) throws DalException {
        return null;
    }

    @Override
    public Iterable<Location> getByPredicate(Predicate<Location> predicate) throws DalException {
        return null;
    }

    @Override
    public Iterable<Location> getList(Criteria criteria) throws DalException {
        return null;
    }

    @Override
    public Criteria getCriteriaInstance() throws DalException {
        return null;
    }

    @Override
    public Location getById(String id) throws DalException {
        //Hard-coded - could pull from database, xml, json, etc....
        String scmTag = "v1.2.0";
        try {
            String locationPropertiesFile = runtimeProperties.getProperty("location.properties.file");

            logger.debug("####################### locationPropertiesFile: " + locationPropertiesFile + "#######################");

            InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(locationPropertiesFile);
            Reader reader = new InputStreamReader(inputStream);

            JSONParser parser = new JSONParser();
            Object obj = null;
            obj = parser.parse(reader);
            JSONArray locations = (JSONArray) obj;
            for(Object location : locations){
                JSONObject fileObject = (JSONObject) location;
                String curId = (String) fileObject.get("id");
                if(StringUtils.trim(id).equals(StringUtils.trim(curId))){
                    scmTag = (String) fileObject.get("scmTag");
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new Location(id, scmTag);
    }

    @Override
    public String addResource(Location resource) throws DalException {
        return null;
    }

    @Override
    public String updateResource(Location resource) throws DalException {
        return null;
    }
}
