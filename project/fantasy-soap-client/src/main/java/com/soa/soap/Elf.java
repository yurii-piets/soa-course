
package com.soa.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for elf complex type.
 * 
 * <p>The following schema fragment specifies the expected         content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="elf"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="arrowCount" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="bowType" type="{http://soap.soa.com/}bowType" minOccurs="0"/&gt;
 *         &lt;element name="forest" type="{http://soap.soa.com/}forest" minOccurs="0"/&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="power" type="{http://soap.soa.com/}power" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "elf", propOrder = {
    "arrowCount",
    "bowType",
    "forest",
    "id",
    "name",
    "power"
})
public class Elf {

    protected Integer arrowCount;
    @XmlSchemaType(name = "string")
    protected BowType bowType;
    protected Forest forest;
    protected Long id;
    protected String name;
    @XmlSchemaType(name = "string")
    protected Power power;

    /**
     * Gets the value of the arrowCount property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getArrowCount() {
        return arrowCount;
    }

    /**
     * Sets the value of the arrowCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setArrowCount(Integer value) {
        this.arrowCount = value;
    }

    /**
     * Gets the value of the bowType property.
     * 
     * @return
     *     possible object is
     *     {@link BowType }
     *     
     */
    public BowType getBowType() {
        return bowType;
    }

    /**
     * Sets the value of the bowType property.
     * 
     * @param value
     *     allowed object is
     *     {@link BowType }
     *     
     */
    public void setBowType(BowType value) {
        this.bowType = value;
    }

    /**
     * Gets the value of the forest property.
     * 
     * @return
     *     possible object is
     *     {@link Forest }
     *     
     */
    public Forest getForest() {
        return forest;
    }

    /**
     * Sets the value of the forest property.
     * 
     * @param value
     *     allowed object is
     *     {@link Forest }
     *     
     */
    public void setForest(Forest value) {
        this.forest = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setId(Long value) {
        this.id = value;
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

}
