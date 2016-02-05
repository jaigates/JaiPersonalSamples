/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package demo.hw.client;

import org.tempuri.TempConvert;
import org.tempuri.TempConvertSoap;


public final class Client {

	private Client() {
	}

	/*
	public static void main(String args[]) throws Exception {
		String url = "http://localhost:9000/SoapContext/SoapPort?wsdl";
		if (args.length == 0) {
			System.out.println("picking up default url :" + url);
		} else {
			url = args[0];
		}

		URL wsdlURL;
		File wsdlFile = new File(url);
		if (wsdlFile.exists()) {
			wsdlURL = wsdlFile.toURI().toURL();
		} else {
			wsdlURL = new URL(url);
		}
		QName SERVICE_NAME = new QName("http://webservice.webservice.esb.globalapi.ibo.org/", "SchoolServiceWSService");

		System.out.println(wsdlURL);

		SchoolServiceWSService ss = new SchoolServiceWSService();
		
		Service serv = Service.create(wsdlURL, SERVICE_NAME);

		SchoolServiceWS port = serv.getPort(SchoolServiceWS.class);
		
		((BindingProvider)port).getRequestContext().put("schema-validation-enabled", "true");
		
		
		
		CreateSchoolRequest req = new CreateSchoolRequest();
		req.setSchoolCode("1231");
		req.setSchoolName("aAsdfasd");
		req.setSubRegionalOffice("asd");
		req.setRegionalOffice("sd");
		req.setCountry("ss");
		req.setState("aa");
		req.setTimezone("us");
		req.setTrainingSchoolFlag("tre");
		req.setPersonCode("sds");
		req.setRoleType("sds");
		AuthenticationToken auth = new AuthenticationToken();
		req.setAuthenticationToken(auth);

		CreateSchoolResponse createSchoolData = port.createSchoolData(req);

		System.out.println("1");
	}*/
	
	public static void main(String[] args) {
		TempConvert service = new TempConvert();
		
		TempConvertSoap soap = service.getTempConvertSoap();
		
		String celsiusToFahrenheit = soap.celsiusToFahrenheit("111");
		
		System.out.println(celsiusToFahrenheit);
		
		
		
	}

}
