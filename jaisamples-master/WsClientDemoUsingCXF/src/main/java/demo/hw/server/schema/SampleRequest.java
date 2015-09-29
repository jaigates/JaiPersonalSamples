package demo.hw.server.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlType(name = "SampleRequest", propOrder = { "name"})
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "SampleRequest")

public class SampleRequest {
	
	@XmlElement(name = "name", required = true)
	public String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}