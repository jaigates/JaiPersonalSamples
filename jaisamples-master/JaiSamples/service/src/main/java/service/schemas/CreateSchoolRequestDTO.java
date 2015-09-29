package service.schemas;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "CreateSchoolRequest", propOrder = { "schoolCode",
		"schoolName", "subRegionalOffice", "regionalOffice", "country",
		"state", "timezone", "trainingSchoolFlag", "personCode", "roleType",
		"authenticationToken" })
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "CreateSchoolRequest")

public class CreateSchoolRequestDTO {

	/**
	 *
	 */
	private static final long serialVersionUID = 7363553823754379872L;

	private String schoolCode;
	@XmlElement(required = true)
	@Facets(minLength = 1, maxLength = 80,pattern=Regex_First_Letter_Capital)
	private String schoolName;
	@XmlElement(required = true)
	@Facets(minLength = 1)
	private String subRegionalOffice;
	@XmlElement(required = true)
	@Facets(minLength = 1, maxLength = 5)
	private String regionalOffice;
	@XmlElement(required = true)
	@Facets(minLength = 2, maxLength = 2)
	private String country;
	@XmlElement(required = true)
	@Facets(minLength = 2, maxLength = 2)
	private String state;
	@XmlElement(required = true)
	private String timezone;
	@XmlElement(required = true)
	private String trainingSchoolFlag;
	@XmlElement(required = true)
	private String personCode;
	@XmlElement(required = true)
	private String roleType;

	protected AuthenticationToken authenticationToken;

	public AuthenticationToken getAuthenticationToken() {
		if (authenticationToken == null) {
			authenticationToken = new AuthenticationToken();
		}
		return authenticationToken;
	}

	@XmlTransient
	public String getSchoolCode() {
		return schoolCode;
	}

	public void setSchoolCode(String schoolCode) {
		this.schoolCode = schoolCode;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getSubRegionalOffice() {
		return subRegionalOffice;
	}

	public void setSubRegionalOffice(String subRegionalOffice) {
		this.subRegionalOffice = subRegionalOffice;
	}

	public String getRegionalOffice() {
		return regionalOffice;
	}

	public void setRegionalOffice(String regionalOffice) {
		this.regionalOffice = regionalOffice;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getTimezone() {
		return timezone;
	}

	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}

	public String getTrainingSchoolFlag() {
		return trainingSchoolFlag;
	}

	public void setTrainingSchoolFlag(String trainingSchoolFlag) {
		this.trainingSchoolFlag = trainingSchoolFlag;
	}

	public List<ConstraintViolation> validate() {
		return super.validate();
	}

	@Override
	public String getPersonCode() {
		return personCode;
	}

	@Override
	public void setPersonCode(String personCode) {
		this.personCode = personCode;
	}

	@Override
	public String getRoleType() {
		return roleType;
	}

	@Override
	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}

	@Override
	public void setAuthenticationToken(AuthenticationToken authenticationToken) {
		this.authenticationToken = authenticationToken;

	}
}
