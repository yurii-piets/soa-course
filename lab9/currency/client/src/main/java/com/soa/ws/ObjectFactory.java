
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

    private final static QName _GetCurrencyByCode_QNAME = new QName("http://ws.soa.com/", "getCurrencyByCode");
    private final static QName _GetCurrencyByCodeResponse_QNAME = new QName("http://ws.soa.com/", "getCurrencyByCodeResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.soa.ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetCurrencyByCode }
     * 
     */
    public GetCurrencyByCode createGetCurrencyByCode() {
        return new GetCurrencyByCode();
    }

    /**
     * Create an instance of {@link GetCurrencyByCodeResponse }
     * 
     */
    public GetCurrencyByCodeResponse createGetCurrencyByCodeResponse() {
        return new GetCurrencyByCodeResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCurrencyByCode }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetCurrencyByCode }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.soa.com/", name = "getCurrencyByCode")
    public JAXBElement<GetCurrencyByCode> createGetCurrencyByCode(GetCurrencyByCode value) {
        return new JAXBElement<GetCurrencyByCode>(_GetCurrencyByCode_QNAME, GetCurrencyByCode.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCurrencyByCodeResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetCurrencyByCodeResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.soa.com/", name = "getCurrencyByCodeResponse")
    public JAXBElement<GetCurrencyByCodeResponse> createGetCurrencyByCodeResponse(GetCurrencyByCodeResponse value) {
        return new JAXBElement<GetCurrencyByCodeResponse>(_GetCurrencyByCodeResponse_QNAME, GetCurrencyByCodeResponse.class, null, value);
    }

}
