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
@JsonPropertyOrder({ "_id", "_item", "_user", "balance", "institution_type", "meta", "numbers", "subtype", "type" })
public class AccountDTO extends PlaidBaseResponse {

	@JsonProperty("_id")
	private String Id;
	@JsonProperty("_item")
	private String Item;
	@JsonProperty("_user")
	private String User;
	@JsonProperty("balance")
	private Balance balance;
	@JsonProperty("institution_type")
	private String institutionType;
	@JsonProperty("meta")
	private Meta meta;
	@JsonProperty("numbers")
	private Numbers numbers;
	@JsonProperty("subtype")
	private String subtype;
	@JsonProperty("type")
	private String type;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	 * No args constructor for use in serialization
	 * 
	 */
	public AccountDTO() {
	}

	/**
	 * 
	 * @param User
	 * @param balance
	 * @param Item
	 * @param numbers
	 * @param subtype
	 * @param institutionType
	 * @param Id
	 * @param type
	 * @param meta
	 */
	public AccountDTO(String Id, String Item, String User, Balance balance, String institutionType, Meta meta, Numbers numbers, String subtype, String type) {
		this.Id = Id;
		this.Item = Item;
		this.User = User;
		this.balance = balance;
		this.institutionType = institutionType;
		this.meta = meta;
		this.numbers = numbers;
		this.subtype = subtype;
		this.type = type;
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof AccountDTO) == false) {
			return false;
		}
		AccountDTO rhs = ((AccountDTO) other);
		return new EqualsBuilder().append(Id, rhs.Id).append(Item, rhs.Item).append(User, rhs.User).append(balance, rhs.balance)
				.append(institutionType, rhs.institutionType).append(meta, rhs.meta).append(numbers, rhs.numbers).append(subtype, rhs.subtype)
				.append(type, rhs.type).append(additionalProperties, rhs.additionalProperties).isEquals();
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	/**
	 * 
	 * @return The balance
	 */
	@JsonProperty("balance")
	public Balance getBalance() {
		return balance;
	}

	/**
	 * 
	 * @return The Id
	 */
	@JsonProperty("_id")
	public String getId() {
		return Id;
	}

	/**
	 * 
	 * @return The institutionType
	 */
	@JsonProperty("institution_type")
	public String getInstitutionType() {
		return institutionType;
	}

	/**
	 * 
	 * @return The Item
	 */
	@JsonProperty("_item")
	public String getItem() {
		return Item;
	}

	/**
	 * 
	 * @return The meta
	 */
	@JsonProperty("meta")
	public Meta getMeta() {
		return meta;
	}

	/**
	 * 
	 * @return The numbers
	 */
	@JsonProperty("numbers")
	public Numbers getNumbers() {
		return numbers;
	}

	/**
	 * 
	 * @return The subtype
	 */
	@JsonProperty("subtype")
	public String getSubtype() {
		return subtype;
	}

	/**
	 * 
	 * @return The type
	 */
	@JsonProperty("type")
	public String getType() {
		return type;
	}

	/**
	 * 
	 * @return The User
	 */
	@JsonProperty("_user")
	public String getUser() {
		return User;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(Id).append(Item).append(User).append(balance).append(institutionType).append(meta).append(numbers).append(subtype)
				.append(type).append(additionalProperties).toHashCode();
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

	/**
	 * 
	 * @param balance
	 *            The balance
	 */
	@JsonProperty("balance")
	public void setBalance(Balance balance) {
		this.balance = balance;
	}

	/**
	 * 
	 * @param Id
	 *            The _id
	 */
	@JsonProperty("_id")
	public void setId(String Id) {
		this.Id = Id;
	}

	/**
	 * 
	 * @param institutionType
	 *            The institution_type
	 */
	@JsonProperty("institution_type")
	public void setInstitutionType(String institutionType) {
		this.institutionType = institutionType;
	}

	/**
	 * 
	 * @param Item
	 *            The _item
	 */
	@JsonProperty("_item")
	public void setItem(String Item) {
		this.Item = Item;
	}

	/**
	 * 
	 * @param meta
	 *            The meta
	 */
	@JsonProperty("meta")
	public void setMeta(Meta meta) {
		this.meta = meta;
	}

	/**
	 * 
	 * @param numbers
	 *            The numbers
	 */
	@JsonProperty("numbers")
	public void setNumbers(Numbers numbers) {
		this.numbers = numbers;
	}

	/**
	 * 
	 * @param subtype
	 *            The subtype
	 */
	@JsonProperty("subtype")
	public void setSubtype(String subtype) {
		this.subtype = subtype;
	}

	/**
	 * 
	 * @param type
	 *            The type
	 */
	@JsonProperty("type")
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * 
	 * @param User
	 *            The _user
	 */
	@JsonProperty("_user")
	public void setUser(String User) {
		this.User = User;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
