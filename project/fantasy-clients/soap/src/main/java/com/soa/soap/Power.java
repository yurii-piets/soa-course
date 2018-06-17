
package com.soa.soap;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for power.
 * 
 * <p>The following schema fragment specifies the expected         content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="power"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="POWER_1"/&gt;
 *     &lt;enumeration value="POWER_2"/&gt;
 *     &lt;enumeration value="POWER_3"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "power")
@XmlEnum
public enum Power {

    POWER_1,
    POWER_2,
    POWER_3;

    public String value() {
        return name();
    }

    public static Power fromValue(String v) {
        return valueOf(v);
    }

}
