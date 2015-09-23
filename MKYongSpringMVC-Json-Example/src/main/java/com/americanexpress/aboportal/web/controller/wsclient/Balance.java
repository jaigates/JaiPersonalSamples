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
@JsonPropertyOrder({ "available", "current" })
public class Balance {

	@JsonProperty("available")
	private Integer available;
	@JsonProperty("current")
	private Double current;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	 * No args constructor for use in serialization
	 * 
	 */
	public Balance() {
	}

	/**
	 * 
	 * @param current
	 * @param available
	 */
	public Balance(Integer available, Double current) {
		this.available = available;
		this.current = current;
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof Balance) == false) {
			return false;
		}
		Balance rhs = ((Balance) other);
		return new EqualsBuilder().append(available, rhs.available).append(current, rhs.current).append(additionalProperties, rhs.additionalProperties)
				.isEquals();
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	/**
	 * 
	 * @return The available
	 */
	@JsonProperty("available")
	public Integer getAvailable() {
		return available;
	}

	/**
	 * 
	 * @return The current
	 */
	@JsonProperty("current")
	public Double getCurrent() {
		return current;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(available).append(current).append(additionalProperties).toHashCode();
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

	/**
	 * 
	 * @param available
	 *            The available
	 */
	@JsonProperty("available")
	public void setAvailable(Integer available) {
		this.available = available;
	}

	/**
	 * 
	 * @param current
	 *            The current
	 */
	@JsonProperty("current")
	public void setCurrent(Double current) {
		this.current = current;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
