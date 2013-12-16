
package com.paypal.location.config.app;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 *                 This will contain the properties related to the location of a log file
 *             
 * 
 * <p>Java class for LogLocationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LogLocationType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="logFileDirectory" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="logFileName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LogLocationType", namespace = "http://andera.com/infra/application.xsd", propOrder = {
    "logFileDirectory",
    "logFileName"
})
public class LogLocationType {

    @XmlElement(required = true)
    protected String logFileDirectory;
    @XmlElement(required = true)
    protected String logFileName;

    /**
     * Gets the value of the logFileDirectory property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLogFileDirectory() {
        return logFileDirectory;
    }

    /**
     * Sets the value of the logFileDirectory property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLogFileDirectory(String value) {
        this.logFileDirectory = value;
    }

    /**
     * Gets the value of the logFileName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLogFileName() {
        return logFileName;
    }

    /**
     * Sets the value of the logFileName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLogFileName(String value) {
        this.logFileName = value;
    }

}
