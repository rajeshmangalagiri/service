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
@JsonPropertyOrder({ "shaKey" })
public class UserResponseDto extends BaseResponse {

	@JsonProperty("shaKey")
	private String shaKey;
	
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	 * @return the shaKey
	 */
	@JsonProperty("shaKey")
	public String getshaKey() {
		return shaKey;
	}

	/**
	 * @param shaKey
	 *            the shaKey to set
	 */
	@JsonProperty("shaKey")
	public void setshaKey(String shaKey) {
		this.shaKey = shaKey;
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
		return new HashCodeBuilder().append(shaKey).append(additionalProperties)
				.toHashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof UserResponseDto) == false) {
			return false;
		}
		UserResponseDto rhs = ((UserResponseDto) other);
		return new EqualsBuilder().append(shaKey, rhs.shaKey)
				.append(additionalProperties, rhs.additionalProperties)
				.isEquals();
	}

}
