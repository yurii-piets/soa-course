
package com.soa.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for wsMagRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected         content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="wsMagRequest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="element" type="{http://soap.soa.com/}element" minOccurs="0"/&gt;
 *         &lt;element name="mana" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="power" type="{http://soap.soa.com/}power" minOccurs="0"/&gt;
 *         &lt;element name="towerId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wsMagRequest", propOrder = {
    "element",
    "mana",
    "name",
    "power",
    "towerId"
})
public class WsMagRequest {

    @XmlSchemaType(name = "string")
    protected Element element;
    protected Integer mana;
    protected String name;
    @XmlSchemaType(name = "string")
    protected Power power;
    protected Long towerId;

    /**
     * Gets the value of the element property.
     * 
     * @return
     *     possible object is
     *     {@link Element }
     *     
     */
    public Element getElement() {
        return element;
    }

    /**
     * Sets the value of the element property.
     * 
     * @param value
     *     allowed object is
     *     {@link Element }
     *     
     */
    public void setElement(Element value) {
        this.element = value;
    }

    /**
     * Gets the value of the mana property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMana() {
        return mana;
    }

    /**
     * Sets the value of the mana property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMana(Integer value) {
        this.mana = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the power property.
     * 
     * @return
     *     possible object is
     *     {@link Power }
     *     
     */
    public Power getPower() {
        return power;
    }

    /**
     * Sets the value of the power property.
     * 
     * @param value
     *     allowed object is
     *     {@link Power }
     *     
     */
    public void setPower(Power value) {
        this.power = value;
    }

    /**
     * Gets the value of the towerId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getTowerId() {
        return towerId;
    }

    /**
     * Sets the value of the towerId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setTowerId(Long value) {
        this.towerId = value;
    }

}
