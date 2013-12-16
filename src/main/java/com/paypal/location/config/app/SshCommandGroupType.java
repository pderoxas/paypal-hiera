
package com.paypal.location.config.app;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 *                 This will contain the details for one to many SSH commands that share a single ssh session.
 *             
 * 
 * <p>Java class for SshCommandGroupType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SshCommandGroupType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="sshConfig" type="{http://andera.com/infra/application.xsd}SshConfigType" minOccurs="0"/>
 *         &lt;element name="command" type="{http://andera.com/infra/application.xsd}CommandType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="loggedCommand" type="{http://andera.com/infra/application.xsd}LoggedCommandType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SshCommandGroupType", namespace = "http://andera.com/infra/application.xsd", propOrder = {
    "sshConfig",
    "command",
    "loggedCommand"
})
public class SshCommandGroupType {

    protected SshConfigType sshConfig;
    protected List<CommandType> command;
    protected List<LoggedCommandType> loggedCommand;

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
     * Gets the value of the command property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the command property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCommand().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CommandType }
     * 
     * 
     */
    public List<CommandType> getCommand() {
        if (command == null) {
            command = new ArrayList<CommandType>();
        }
        return this.command;
    }

    /**
     * Gets the value of the loggedCommand property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the loggedCommand property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLoggedCommand().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LoggedCommandType }
     * 
     * 
     */
    public List<LoggedCommandType> getLoggedCommand() {
        if (loggedCommand == null) {
            loggedCommand = new ArrayList<LoggedCommandType>();
        }
        return this.loggedCommand;
    }

}
