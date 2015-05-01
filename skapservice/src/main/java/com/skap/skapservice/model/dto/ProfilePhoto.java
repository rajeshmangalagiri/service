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
@Table(name="skapdev.PROFILE_PHOTO")
public class ProfilePhoto {
	
	/**
	 * UserID of the User
	 */
	@Id
	@Column(name="USERID")
	private String userID;
	
	/**
	 * Effective Date Time of the Profile Photo
	 */
	@Column(name="EFFDTTM")
	private Date effectiveDateTime;
	
	/**
	 * photoType of the Profile Photo
	 */
	@Column(name="PHOTO_TYPE")
	private String photoType;
	
	/**
	 * s3Link of the Profile Photo
	 */
	@Column(name="S3_LINK")
	private String s3Link;
	
	/**
	 * preferenceFlag of the User
	 */
	@Column(name="PREF_FLAG")
	private Date preferenceFlag;
	
	/**
	 * createdBy User
	 */
	@Column(name="CREATEDBY")
	private String createdBy;
	
	/**
	 * lastUpdatedTime of the Profile Photo
	 */
	@Column(name="LASTUPDTTM")
	private Date lastUpdatedTime;

	/**
	 * lastUpdedPrID
	 */
	@Column(name="LASTUPDOPRID")
	private Date lastUpdedPrID;

	/**
	 * @return the userID
	 */
	public String getUserID() {
		return userID;
	}

	/**
	 * @param userID the userID to set
	 */
	public void setUserID(String userID) {
		this.userID = userID;
	}

	/**
	 * @return the effectiveDateTime
	 */
	public Date getEffectiveDateTime() {
		return effectiveDateTime;
	}

	/**
	 * @param effectiveDateTime the effectiveDateTime to set
	 */
	public void setEffectiveDateTime(Date effectiveDateTime) {
		this.effectiveDateTime = effectiveDateTime;
	}

	/**
	 * @return the photoType
	 */
	public String getPhotoType() {
		return photoType;
	}

	/**
	 * @param photoType the photoType to set
	 */
	public void setPhotoType(String photoType) {
		this.photoType = photoType;
	}

	/**
	 * @return the s3Link
	 */
	public String getS3Link() {
		return s3Link;
	}

	/**
	 * @param s3Link the s3Link to set
	 */
	public void setS3Link(String s3Link) {
		this.s3Link = s3Link;
	}

	/**
	 * @return the preferenceFlag
	 */
	public Date getPreferenceFlag() {
		return preferenceFlag;
	}

	/**
	 * @param preferenceFlag the preferenceFlag to set
	 */
	public void setPreferenceFlag(Date preferenceFlag) {
		this.preferenceFlag = preferenceFlag;
	}

	/**
	 * @return the createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * @return the lastUpdatedTime
	 */
	public Date getLastUpdatedTime() {
		return lastUpdatedTime;
	}

	/**
	 * @param lastUpdatedTime the lastUpdatedTime to set
	 */
	public void setLastUpdatedTime(Date lastUpdatedTime) {
		this.lastUpdatedTime = lastUpdatedTime;
	}

	/**
	 * @return the lastUpdedPrID
	 */
	public Date getLastUpdedPrID() {
		return lastUpdedPrID;
	}

	/**
	 * @param lastUpdedPrID the lastUpdedPrID to set
	 */
	public void setLastUpdedPrID(Date lastUpdedPrID) {
		this.lastUpdedPrID = lastUpdedPrID;
	}
	
}
