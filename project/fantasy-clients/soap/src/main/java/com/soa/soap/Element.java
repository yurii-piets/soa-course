
package com.soa.soap;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for element.
 * 
 * <p>The following schema fragment specifies the expected         content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="element"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="STICK_1"/&gt;
 *     &lt;enumeration value="STICK_2"/&gt;
 *     &lt;enumeration value="STICK_3"/&gt;
 *     &lt;enumeration value="STICK_4"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "element")
@XmlEnum
public enum Element {

    STICK_1,
    STICK_2,
    STICK_3,
    STICK_4;

    public String value() {
        return name();
    }

    public static Element fromValue(String v) {
        return valueOf(v);
    }

}
