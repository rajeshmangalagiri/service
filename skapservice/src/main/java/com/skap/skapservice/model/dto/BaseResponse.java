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

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({ "responseCode", "responseMessage" })
public class BaseResponse {

	@JsonProperty("responseCode")
	private int responseCode;
	@JsonProperty("responseMessage")
	private String responseMessage;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	 * 
	 * @return The responseCode
	 */
	@JsonProperty("responseCode")
	public int getResponseCode() {
		return responseCode;
	}

	/**
	 * 
	 * @param responseCode
	 *            The responseCode
	 */
	@JsonProperty("responseCode")
	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}

	/**
	 * 
	 * @return The responseMessage
	 */
	@JsonProperty("responseMessage")
	public String getResponseMessage() {
		return responseMessage;
	}

	/**
	 * 
	 * @param responseMessage
	 *            The responseMessage
	 */
	@JsonProperty("responseMessage")
	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
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
		return new HashCodeBuilder().append(responseCode)
				.append(responseMessage).append(additionalProperties)
				.toHashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof BaseResponse) == false) {
			return false;
		}
		BaseResponse rhs = ((BaseResponse) other);
		return new EqualsBuilder().append(responseCode, rhs.responseCode)
				.append(responseMessage, rhs.responseMessage)
				.append(additionalProperties, rhs.additionalProperties)
				.isEquals();
	}

}