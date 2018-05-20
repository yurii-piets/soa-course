
package com.soa.ws;

import lombok.ToString;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for info complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="info">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="capitalAmount" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="charAmount" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="lowerAmount" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="numberAmount" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="spaceAmount" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "info", propOrder = {
    "capitalAmount",
    "charAmount",
    "lowerAmount",
    "numberAmount",
    "spaceAmount"
})
@ToString
public class Info {

    protected Integer capitalAmount;
    protected Integer charAmount;
    protected Integer lowerAmount;
    protected Integer numberAmount;
    protected Integer spaceAmount;

    /**
     * Gets the value of the capitalAmount property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCapitalAmount() {
        return capitalAmount;
    }

    /**
     * Sets the value of the capitalAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCapitalAmount(Integer value) {
        this.capitalAmount = value;
    }

    /**
     * Gets the value of the charAmount property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCharAmount() {
        return charAmount;
    }

    /**
     * Sets the value of the charAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCharAmount(Integer value) {
        this.charAmount = value;
    }

    /**
     * Gets the value of the lowerAmount property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getLowerAmount() {
        return lowerAmount;
    }

    /**
     * Sets the value of the lowerAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setLowerAmount(Integer value) {
        this.lowerAmount = value;
    }

    /**
     * Gets the value of the numberAmount property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNumberAmount() {
        return numberAmount;
    }

    /**
     * Sets the value of the numberAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNumberAmount(Integer value) {
        this.numberAmount = value;
    }

    /**
     * Gets the value of the spaceAmount property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getSpaceAmount() {
        return spaceAmount;
    }

    /**
     * Sets the value of the spaceAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSpaceAmount(Integer value) {
        this.spaceAmount = value;
    }

}
