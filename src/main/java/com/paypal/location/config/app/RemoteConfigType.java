
package com.paypal.location.config.app;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 *                 This will contain the details for the config_*.sh file for the environment
 *             
 * 
 * <p>Java class for RemoteConfigType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RemoteConfigType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="sshConfig" type="{http://andera.com/infra/application.xsd}SshConfigType" minOccurs="0"/>
 *         &lt;element name="host" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="port" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="filePath" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RemoteConfigType", namespace = "http://andera.com/infra/application.xsd", propOrder = {
    "sshConfig",
    "host",
    "port",
    "filePath"
})
public class RemoteConfigType {

    protected SshConfigType sshConfig;
    @XmlElement(required = true)
    protected String host;
    protected int port;
    @XmlElement(required = true)
    protected String filePath;

    /**
     * Gets the value of the sshConfig property.
     * 
     * @return
     *     possible object is
     *     {@link SshConfigType }
     *     
     */
    public SshConfigType getSshConfig() {
        return sshConfig;
    }

    /**
     * Sets the value of the sshConfig property.
     * 
     * @param value
     *     allowed object is
     *     {@link SshConfigType }
     *     
     */
    public void setSshConfig(SshConfigType value) {
        this.sshConfig = value;
    }

    /**
     * Gets the value of the host property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHost() {
        return host;
    }

    /**
     * Sets the value of the host property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHost(String value) {
        this.host = value;
    }

    /**
     * Gets the value of the port property.
     * 
     */
    public int getPort() {
        return port;
    }

    /**
     * Sets the value of the port property.
     * 
     */
    public void setPort(int value) {
        this.port = value;
    }

    /**
     * Gets the value of the filePath property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFilePath() {
        return filePath;
    }

    /**
     * Sets the value of the filePath property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFilePath(String value) {
        this.filePath = value;
    }

}
