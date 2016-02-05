package service.schemas;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "DoubleRequest", propOrder = { "value"})
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "DoubleRequest")
public class DoubleRequest {

	@XmlElement(required = true,nillable=false)
	Double value;

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

}
