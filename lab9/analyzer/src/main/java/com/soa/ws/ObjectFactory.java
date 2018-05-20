
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

    private final static QName _AnalyzeResponse_QNAME = new QName("http://ws.soa.com/", "analyzeResponse");
    private final static QName _Analyze_QNAME = new QName("http://ws.soa.com/", "analyze");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.soa.ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Analyze }
     * 
     */
    public Analyze createAnalyze() {
        return new Analyze();
    }

    /**
     * Create an instance of {@link AnalyzeResponse }
     * 
     */
    public AnalyzeResponse createAnalyzeResponse() {
        return new AnalyzeResponse();
    }

    /**
     * Create an instance of {@link Info }
     * 
     */
    public Info createInfo() {
        return new Info();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AnalyzeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.soa.com/", name = "analyzeResponse")
    public JAXBElement<AnalyzeResponse> createAnalyzeResponse(AnalyzeResponse value) {
        return new JAXBElement<AnalyzeResponse>(_AnalyzeResponse_QNAME, AnalyzeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Analyze }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.soa.com/", name = "analyze")
    public JAXBElement<Analyze> createAnalyze(Analyze value) {
        return new JAXBElement<Analyze>(_Analyze_QNAME, Analyze.class, null, value);
    }

}
