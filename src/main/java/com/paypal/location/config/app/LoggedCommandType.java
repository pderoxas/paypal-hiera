
package com.paypal.location.config.app;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 *                 This will contain the details for a single SSH Command that has an associated log.
 *                 The LogLocation can b
 *             
 * 
 * <p>Java class for LoggedCommandType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LoggedCommandType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://andera.com/infra/application.xsd}CommandType">
 *       &lt;sequence>
 *         &lt;element name="logLocation" type="{http://andera.com/infra/application.xsd}LogLocationType"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LoggedCommandType", namespace = "http://andera.com/infra/application.xsd", propOrder = {
    "logLocation"
})
public class LoggedCommandType
    extends CommandType
{

    @XmlElement(required = true)
    protected LogLocationType logLocation;

    /**
     * Gets the value of the logLocation property.
     * 
     * @return
     *     possible object is
     *     {@link LogLocationType }
     *     
     */
    public LogLocationType getLogLocation() {
        return logLocation;
    }

    /**
     * Sets the value of the logLocation property.
     * 
     * @param value
     *     allowed object is
     *     {@link LogLocationType }
     *     
     */
    public void setLogLocation(LogLocationType value) {
        this.logLocation = value;
    }

}
