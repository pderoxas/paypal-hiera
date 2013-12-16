
package com.paypal.location.config.app;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 *                 This will contain the properties required to query/get the current status of a specific app-instance
 *                 which is a client running on a specific server.
 *             
 * 
 * <p>Java class for AppInstanceType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AppInstanceType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="statusCommandGroup" type="{http://andera.com/infra/application.xsd}SshCommandGroupType"/>
 *         &lt;element name="getClientUrls">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="wizardUrlPattern" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="consoleUrlPattern" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="getUrlsCommandGroup" type="{http://andera.com/infra/application.xsd}SshCommandGroupType"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="getClientRevisions">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="skinsRevisionPattern" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="nonSkinsRevisionPattern" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="getRevisionsCommandGroup" type="{http://andera.com/infra/application.xsd}SshCommandGroupType"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AppInstanceType", namespace = "http://andera.com/infra/application.xsd", propOrder = {
    "statusCommandGroup",
    "getClientUrls",
    "getClientRevisions"
})
public class AppInstanceType {

    @XmlElement(required = true)
    protected SshCommandGroupType statusCommandGroup;
    @XmlElement(required = true)
    protected AppInstanceType.GetClientUrls getClientUrls;
    @XmlElement(required = true)
    protected AppInstanceType.GetClientRevisions getClientRevisions;

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

    /**
     * Gets the value of the getClientUrls property.
     * 
     * @return
     *     possible object is
     *     {@link AppInstanceType.GetClientUrls }
     *     
     */
    public AppInstanceType.GetClientUrls getGetClientUrls() {
        return getClientUrls;
    }

    /**
     * Sets the value of the getClientUrls property.
     * 
     * @param value
     *     allowed object is
     *     {@link AppInstanceType.GetClientUrls }
     *     
     */
    public void setGetClientUrls(AppInstanceType.GetClientUrls value) {
        this.getClientUrls = value;
    }

    /**
     * Gets the value of the getClientRevisions property.
     * 
     * @return
     *     possible object is
     *     {@link AppInstanceType.GetClientRevisions }
     *     
     */
    public AppInstanceType.GetClientRevisions getGetClientRevisions() {
        return getClientRevisions;
    }

    /**
     * Sets the value of the getClientRevisions property.
     * 
     * @param value
     *     allowed object is
     *     {@link AppInstanceType.GetClientRevisions }
     *     
     */
    public void setGetClientRevisions(AppInstanceType.GetClientRevisions value) {
        this.getClientRevisions = value;
    }


    /**
     * 
     *                             This will contain the properties required to get the revisions for a client from the client database.
     *                             It will call one of the "agent" scripts that exist on the database server.
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
     *         &lt;element name="skinsRevisionPattern" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="nonSkinsRevisionPattern" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="getRevisionsCommandGroup" type="{http://andera.com/infra/application.xsd}SshCommandGroupType"/>
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
        "skinsRevisionPattern",
        "nonSkinsRevisionPattern",
        "getRevisionsCommandGroup"
    })
    public static class GetClientRevisions {

        @XmlElement(required = true)
        protected String skinsRevisionPattern;
        @XmlElement(required = true)
        protected String nonSkinsRevisionPattern;
        @XmlElement(required = true)
        protected SshCommandGroupType getRevisionsCommandGroup;

        /**
         * Gets the value of the skinsRevisionPattern property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSkinsRevisionPattern() {
            return skinsRevisionPattern;
        }

        /**
         * Sets the value of the skinsRevisionPattern property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSkinsRevisionPattern(String value) {
            this.skinsRevisionPattern = value;
        }

        /**
         * Gets the value of the nonSkinsRevisionPattern property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getNonSkinsRevisionPattern() {
            return nonSkinsRevisionPattern;
        }

        /**
         * Sets the value of the nonSkinsRevisionPattern property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setNonSkinsRevisionPattern(String value) {
            this.nonSkinsRevisionPattern = value;
        }

        /**
         * Gets the value of the getRevisionsCommandGroup property.
         * 
         * @return
         *     possible object is
         *     {@link SshCommandGroupType }
         *     
         */
        public SshCommandGroupType getGetRevisionsCommandGroup() {
            return getRevisionsCommandGroup;
        }

        /**
         * Sets the value of the getRevisionsCommandGroup property.
         * 
         * @param value
         *     allowed object is
         *     {@link SshCommandGroupType }
         *     
         */
        public void setGetRevisionsCommandGroup(SshCommandGroupType value) {
            this.getRevisionsCommandGroup = value;
        }

    }


    /**
     * 
     *                             This will contain the properties required to get the urls for a client from the client database.
     *                             It will call one of the "agent" scripts that exist on the database server.
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
     *         &lt;element name="wizardUrlPattern" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="consoleUrlPattern" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="getUrlsCommandGroup" type="{http://andera.com/infra/application.xsd}SshCommandGroupType"/>
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
        "wizardUrlPattern",
        "consoleUrlPattern",
        "getUrlsCommandGroup"
    })
    public static class GetClientUrls {

        @XmlElement(required = true)
        protected String wizardUrlPattern;
        @XmlElement(required = true)
        protected String consoleUrlPattern;
        @XmlElement(required = true)
        protected SshCommandGroupType getUrlsCommandGroup;

        /**
         * Gets the value of the wizardUrlPattern property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getWizardUrlPattern() {
            return wizardUrlPattern;
        }

        /**
         * Sets the value of the wizardUrlPattern property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setWizardUrlPattern(String value) {
            this.wizardUrlPattern = value;
        }

        /**
         * Gets the value of the consoleUrlPattern property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getConsoleUrlPattern() {
            return consoleUrlPattern;
        }

        /**
         * Sets the value of the consoleUrlPattern property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setConsoleUrlPattern(String value) {
            this.consoleUrlPattern = value;
        }

        /**
         * Gets the value of the getUrlsCommandGroup property.
         * 
         * @return
         *     possible object is
         *     {@link SshCommandGroupType }
         *     
         */
        public SshCommandGroupType getGetUrlsCommandGroup() {
            return getUrlsCommandGroup;
        }

        /**
         * Sets the value of the getUrlsCommandGroup property.
         * 
         * @param value
         *     allowed object is
         *     {@link SshCommandGroupType }
         *     
         */
        public void setGetUrlsCommandGroup(SshCommandGroupType value) {
            this.getUrlsCommandGroup = value;
        }

    }

}
