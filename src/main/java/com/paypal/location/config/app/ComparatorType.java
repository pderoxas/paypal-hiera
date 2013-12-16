
package com.paypal.location.config.app;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ComparatorType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ComparatorType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="REGEX_FIND"/>
 *     &lt;enumeration value="REGEX_MATCH"/>
 *     &lt;enumeration value="LITERAL"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ComparatorType", namespace = "http://andera.com/infra/application.xsd")
@XmlEnum
public enum ComparatorType {

    REGEX_FIND,
    REGEX_MATCH,
    LITERAL;

    public String value() {
        return name();
    }

    public static ComparatorType fromValue(String v) {
        return valueOf(v);
    }

}
