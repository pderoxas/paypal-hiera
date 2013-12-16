
package com.paypal.location.config.app;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 *                 This will contain the properties required to parse the config_*.sh files
 *             
 * 
 * <p>Java class for ConfigParsingType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ConfigParsingType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="commandFormat" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="hostNameCaseStartPattern" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="hostNameCaseEndPattern" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="hostNamePattern" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="appInstancePattern" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConfigParsingType", namespace = "http://andera.com/infra/application.xsd", propOrder = {
    "commandFormat",
    "hostNameCaseStartPattern",
    "hostNameCaseEndPattern",
    "hostNamePattern",
    "appInstancePattern"
})
public class ConfigParsingType {

    @XmlElement(required = true)
    protected String commandFormat;
    @XmlElement(required = true)
    protected String hostNameCaseStartPattern;
    @XmlElement(required = true)
    protected String hostNameCaseEndPattern;
    @XmlElement(required = true)
    protected String hostNamePattern;
    @XmlElement(required = true)
    protected String appInstancePattern;

    /**
     * Gets the value of the commandFormat property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCommandFormat() {
        return commandFormat;
    }

    /**
     * Sets the value of the commandFormat property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCommandFormat(String value) {
        this.commandFormat = value;
    }

    /**
     * Gets the value of the hostNameCaseStartPattern property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHostNameCaseStartPattern() {
        return hostNameCaseStartPattern;
    }

    /**
     * Sets the value of the hostNameCaseStartPattern property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHostNameCaseStartPattern(String value) {
        this.hostNameCaseStartPattern = value;
    }

    /**
     * Gets the value of the hostNameCaseEndPattern property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHostNameCaseEndPattern() {
        return hostNameCaseEndPattern;
    }

    /**
     * Sets the value of the hostNameCaseEndPattern property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHostNameCaseEndPattern(String value) {
        this.hostNameCaseEndPattern = value;
    }

    /**
     * Gets the value of the hostNamePattern property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHostNamePattern() {
        return hostNamePattern;
    }

    /**
     * Sets the value of the hostNamePattern property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHostNamePattern(String value) {
        this.hostNamePattern = value;
    }

    /**
     * Gets the value of the appInstancePattern property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAppInstancePattern() {
        return appInstancePattern;
    }

    /**
     * Sets the value of the appInstancePattern property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAppInstancePattern(String value) {
        this.appInstancePattern = value;
    }

}
