
package org.ibo.globalapi.esb.webservice.webservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.ibo.globalapi.esb.webservice.webservice package. 
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

    private final static QName _CreateSchoolRequest_QNAME = new QName("http://webservice.webservice.esb.globalapi.ibo.org/", "CreateSchoolRequest");
    private final static QName _CreateSchoolDataResponse_QNAME = new QName("http://webservice.webservice.esb.globalapi.ibo.org/", "createSchoolDataResponse");
    private final static QName _CreateSchoolData_QNAME = new QName("http://webservice.webservice.esb.globalapi.ibo.org/", "createSchoolData");
    private final static QName _Exception_QNAME = new QName("http://webservice.webservice.esb.globalapi.ibo.org/", "Exception");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.ibo.globalapi.esb.webservice.webservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Exception }
     * 
     */
    public Exception createException() {
        return new Exception();
    }

    /**
     * Create an instance of {@link CreateSchoolResponse }
     * 
     */
    public CreateSchoolResponse createCreateSchoolResponse() {
        return new CreateSchoolResponse();
    }

    /**
     * Create an instance of {@link CreateSchoolDataResponse }
     * 
     */
    public CreateSchoolDataResponse createCreateSchoolDataResponse() {
        return new CreateSchoolDataResponse();
    }

    /**
     * Create an instance of {@link AuthenticationToken }
     * 
     */
    public AuthenticationToken createAuthenticationToken() {
        return new AuthenticationToken();
    }

    /**
     * Create an instance of {@link CreateSchoolData }
     * 
     */
    public CreateSchoolData createCreateSchoolData() {
        return new CreateSchoolData();
    }

    /**
     * Create an instance of {@link CreateSchoolRequest }
     * 
     */
    public CreateSchoolRequest createCreateSchoolRequest() {
        return new CreateSchoolRequest();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateSchoolRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.webservice.esb.globalapi.ibo.org/", name = "CreateSchoolRequest")
    public JAXBElement<CreateSchoolRequest> createCreateSchoolRequest(CreateSchoolRequest value) {
        return new JAXBElement<CreateSchoolRequest>(_CreateSchoolRequest_QNAME, CreateSchoolRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateSchoolDataResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.webservice.esb.globalapi.ibo.org/", name = "createSchoolDataResponse")
    public JAXBElement<CreateSchoolDataResponse> createCreateSchoolDataResponse(CreateSchoolDataResponse value) {
        return new JAXBElement<CreateSchoolDataResponse>(_CreateSchoolDataResponse_QNAME, CreateSchoolDataResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateSchoolData }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.webservice.esb.globalapi.ibo.org/", name = "createSchoolData")
    public JAXBElement<CreateSchoolData> createCreateSchoolData(CreateSchoolData value) {
        return new JAXBElement<CreateSchoolData>(_CreateSchoolData_QNAME, CreateSchoolData.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Exception }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.webservice.esb.globalapi.ibo.org/", name = "Exception")
    public JAXBElement<Exception> createException(Exception value) {
        return new JAXBElement<Exception>(_Exception_QNAME, Exception.class, null, value);
    }

}
