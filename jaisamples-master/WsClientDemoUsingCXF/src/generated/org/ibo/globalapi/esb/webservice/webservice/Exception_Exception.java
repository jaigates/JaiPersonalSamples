
package org.ibo.globalapi.esb.webservice.webservice;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 2.7.1
 * 2013-05-12T01:02:01.527+05:30
 * Generated source version: 2.7.1
 */

@WebFault(name = "Exception", targetNamespace = "http://webservice.webservice.esb.globalapi.ibo.org/")
public class Exception_Exception extends java.lang.Exception {
    
    private org.ibo.globalapi.esb.webservice.webservice.Exception exception;

    public Exception_Exception() {
        super();
    }
    
    public Exception_Exception(String message) {
        super(message);
    }
    
    public Exception_Exception(String message, Throwable cause) {
        super(message, cause);
    }

    public Exception_Exception(String message, org.ibo.globalapi.esb.webservice.webservice.Exception exception) {
        super(message);
        this.exception = exception;
    }

    public Exception_Exception(String message, org.ibo.globalapi.esb.webservice.webservice.Exception exception, Throwable cause) {
        super(message, cause);
        this.exception = exception;
    }

    public org.ibo.globalapi.esb.webservice.webservice.Exception getFaultInfo() {
        return this.exception;
    }
}
