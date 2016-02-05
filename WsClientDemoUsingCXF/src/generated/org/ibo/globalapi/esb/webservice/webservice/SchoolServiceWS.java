package org.ibo.globalapi.esb.webservice.webservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.7.1
 * 2013-05-12T01:02:01.559+05:30
 * Generated source version: 2.7.1
 * 
 */
@WebService(targetNamespace = "http://webservice.webservice.esb.globalapi.ibo.org/", name = "SchoolServiceWS")
@XmlSeeAlso({ObjectFactory.class})
public interface SchoolServiceWS {

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "createSchoolData", targetNamespace = "http://webservice.webservice.esb.globalapi.ibo.org/", className = "org.ibo.globalapi.esb.webservice.webservice.CreateSchoolData")
    @WebMethod
    @ResponseWrapper(localName = "createSchoolDataResponse", targetNamespace = "http://webservice.webservice.esb.globalapi.ibo.org/", className = "org.ibo.globalapi.esb.webservice.webservice.CreateSchoolDataResponse")
    public org.ibo.globalapi.esb.webservice.webservice.CreateSchoolResponse createSchoolData(
        @WebParam(name = "arg0", targetNamespace = "")
        org.ibo.globalapi.esb.webservice.webservice.CreateSchoolRequest arg0
    ) throws Exception_Exception;
}