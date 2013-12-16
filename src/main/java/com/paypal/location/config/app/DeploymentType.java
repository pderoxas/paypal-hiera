
package com.paypal.location.config.app;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 *                 This will contain the properties required perform a deployment of a client to an environment
 *             
 * 
 * <p>Java class for DeploymentType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DeploymentType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="maxEligibleToProcessTimeInMs" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="skinsDeployment" type="{http://andera.com/infra/application.xsd}ResourceDeploymentType"/>
 *         &lt;element name="nonSkinsDeployment" type="{http://andera.com/infra/application.xsd}ResourceDeploymentType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DeploymentType", namespace = "http://andera.com/infra/application.xsd", propOrder = {
    "maxEligibleToProcessTimeInMs",
    "skinsDeployment",
    "nonSkinsDeployment"
})
public class DeploymentType {

    protected long maxEligibleToProcessTimeInMs;
    @XmlElement(required = true)
    protected ResourceDeploymentType skinsDeployment;
    @XmlElement(required = true)
    protected ResourceDeploymentType nonSkinsDeployment;

    /**
     * Gets the value of the maxEligibleToProcessTimeInMs property.
     * 
     */
    public long getMaxEligibleToProcessTimeInMs() {
        return maxEligibleToProcessTimeInMs;
    }

    /**
     * Sets the value of the maxEligibleToProcessTimeInMs property.
     * 
     */
    public void setMaxEligibleToProcessTimeInMs(long value) {
        this.maxEligibleToProcessTimeInMs = value;
    }

    /**
     * Gets the value of the skinsDeployment property.
     * 
     * @return
     *     possible object is
     *     {@link ResourceDeploymentType }
     *     
     */
    public ResourceDeploymentType getSkinsDeployment() {
        return skinsDeployment;
    }

    /**
     * Sets the value of the skinsDeployment property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResourceDeploymentType }
     *     
     */
    public void setSkinsDeployment(ResourceDeploymentType value) {
        this.skinsDeployment = value;
    }

    /**
     * Gets the value of the nonSkinsDeployment property.
     * 
     * @return
     *     possible object is
     *     {@link ResourceDeploymentType }
     *     
     */
    public ResourceDeploymentType getNonSkinsDeployment() {
        return nonSkinsDeployment;
    }

    /**
     * Sets the value of the nonSkinsDeployment property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResourceDeploymentType }
     *     
     */
    public void setNonSkinsDeployment(ResourceDeploymentType value) {
        this.nonSkinsDeployment = value;
    }

}
