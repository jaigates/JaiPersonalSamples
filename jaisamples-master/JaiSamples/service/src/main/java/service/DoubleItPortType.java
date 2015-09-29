package service;

import javax.jws.WebMethod;
import javax.jws.WebService;

import service.schemas.DoubleRequest;
import service.schemas.DoubleResponse;

@WebService
public interface DoubleItPortType {
	@WebMethod
	public DoubleResponse doubleIt(DoubleRequest dr);
}
