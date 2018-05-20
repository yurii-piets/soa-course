
package com.soa.ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.soa.ws package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _DayToVacation_QNAME = new QName("http://ws.soa.com/", "dayToVacation");
    private final static QName _DayToVacationResponse_QNAME = new QName("http://ws.soa.com/", "dayToVacationResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.soa.ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DayToVacation }
     * 
     */
    public DayToVacation createDayToVacation() {
        return new DayToVacation();
    }

    /**
     * Create an instance of {@link DayToVacationResponse }
     * 
     */
    public DayToVacationResponse createDayToVacationResponse() {
        return new DayToVacationResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DayToVacation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.soa.com/", name = "dayToVacation")
    public JAXBElement<DayToVacation> createDayToVacation(DayToVacation value) {
        return new JAXBElement<DayToVacation>(_DayToVacation_QNAME, DayToVacation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DayToVacationResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.soa.com/", name = "dayToVacationResponse")
    public JAXBElement<DayToVacationResponse> createDayToVacationResponse(DayToVacationResponse value) {
        return new JAXBElement<DayToVacationResponse>(_DayToVacationResponse_QNAME, DayToVacationResponse.class, null, value);
    }

}
