
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
 * <p>Java class for ResourceDeploymentType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ResourceDeploymentType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="executeDeployCommandGroup" type="{http://andera.com/infra/application.xsd}SshCommandGroupType"/>
 *         &lt;element name="statusCommandGroup" type="{http://andera.com/infra/application.xsd}SshCommandGroupType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResourceDeploymentType", namespace = "http://andera.com/infra/application.xsd", propOrder = {
    "executeDeployCommandGroup",
    "statusCommandGroup"
})
public class ResourceDeploymentType {

    @XmlElement(required = true)
    protected SshCommandGroupType executeDeployCommandGroup;
    @XmlElement(required = true)
    protected SshCommandGroupType statusCommandGroup;

    /**
     * Gets the value of the executeDeployCommandGroup property.
     * 
     * @return
     *     possible object is
     *     {@link SshCommandGroupType }
     *     
     */
    public SshCommandGroupType getExecuteDeployCommandGroup() {
        return executeDeployCommandGroup;
    }

    /**
     * Sets the value of the executeDeployCommandGroup property.
     * 
     * @param value
     *     allowed object is
     *     {@link SshCommandGroupType }
     *     
     */
    public void setExecuteDeployCommandGroup(SshCommandGroupType value) {
        this.executeDeployCommandGroup = value;
    }

    /**
     * Gets the value of the statusCommandGroup property.
     * 
     * @return
     *     possible object is
     *     {@link SshCommandGroupType }
     *     
     */
    public SshCommandGroupType getStatusCommandGroup() {
        return statusCommandGroup;
    }

    /**
     * Sets the value of the statusCommandGroup property.
     * 
     * @param value
     *     allowed object is
     *     {@link SshCommandGroupType }
     *     
     */
    public void setStatusCommandGroup(SshCommandGroupType value) {
        this.statusCommandGroup = value;
    }

}
