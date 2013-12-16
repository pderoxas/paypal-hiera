
package com.paypal.location.config.app;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 *                     This schema shall provide configuration details for the com.paypal.location-console
 *                 
 * 
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="defaultSshConfig" type="{http://andera.com/infra/application.xsd}SshConfigType"/>
 *         &lt;element name="opsConsoleDataSource" type="{http://andera.com/infra/application.xsd}DataSourceConfigType"/>
 *         &lt;element name="configParsing" type="{http://andera.com/infra/application.xsd}ConfigParsingType"/>
 *         &lt;element name="managedEnvironment" type="{http://andera.com/infra/application.xsd}ManagedEnvironmentType" maxOccurs="unbounded"/>
 *         &lt;element name="server" type="{http://andera.com/infra/application.xsd}ServerType"/>
 *         &lt;element name="appInstance" type="{http://andera.com/infra/application.xsd}AppInstanceType"/>
 *         &lt;element name="appInstanceCommand" type="{http://andera.com/infra/application.xsd}AppInstanceCommandType"/>
 *         &lt;element name="deployment" type="{http://andera.com/infra/application.xsd}DeploymentType"/>
 *         &lt;element name="logFile" type="{http://andera.com/infra/application.xsd}LogFileType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "defaultSshConfig",
    "opsConsoleDataSource",
    "configParsing",
    "managedEnvironment",
    "server",
    "appInstance",
    "appInstanceCommand",
    "deployment",
    "logFile"
})
@XmlRootElement(name = "applicationConfig", namespace = "http://andera.com/infra/application.xsd")
public class ApplicationConfig {

    @XmlElement(required = true)
    protected SshConfigType defaultSshConfig;
    @XmlElement(required = true)
    protected DataSourceConfigType opsConsoleDataSource;
    @XmlElement(required = true)
    protected ConfigParsingType configParsing;
    @XmlElement(required = true)
    protected List<ManagedEnvironmentType> managedEnvironment;
    @XmlElement(required = true)
    protected ServerType server;
    @XmlElement(required = true)
    protected AppInstanceType appInstance;
    @XmlElement(required = true)
    protected AppInstanceCommandType appInstanceCommand;
    @XmlElement(required = true)
    protected DeploymentType deployment;
    @XmlElement(required = true)
    protected LogFileType logFile;

    /**
     * Gets the value of the defaultSshConfig property.
     * 
     * @return
     *     possible object is
     *     {@link SshConfigType }
     *     
     */
    public SshConfigType getDefaultSshConfig() {
        return defaultSshConfig;
    }

    /**
     * Sets the value of the defaultSshConfig property.
     * 
     * @param value
     *     allowed object is
     *     {@link SshConfigType }
     *     
     */
    public void setDefaultSshConfig(SshConfigType value) {
        this.defaultSshConfig = value;
    }

    /**
     * Gets the value of the opsConsoleDataSource property.
     * 
     * @return
     *     possible object is
     *     {@link DataSourceConfigType }
     *     
     */
    public DataSourceConfigType getOpsConsoleDataSource() {
        return opsConsoleDataSource;
    }

    /**
     * Sets the value of the opsConsoleDataSource property.
     * 
     * @param value
     *     allowed object is
     *     {@link DataSourceConfigType }
     *     
     */
    public void setOpsConsoleDataSource(DataSourceConfigType value) {
        this.opsConsoleDataSource = value;
    }

    /**
     * Gets the value of the configParsing property.
     * 
     * @return
     *     possible object is
     *     {@link ConfigParsingType }
     *     
     */
    public ConfigParsingType getConfigParsing() {
        return configParsing;
    }

    /**
     * Sets the value of the configParsing property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConfigParsingType }
     *     
     */
    public void setConfigParsing(ConfigParsingType value) {
        this.configParsing = value;
    }

    /**
     * Gets the value of the managedEnvironment property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the managedEnvironment property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getManagedEnvironment().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ManagedEnvironmentType }
     * 
     * 
     */
    public List<ManagedEnvironmentType> getManagedEnvironment() {
        if (managedEnvironment == null) {
            managedEnvironment = new ArrayList<ManagedEnvironmentType>();
        }
        return this.managedEnvironment;
    }

    /**
     * Gets the value of the server property.
     * 
     * @return
     *     possible object is
     *     {@link ServerType }
     *     
     */
    public ServerType getServer() {
        return server;
    }

    /**
     * Sets the value of the server property.
     * 
     * @param value
     *     allowed object is
     *     {@link ServerType }
     *     
     */
    public void setServer(ServerType value) {
        this.server = value;
    }

    /**
     * Gets the value of the appInstance property.
     * 
     * @return
     *     possible object is
     *     {@link AppInstanceType }
     *     
     */
    public AppInstanceType getAppInstance() {
        return appInstance;
    }

    /**
     * Sets the value of the appInstance property.
     * 
     * @param value
     *     allowed object is
     *     {@link AppInstanceType }
     *     
     */
    public void setAppInstance(AppInstanceType value) {
        this.appInstance = value;
    }

    /**
     * Gets the value of the appInstanceCommand property.
     * 
     * @return
     *     possible object is
     *     {@link AppInstanceCommandType }
     *     
     */
    public AppInstanceCommandType getAppInstanceCommand() {
        return appInstanceCommand;
    }

    /**
     * Sets the value of the appInstanceCommand property.
     * 
     * @param value
     *     allowed object is
     *     {@link AppInstanceCommandType }
     *     
     */
    public void setAppInstanceCommand(AppInstanceCommandType value) {
        this.appInstanceCommand = value;
    }

    /**
     * Gets the value of the deployment property.
     * 
     * @return
     *     possible object is
     *     {@link DeploymentType }
     *     
     */
    public DeploymentType getDeployment() {
        return deployment;
    }

    /**
     * Sets the value of the deployment property.
     * 
     * @param value
     *     allowed object is
     *     {@link DeploymentType }
     *     
     */
    public void setDeployment(DeploymentType value) {
        this.deployment = value;
    }

    /**
     * Gets the value of the logFile property.
     * 
     * @return
     *     possible object is
     *     {@link LogFileType }
     *     
     */
    public LogFileType getLogFile() {
        return logFile;
    }

    /**
     * Sets the value of the logFile property.
     * 
     * @param value
     *     allowed object is
     *     {@link LogFileType }
     *     
     */
    public void setLogFile(LogFileType value) {
        this.logFile = value;
    }

}
