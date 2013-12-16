
package com.paypal.location.config.app;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 *                 This will contain the properties required to query/get information associated to a Deployment Resources
 *             
 * 
 * <p>Java class for ServerType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ServerType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="occupiedSlotsCommandGroup" type="{http://andera.com/infra/application.xsd}SshCommandGroupType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ServerType", namespace = "http://andera.com/infra/application.xsd", propOrder = {
    "occupiedSlotsCommandGroup"
})
public class ServerType {

    @XmlElement(required = true)
    protected SshCommandGroupType occupiedSlotsCommandGroup;

    /**
     * Gets the value of the occupiedSlotsCommandGroup property.
     * 
     * @return
     *     possible object is
     *     {@link SshCommandGroupType }
     *     
     */
    public SshCommandGroupType getOccupiedSlotsCommandGroup() {
        return occupiedSlotsCommandGroup;
    }

    /**
     * Sets the value of the occupiedSlotsCommandGroup property.
     * 
     * @param value
     *     allowed object is
     *     {@link SshCommandGroupType }
     *     
     */
    public void setOccupiedSlotsCommandGroup(SshCommandGroupType value) {
        this.occupiedSlotsCommandGroup = value;
    }

}
