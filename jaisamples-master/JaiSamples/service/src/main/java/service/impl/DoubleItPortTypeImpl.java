package service.impl;

import javax.jws.WebMethod;
import javax.jws.WebService;

import service.DoubleItPortType;
import service.schemas.DoubleRequest;
import service.schemas.DoubleResponse;

@WebService(endpointInterface="service.DoubleItPortType")
public class DoubleItPortTypeImpl implements DoubleItPortType {
	
	@WebMethod
    public DoubleResponse doubleIt(DoubleRequest dr) {
    	DoubleResponse dresp = new DoubleResponse();
    	dresp.setReturnValue(dr.getValue() * 2);
    	return dresp;
    }
    
}