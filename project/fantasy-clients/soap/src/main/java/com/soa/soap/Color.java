
package com.soa.soap;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for color.
 * 
 * <p>The following schema fragment specifies the expected         content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="color"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="BLACK"/&gt;
 *     &lt;enumeration value="RED"/&gt;
 *     &lt;enumeration value="WHITE"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "color")
@XmlEnum
public enum Color {

    BLACK,
    RED,
    WHITE;

    public String value() {
        return name();
    }

    public static Color fromValue(String v) {
        return valueOf(v);
    }

}
