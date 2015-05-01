/**
 * 
 */
package com.skap.skapservice.model.dto;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author Rajesh_Mangalagiri
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({ "userID", "password", "dataAccess" })
public class UserDefinitionDto {

	private String userID;
	@JsonProperty("password")
	private String password;
	@JsonProperty("dataAccess")
	private String dataAccess;
	@JsonProperty("aKey")
	private String activationKey;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	 * 
	 * @return The userID
	 */
	@JsonProperty("userID")
	public String getUserID() {
		return userID;
	}

	/**
	 * 
	 * @param userID
	 *            The userID
	 */
	@JsonProperty("userID")
	public void setUserID(String userID) {
		this.userID = userID;
	}

	/**
	 * 
	 * @return The password
	 */
	@JsonProperty("password")
	public String getPassword() {
		return password;
	}

	/**
	 * 
	 * @param password
	 *            The password
	 */
	@JsonProperty("password")
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * 
	 * @return The dataAccess
	 */
	@JsonProperty("dataAccess")
	public String getDataAccess() {
		return dataAccess;
	}

	/**
	 * 
	 * @param dataAccess
	 *            The dataAccess
	 */
	@JsonProperty("dataAccess")
	public void setDataAccess(String dataAccess) {
		this.dataAccess = dataAccess;
	}

	/**
	 * @return the activationKey
	 */
	@JsonProperty("aKey")
	public String getActivationKey() {
		return activationKey;
	}

	/**
	 * @param activationKey
	 *            the activationKey to set
	 */
	@JsonProperty("aKey")
	public void setActivationKey(String activationKey) {
		this.activationKey = activationKey;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(userID).append(password)
				.append(dataAccess).append(additionalProperties).toHashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof UserDefinitionDto) == false) {
			return false;
		}
		UserDefinitionDto rhs = ((UserDefinitionDto) other);
		return new EqualsBuilder().append(userID, rhs.userID)
				.append(password, rhs.password)
				.append(dataAccess, rhs.dataAccess)
				.append(additionalProperties, rhs.additionalProperties)
				.isEquals();
	}

}
