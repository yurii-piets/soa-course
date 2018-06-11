
package com.soa.soap;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.3.1-SNAPSHOT
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "CategoryServiceImplService", targetNamespace = "http://soap.soa.com/", wsdlLocation = "http://localhost:8080/fantasy/api/CategoryServiceImpl?wsdl")
public class CategoryServiceImplService
    extends Service
{

    private final static URL CATEGORYSERVICEIMPLSERVICE_WSDL_LOCATION;
    private final static WebServiceException CATEGORYSERVICEIMPLSERVICE_EXCEPTION;
    private final static QName CATEGORYSERVICEIMPLSERVICE_QNAME = new QName("http://soap.soa.com/", "CategoryServiceImplService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/fantasy/api/CategoryServiceImpl?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        CATEGORYSERVICEIMPLSERVICE_WSDL_LOCATION = url;
        CATEGORYSERVICEIMPLSERVICE_EXCEPTION = e;
    }

    public CategoryServiceImplService() {
        super(__getWsdlLocation(), CATEGORYSERVICEIMPLSERVICE_QNAME);
    }

    public CategoryServiceImplService(WebServiceFeature... features) {
        super(__getWsdlLocation(), CATEGORYSERVICEIMPLSERVICE_QNAME, features);
    }

    public CategoryServiceImplService(URL wsdlLocation) {
        super(wsdlLocation, CATEGORYSERVICEIMPLSERVICE_QNAME);
    }

    public CategoryServiceImplService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, CATEGORYSERVICEIMPLSERVICE_QNAME, features);
    }

    public CategoryServiceImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public CategoryServiceImplService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns CategoryService
     */
    @WebEndpoint(name = "CategoryServiceImplPort")
    public CategoryService getCategoryServiceImplPort() {
        return super.getPort(new QName("http://soap.soa.com/", "CategoryServiceImplPort"), CategoryService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns CategoryService
     */
    @WebEndpoint(name = "CategoryServiceImplPort")
    public CategoryService getCategoryServiceImplPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://soap.soa.com/", "CategoryServiceImplPort"), CategoryService.class, features);
    }

    private static URL __getWsdlLocation() {
        if (CATEGORYSERVICEIMPLSERVICE_EXCEPTION!= null) {
            throw CATEGORYSERVICEIMPLSERVICE_EXCEPTION;
        }
        return CATEGORYSERVICEIMPLSERVICE_WSDL_LOCATION;
    }

}
