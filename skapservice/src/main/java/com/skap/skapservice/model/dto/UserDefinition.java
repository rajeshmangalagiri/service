/**
 * 
 */
package com.skap.skapservice.model.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Rajesh_Mangalagiri
 * 
 */

@Entity
@Table(name = "skapdev.USERDEFN")
public class UserDefinition {

	/**
	 * UserID of the User
	 */
	@Id
	@Column(name = "USERID")
	private String userID;

	/**
	 * Password of the User
	 */
	@Column(name = "PASSWD")
	private String password;

	/**
	 * Data Access level of the User
	 */
	@Column(name = "DATA_ACCESS")
	private String dataAccess;

	/**
	 * User ID Created By
	 */
	@Column(name = "CREATEDBY")
	private String createdBy;

	/**
	 * UserID Created time
	 */
	@Column(name = "CREATEDTTM")
	private Date createdTime;

	/**
	 * UserID updated By
	 */
	@Column(name = "LASTUPDBY")
	private String lastUpdatedBy;

	/**
	 * UserID Updated Time
	 */
	@Column(name = "LASTUPDTTM")
	private Date lastUpdedTime;

	/**
	 * Activation key
	 */
	@Column(name = "A_KEY")
	private String aKey;

	/**
	 * User Account Status
	 */
	@Column(name = "ACCT_STATUS")
	private String accountStatus;

	/**
	 * Password key
	 */
	@Column(name = "P_KEY")
	private String pKey;

	/**
	 * @return the userID
	 */
	public String getUserID() {
		return userID;
	}

	/**
	 * @param userID
	 *            the userID to set
	 */
	public void setUserID(String userID) {
		this.userID = userID;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the dataAccess
	 */
	public String getDataAccess() {
		return dataAccess;
	}

	/**
	 * @param dataAccess
	 *            the dataAccess to set
	 */
	public void setDataAccess(String dataAccess) {
		this.dataAccess = dataAccess;
	}

	/**
	 * @return the createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy
	 *            the createdBy to set
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * @return the createdTime
	 */
	public Date getCreatedTime() {
		return createdTime;
	}

	/**
	 * @param createdTime
	 *            the createdTime to set
	 */
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	/**
	 * @return the lastUpdatedBy
	 */
	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	/**
	 * @param lastUpdatedBy
	 *            the lastUpdatedBy to set
	 */
	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	/**
	 * @return the lastUpdedTime
	 */
	public Date getLastUpdedTime() {
		return lastUpdedTime;
	}

	/**
	 * @param lastUpdedTime
	 *            the lastUpdedTime to set
	 */
	public void setLastUpdedTime(Date lastUpdedTime) {
		this.lastUpdedTime = lastUpdedTime;
	}

	/**
	 * @return the aKey
	 */
	public String getAKey() {
		return aKey;
	}

	/**
	 * @param aKey
	 *            the aKey to set
	 */
	public void setAKey(String aKey) {
		this.aKey = aKey;
	}

	/**
	 * @return the aKey
	 */
	public String getPKey() {
		return pKey;
	}

	/**
	 * @param aKey
	 *            the aKey to set
	 */
	public void setPKey(String pKey) {
		this.pKey = pKey;
	}

	/**
	 * @return the accountStatus
	 */
	public String getAccountStatus() {
		return accountStatus;
	}

	/**
	 * @param accountStatus
	 *            the accountStatus to set
	 */
	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}

}
