
package com.paypal.location.config.app;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 *                 This will contain the details for SSH connectivity
 *             
 * 
 * <p>Java class for SshConfigType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SshConfigType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="remoteUsername" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="privateKeyFilePath" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="knownHostsFilePath" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="addHostToKnownHostsFile" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="sessionTimeout" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SshConfigType", namespace = "http://andera.com/infra/application.xsd", propOrder = {
    "remoteUsername",
    "privateKeyFilePath",
    "knownHostsFilePath",
    "addHostToKnownHostsFile",
    "sessionTimeout"
})
public class SshConfigType {

    @XmlElement(required = true)
    protected String remoteUsername;
    protected String privateKeyFilePath;
    protected String knownHostsFilePath;
    @XmlElement(defaultValue = "true")
    protected Boolean addHostToKnownHostsFile;
    protected Integer sessionTimeout;

    /**
     * Gets the value of the remoteUsername property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRemoteUsername() {
        return remoteUsername;
    }

    /**
     * Sets the value of the remoteUsername property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRemoteUsername(String value) {
        this.remoteUsername = value;
    }

    /**
     * Gets the value of the privateKeyFilePath property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrivateKeyFilePath() {
        return privateKeyFilePath;
    }

    /**
     * Sets the value of the privateKeyFilePath property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrivateKeyFilePath(String value) {
        this.privateKeyFilePath = value;
    }

    /**
     * Gets the value of the knownHostsFilePath property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKnownHostsFilePath() {
        return knownHostsFilePath;
    }

    /**
     * Sets the value of the knownHostsFilePath property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKnownHostsFilePath(String value) {
        this.knownHostsFilePath = value;
    }

    /**
     * Gets the value of the addHostToKnownHostsFile property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAddHostToKnownHostsFile() {
        return addHostToKnownHostsFile;
    }

    /**
     * Sets the value of the addHostToKnownHostsFile property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAddHostToKnownHostsFile(Boolean value) {
        this.addHostToKnownHostsFile = value;
    }

    /**
     * Gets the value of the sessionTimeout property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getSessionTimeout() {
        return sessionTimeout;
    }

    /**
     * Sets the value of the sessionTimeout property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSessionTimeout(Integer value) {
        this.sessionTimeout = value;
    }

}
