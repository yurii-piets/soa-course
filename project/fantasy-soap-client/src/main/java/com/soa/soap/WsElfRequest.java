
package com.soa.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for wsElfRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected         content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="wsElfRequest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="arrowCount" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="bowType" type="{http://soap.soa.com/}bowType" minOccurs="0"/&gt;
 *         &lt;element name="forestId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
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
@XmlType(name = "wsElfRequest", propOrder = {
    "arrowCount",
    "bowType",
    "forestId",
    "name",
    "power"
})
public class WsElfRequest {

    protected Integer arrowCount;
    @XmlSchemaType(name = "string")
    protected BowType bowType;
    protected Long forestId;
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
     * Gets the value of the forestId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getForestId() {
        return forestId;
    }

    /**
     * Sets the value of the forestId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setForestId(Long value) {
        this.forestId = value;
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
