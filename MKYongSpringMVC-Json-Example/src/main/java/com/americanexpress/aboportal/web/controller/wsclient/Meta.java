package com.americanexpress.aboportal.web.controller.wsclient;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.codehaus.jackson.annotate.JsonAnyGetter;
import org.codehaus.jackson.annotate.JsonAnySetter;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonPropertyOrder({ "limit", "name", "number" })
public class Meta {

	@JsonProperty("limit")
	private Integer limit;
	@JsonProperty("name")
	private String name;
	@JsonProperty("number")
	private String number;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	 * No args constructor for use in serialization
	 * 
	 */
	public Meta() {
	}

	/**
	 * 
	 * @param limit
	 * @param name
	 * @param number
	 */
	public Meta(Integer limit, String name, String number) {
		this.limit = limit;
		this.name = name;
		this.number = number;
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof Meta) == false) {
			return false;
		}
		Meta rhs = ((Meta) other);
		return new EqualsBuilder().append(limit, rhs.limit).append(name, rhs.name).append(number, rhs.number)
				.append(additionalProperties, rhs.additionalProperties).isEquals();
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	/**
	 * 
	 * @return The limit
	 */
	@JsonProperty("limit")
	public Integer getLimit() {
		return limit;
	}

	/**
	 * 
	 * @return The name
	 */
	@JsonProperty("name")
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @return The number
	 */
	@JsonProperty("number")
	public String getNumber() {
		return number;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(limit).append(name).append(number).append(additionalProperties).toHashCode();
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

	/**
	 * 
	 * @param limit
	 *            The limit
	 */
	@JsonProperty("limit")
	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	/**
	 * 
	 * @param name
	 *            The name
	 */
	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 * @param number
	 *            The number
	 */
	@JsonProperty("number")
	public void setNumber(String number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
