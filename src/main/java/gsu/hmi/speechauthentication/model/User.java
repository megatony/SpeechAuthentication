package gsu.hmi.speechauthentication.model;

import java.time.ZonedDateTime;

public class User {
	
	private Long id;
	private String name;
	private ZonedDateTime createdDate;
	private ZonedDateTime modifiedDate;
	private IdentificationProfile identificationProfile;
	private VerificationProfile verificationProfile;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ZonedDateTime getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(ZonedDateTime createdDate) {
		this.createdDate = createdDate;
	}
	public ZonedDateTime getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(ZonedDateTime modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public IdentificationProfile getIdentificationProfile() {
		return identificationProfile;
	}
	public void setIdentificationProfile(IdentificationProfile identificationProfile) {
		this.identificationProfile = identificationProfile;
	}
	public VerificationProfile getVerificationProfile() {
		return verificationProfile;
	}
	public void setVerificationProfile(VerificationProfile verificationProfile) {
		this.verificationProfile = verificationProfile;
	}
	
	
	
}
