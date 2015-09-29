
package org.ibo.globalapi.esb.webservice.webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CreateSchoolRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CreateSchoolRequest">
 *   &lt;complexContent>
 *     &lt;extension base="{http://webservice.webservice.esb.globalapi.ibo.org/}abstractValidator">
 *       &lt;sequence>
 *         &lt;element name="schoolCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="schoolName">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="80"/>
 *               &lt;pattern value="[A-Z]+.*"/>
 *               &lt;minLength value="1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="subRegionalOffice">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;minLength value="1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="regionalOffice">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="5"/>
 *               &lt;minLength value="1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="country">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="2"/>
 *               &lt;minLength value="2"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="state">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="2"/>
 *               &lt;minLength value="2"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="timezone" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="trainingSchoolFlag" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="personCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="roleType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="authenticationToken" type="{http://webservice.webservice.esb.globalapi.ibo.org/}authenticationToken"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CreateSchoolRequest", propOrder = {
    "schoolCode",
    "schoolName",
    "subRegionalOffice",
    "regionalOffice",
    "country",
    "state",
    "timezone",
    "trainingSchoolFlag",
    "personCode",
    "roleType",
    "authenticationToken"
})
public class CreateSchoolRequest
    extends AbstractValidator
{

    @XmlElement(required = true)
    protected String schoolCode;
    @XmlElement(required = true)
    protected String schoolName;
    @XmlElement(required = true)
    protected String subRegionalOffice;
    @XmlElement(required = true)
    protected String regionalOffice;
    @XmlElement(required = true)
    protected String country;
    @XmlElement(required = true)
    protected String state;
    @XmlElement(required = true)
    protected String timezone;
    @XmlElement(required = true)
    protected String trainingSchoolFlag;
    @XmlElement(required = true)
    protected String personCode;
    @XmlElement(required = true)
    protected String roleType;
    @XmlElement(required = true)
    protected AuthenticationToken authenticationToken;

    /**
     * Gets the value of the schoolCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSchoolCode() {
        return schoolCode;
    }

    /**
     * Sets the value of the schoolCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSchoolCode(String value) {
        this.schoolCode = value;
    }

    /**
     * Gets the value of the schoolName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSchoolName() {
        return schoolName;
    }

    /**
     * Sets the value of the schoolName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSchoolName(String value) {
        this.schoolName = value;
    }

    /**
     * Gets the value of the subRegionalOffice property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubRegionalOffice() {
        return subRegionalOffice;
    }

    /**
     * Sets the value of the subRegionalOffice property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubRegionalOffice(String value) {
        this.subRegionalOffice = value;
    }

    /**
     * Gets the value of the regionalOffice property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegionalOffice() {
        return regionalOffice;
    }

    /**
     * Sets the value of the regionalOffice property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegionalOffice(String value) {
        this.regionalOffice = value;
    }

    /**
     * Gets the value of the country property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCountry() {
        return country;
    }

    /**
     * Sets the value of the country property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCountry(String value) {
        this.country = value;
    }

    /**
     * Gets the value of the state property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getState() {
        return state;
    }

    /**
     * Sets the value of the state property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setState(String value) {
        this.state = value;
    }

    /**
     * Gets the value of the timezone property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTimezone() {
        return timezone;
    }

    /**
     * Sets the value of the timezone property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTimezone(String value) {
        this.timezone = value;
    }

    /**
     * Gets the value of the trainingSchoolFlag property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTrainingSchoolFlag() {
        return trainingSchoolFlag;
    }

    /**
     * Sets the value of the trainingSchoolFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTrainingSchoolFlag(String value) {
        this.trainingSchoolFlag = value;
    }

    /**
     * Gets the value of the personCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPersonCode() {
        return personCode;
    }

    /**
     * Sets the value of the personCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPersonCode(String value) {
        this.personCode = value;
    }

    /**
     * Gets the value of the roleType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRoleType() {
        return roleType;
    }

    /**
     * Sets the value of the roleType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRoleType(String value) {
        this.roleType = value;
    }

    /**
     * Gets the value of the authenticationToken property.
     * 
     * @return
     *     possible object is
     *     {@link AuthenticationToken }
     *     
     */
    public AuthenticationToken getAuthenticationToken() {
        return authenticationToken;
    }

    /**
     * Sets the value of the authenticationToken property.
     * 
     * @param value
     *     allowed object is
     *     {@link AuthenticationToken }
     *     
     */
    public void setAuthenticationToken(AuthenticationToken value) {
        this.authenticationToken = value;
    }

}
