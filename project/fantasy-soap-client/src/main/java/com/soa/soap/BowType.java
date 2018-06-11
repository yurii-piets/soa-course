
package com.soa.soap;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for bowType.
 * 
 * <p>The following schema fragment specifies the expected         content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="bowType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="BAD"/&gt;
 *     &lt;enumeration value="MIDDLE"/&gt;
 *     &lt;enumeration value="GOOD"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "bowType")
@XmlEnum
public enum BowType {

    BAD,
    MIDDLE,
    GOOD;

    public String value() {
        return name();
    }

    public static BowType fromValue(String v) {
        return valueOf(v);
    }

}
