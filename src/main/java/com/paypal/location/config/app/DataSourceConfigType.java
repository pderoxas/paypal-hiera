
package com.paypal.location.config.app;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 *                 This will contain the details for the configuring a datasource object
 * 
 *                 dataSource.setDriverClass("com.mysql.jdbc.Driver");
 *                 dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/ops_console");
 *                 dataSource.setUsername("root");
 *                 dataSource.setPassword("Andera123");
 *                 dataSource.setPartitionCount(5);
 *                 dataSource.setMinConnectionsPerPartition(5);
 *                 dataSource.setMaxConnectionsPerPartition(10);
 *                 dataSource.setConnectionTimeoutInMs(5000);
 * 
 *             
 * 
 * <p>Java class for DataSourceConfigType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DataSourceConfigType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="driverClass" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="url" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="username" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="password" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="connectionTimeoutInMs" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="partitionCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="minConnectionsPerPartition" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="maxConnectionsPerPartition" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DataSourceConfigType", namespace = "http://andera.com/infra/application.xsd", propOrder = {
    "driverClass",
    "url",
    "username",
    "password",
    "connectionTimeoutInMs",
    "partitionCount",
    "minConnectionsPerPartition",
    "maxConnectionsPerPartition"
})
public class DataSourceConfigType {

    @XmlElement(required = true)
    protected String driverClass;
    @XmlElement(required = true)
    protected String url;
    @XmlElement(required = true)
    protected String username;
    @XmlElement(required = true)
    protected String password;
    protected long connectionTimeoutInMs;
    protected int partitionCount;
    protected int minConnectionsPerPartition;
    protected int maxConnectionsPerPartition;

    /**
     * Gets the value of the driverClass property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDriverClass() {
        return driverClass;
    }

    /**
     * Sets the value of the driverClass property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDriverClass(String value) {
        this.driverClass = value;
    }

    /**
     * Gets the value of the url property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUrl() {
        return url;
    }

    /**
     * Sets the value of the url property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUrl(String value) {
        this.url = value;
    }

    /**
     * Gets the value of the username property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the value of the username property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsername(String value) {
        this.username = value;
    }

    /**
     * Gets the value of the password property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the value of the password property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPassword(String value) {
        this.password = value;
    }

    /**
     * Gets the value of the connectionTimeoutInMs property.
     * 
     */
    public long getConnectionTimeoutInMs() {
        return connectionTimeoutInMs;
    }

    /**
     * Sets the value of the connectionTimeoutInMs property.
     * 
     */
    public void setConnectionTimeoutInMs(long value) {
        this.connectionTimeoutInMs = value;
    }

    /**
     * Gets the value of the partitionCount property.
     * 
     */
    public int getPartitionCount() {
        return partitionCount;
    }

    /**
     * Sets the value of the partitionCount property.
     * 
     */
    public void setPartitionCount(int value) {
        this.partitionCount = value;
    }

    /**
     * Gets the value of the minConnectionsPerPartition property.
     * 
     */
    public int getMinConnectionsPerPartition() {
        return minConnectionsPerPartition;
    }

    /**
     * Sets the value of the minConnectionsPerPartition property.
     * 
     */
    public void setMinConnectionsPerPartition(int value) {
        this.minConnectionsPerPartition = value;
    }

    /**
     * Gets the value of the maxConnectionsPerPartition property.
     * 
     */
    public int getMaxConnectionsPerPartition() {
        return maxConnectionsPerPartition;
    }

    /**
     * Sets the value of the maxConnectionsPerPartition property.
     * 
     */
    public void setMaxConnectionsPerPartition(int value) {
        this.maxConnectionsPerPartition = value;
    }

}
