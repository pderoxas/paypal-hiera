
package com.paypal.location.config.app;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AppInstanceCommandType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AppInstanceCommandType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="sshConfig" type="{http://andera.com/infra/application.xsd}SshConfigType"/>
 *         &lt;element name="startCommandGroup" type="{http://andera.com/infra/application.xsd}SshCommandGroupType"/>
 *         &lt;element name="restartCommandGroup" type="{http://andera.com/infra/application.xsd}SshCommandGroupType"/>
 *         &lt;element name="stopCommandGroup" type="{http://andera.com/infra/application.xsd}SshCommandGroupType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AppInstanceCommandType", namespace = "http://andera.com/infra/application.xsd", propOrder = {
    "sshConfig",
    "startCommandGroup",
    "restartCommandGroup",
    "stopCommandGroup"
})
public class AppInstanceCommandType {

    @XmlElement(required = true)
    protected SshConfigType sshConfig;
    @XmlElement(required = true)
    protected SshCommandGroupType startCommandGroup;
    @XmlElement(required = true)
    protected SshCommandGroupType restartCommandGroup;
    @XmlElement(required = true)
    protected SshCommandGroupType stopCommandGroup;

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
     * Gets the value of the startCommandGroup property.
     * 
     * @return
     *     possible object is
     *     {@link SshCommandGroupType }
     *     
     */
    public SshCommandGroupType getStartCommandGroup() {
        return startCommandGroup;
    }

    /**
     * Sets the value of the startCommandGroup property.
     * 
     * @param value
     *     allowed object is
     *     {@link SshCommandGroupType }
     *     
     */
    public void setStartCommandGroup(SshCommandGroupType value) {
        this.startCommandGroup = value;
    }

    /**
     * Gets the value of the restartCommandGroup property.
     * 
     * @return
     *     possible object is
     *     {@link SshCommandGroupType }
     *     
     */
    public SshCommandGroupType getRestartCommandGroup() {
        return restartCommandGroup;
    }

    /**
     * Sets the value of the restartCommandGroup property.
     * 
     * @param value
     *     allowed object is
     *     {@link SshCommandGroupType }
     *     
     */
    public void setRestartCommandGroup(SshCommandGroupType value) {
        this.restartCommandGroup = value;
    }

    /**
     * Gets the value of the stopCommandGroup property.
     * 
     * @return
     *     possible object is
     *     {@link SshCommandGroupType }
     *     
     */
    public SshCommandGroupType getStopCommandGroup() {
        return stopCommandGroup;
    }

    /**
     * Sets the value of the stopCommandGroup property.
     * 
     * @param value
     *     allowed object is
     *     {@link SshCommandGroupType }
     *     
     */
    public void setStopCommandGroup(SshCommandGroupType value) {
        this.stopCommandGroup = value;
    }

}
