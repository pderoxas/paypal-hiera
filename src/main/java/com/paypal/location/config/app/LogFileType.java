
package com.paypal.location.config.app;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 *                 This will contain the properties required read the contents of log files
 *             
 * 
 * <p>Java class for LogFileType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LogFileType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="fetchAllLinesCommandGroup" type="{http://andera.com/infra/application.xsd}SshCommandGroupType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LogFileType", namespace = "http://andera.com/infra/application.xsd", propOrder = {
    "fetchAllLinesCommandGroup"
})
public class LogFileType {

    @XmlElement(required = true)
    protected SshCommandGroupType fetchAllLinesCommandGroup;

    /**
     * Gets the value of the fetchAllLinesCommandGroup property.
     * 
     * @return
     *     possible object is
     *     {@link SshCommandGroupType }
     *     
     */
    public SshCommandGroupType getFetchAllLinesCommandGroup() {
        return fetchAllLinesCommandGroup;
    }

    /**
     * Sets the value of the fetchAllLinesCommandGroup property.
     * 
     * @param value
     *     allowed object is
     *     {@link SshCommandGroupType }
     *     
     */
    public void setFetchAllLinesCommandGroup(SshCommandGroupType value) {
        this.fetchAllLinesCommandGroup = value;
    }

}
