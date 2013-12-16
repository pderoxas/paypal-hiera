
package com.paypal.location.config.app;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * 
 *                 This will contain the details for a single SSH command
 *             
 * 
 * <p>Java class for CommandType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CommandType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="commandFormat" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="maxOutputReadTimeInMs" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="expectedResult" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="exitCode" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                   &lt;element name="output" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;simpleContent>
 *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                           &lt;attribute name="comparator" type="{http://andera.com/infra/application.xsd}ComparatorType" />
 *                         &lt;/extension>
 *                       &lt;/simpleContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
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
@XmlType(name = "CommandType", namespace = "http://andera.com/infra/application.xsd", propOrder = {
    "commandFormat",
    "maxOutputReadTimeInMs",
    "expectedResult"
})
@XmlSeeAlso({
    LoggedCommandType.class
})
public class CommandType {

    @XmlElement(required = true)
    protected String commandFormat;
    protected long maxOutputReadTimeInMs;
    protected List<CommandType.ExpectedResult> expectedResult;

    /**
     * Gets the value of the commandFormat property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCommandFormat() {
        return commandFormat;
    }

    /**
     * Sets the value of the commandFormat property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCommandFormat(String value) {
        this.commandFormat = value;
    }

    /**
     * Gets the value of the maxOutputReadTimeInMs property.
     * 
     */
    public long getMaxOutputReadTimeInMs() {
        return maxOutputReadTimeInMs;
    }

    /**
     * Sets the value of the maxOutputReadTimeInMs property.
     * 
     */
    public void setMaxOutputReadTimeInMs(long value) {
        this.maxOutputReadTimeInMs = value;
    }

    /**
     * Gets the value of the expectedResult property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the expectedResult property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getExpectedResult().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CommandType.ExpectedResult }
     * 
     * 
     */
    public List<CommandType.ExpectedResult> getExpectedResult() {
        if (expectedResult == null) {
            expectedResult = new ArrayList<CommandType.ExpectedResult>();
        }
        return this.expectedResult;
    }


    /**
     * 
     *                             If both expected exitCode and output equal the actual, the command will be considered
     *                             successful
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
     *         &lt;element name="exitCode" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *         &lt;element name="output" minOccurs="0">
     *           &lt;complexType>
     *             &lt;simpleContent>
     *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                 &lt;attribute name="comparator" type="{http://andera.com/infra/application.xsd}ComparatorType" />
     *               &lt;/extension>
     *             &lt;/simpleContent>
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
    @XmlType(name = "", propOrder = {
        "exitCode",
        "output"
    })
    public static class ExpectedResult {

        protected int exitCode;
        protected CommandType.ExpectedResult.Output output;

        /**
         * Gets the value of the exitCode property.
         * 
         */
        public int getExitCode() {
            return exitCode;
        }

        /**
         * Sets the value of the exitCode property.
         * 
         */
        public void setExitCode(int value) {
            this.exitCode = value;
        }

        /**
         * Gets the value of the output property.
         * 
         * @return
         *     possible object is
         *     {@link CommandType.ExpectedResult.Output }
         *     
         */
        public CommandType.ExpectedResult.Output getOutput() {
            return output;
        }

        /**
         * Sets the value of the output property.
         * 
         * @param value
         *     allowed object is
         *     {@link CommandType.ExpectedResult.Output }
         *     
         */
        public void setOutput(CommandType.ExpectedResult.Output value) {
            this.output = value;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;simpleContent>
         *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
         *       &lt;attribute name="comparator" type="{http://andera.com/infra/application.xsd}ComparatorType" />
         *     &lt;/extension>
         *   &lt;/simpleContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "value"
        })
        public static class Output {

            @XmlValue
            protected String value;
            @XmlAttribute
            protected ComparatorType comparator;

            /**
             * Gets the value of the value property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getValue() {
                return value;
            }

            /**
             * Sets the value of the value property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setValue(String value) {
                this.value = value;
            }

            /**
             * Gets the value of the comparator property.
             * 
             * @return
             *     possible object is
             *     {@link ComparatorType }
             *     
             */
            public ComparatorType getComparator() {
                return comparator;
            }

            /**
             * Sets the value of the comparator property.
             * 
             * @param value
             *     allowed object is
             *     {@link ComparatorType }
             *     
             */
            public void setComparator(ComparatorType value) {
                this.comparator = value;
            }

        }

    }

}
