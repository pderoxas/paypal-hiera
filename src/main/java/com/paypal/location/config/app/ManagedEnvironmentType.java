
package com.paypal.location.config.app;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 *                 This is the base type for all "environments".
 *             
 * 
 * <p>Java class for ManagedEnvironmentType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ManagedEnvironmentType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="databaseServer" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="maxRunningClientsPerServer" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="deployable" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="operable" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="configLocation">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;choice>
 *                   &lt;element name="remoteConfig" type="{http://andera.com/infra/application.xsd}RemoteConfigType"/>
 *                   &lt;element name="localConfig" type="{http://andera.com/infra/application.xsd}LocalConfigType"/>
 *                 &lt;/choice>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ManagedEnvironmentType", namespace = "http://andera.com/infra/application.xsd", propOrder = {
    "id",
    "databaseServer",
    "maxRunningClientsPerServer",
    "deployable",
    "operable",
    "configLocation"
})
public class ManagedEnvironmentType {

    @XmlElement(required = true)
    protected String id;
    @XmlElement(required = true)
    protected String databaseServer;
    protected int maxRunningClientsPerServer;
    protected boolean deployable;
    protected boolean operable;
    @XmlElement(required = true)
    protected ManagedEnvironmentType.ConfigLocation configLocation;

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the databaseServer property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDatabaseServer() {
        return databaseServer;
    }

    /**
     * Sets the value of the databaseServer property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDatabaseServer(String value) {
        this.databaseServer = value;
    }

    /**
     * Gets the value of the maxRunningClientsPerServer property.
     * 
     */
    public int getMaxRunningClientsPerServer() {
        return maxRunningClientsPerServer;
    }

    /**
     * Sets the value of the maxRunningClientsPerServer property.
     * 
     */
    public void setMaxRunningClientsPerServer(int value) {
        this.maxRunningClientsPerServer = value;
    }

    /**
     * Gets the value of the deployable property.
     * 
     */
    public boolean isDeployable() {
        return deployable;
    }

    /**
     * Sets the value of the deployable property.
     * 
     */
    public void setDeployable(boolean value) {
        this.deployable = value;
    }

    /**
     * Gets the value of the operable property.
     * 
     */
    public boolean isOperable() {
        return operable;
    }

    /**
     * Sets the value of the operable property.
     * 
     */
    public void setOperable(boolean value) {
        this.operable = value;
    }

    /**
     * Gets the value of the configLocation property.
     * 
     * @return
     *     possible object is
     *     {@link ManagedEnvironmentType.ConfigLocation }
     *     
     */
    public ManagedEnvironmentType.ConfigLocation getConfigLocation() {
        return configLocation;
    }

    /**
     * Sets the value of the configLocation property.
     * 
     * @param value
     *     allowed object is
     *     {@link ManagedEnvironmentType.ConfigLocation }
     *     
     */
    public void setConfigLocation(ManagedEnvironmentType.ConfigLocation value) {
        this.configLocation = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;choice>
     *         &lt;element name="remoteConfig" type="{http://andera.com/infra/application.xsd}RemoteConfigType"/>
     *         &lt;element name="localConfig" type="{http://andera.com/infra/application.xsd}LocalConfigType"/>
     *       &lt;/choice>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "remoteConfig",
        "localConfig"
    })
    public static class ConfigLocation {

        protected RemoteConfigType remoteConfig;
        protected LocalConfigType localConfig;

        /**
         * Gets the value of the remoteConfig property.
         * 
         * @return
         *     possible object is
         *     {@link RemoteConfigType }
         *     
         */
        public RemoteConfigType getRemoteConfig() {
            return remoteConfig;
        }

        /**
         * Sets the value of the remoteConfig property.
         * 
         * @param value
         *     allowed object is
         *     {@link RemoteConfigType }
         *     
         */
        public void setRemoteConfig(RemoteConfigType value) {
            this.remoteConfig = value;
        }

        /**
         * Gets the value of the localConfig property.
         * 
         * @return
         *     possible object is
         *     {@link LocalConfigType }
         *     
         */
        public LocalConfigType getLocalConfig() {
            return localConfig;
        }

        /**
         * Sets the value of the localConfig property.
         * 
         * @param value
         *     allowed object is
         *     {@link LocalConfigType }
         *     
         */
        public void setLocalConfig(LocalConfigType value) {
            this.localConfig = value;
        }

    }

}
