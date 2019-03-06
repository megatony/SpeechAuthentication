package gsu.hmi.speechauthentication.model;

import java.time.ZonedDateTime;

public class IdentificationProfile {
	private String id;
	private Language locale;
	private Double enrollmentSpeechTime;
	private Double remainingEnrollmentSpeechTime;
	private ZonedDateTime createdDateTime;
	private ZonedDateTime lastActionDateTime;
	private EnrollmentStatus enrollmentStatus;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Language getLocale() {
		return locale;
	}
	public void setLocale(Language locale) {
		this.locale = locale;
	}
	public Double getEnrollmentSpeechTime() {
		return enrollmentSpeechTime;
	}
	public void setEnrollmentSpeechTime(Double enrollmentSpeechTime) {
		this.enrollmentSpeechTime = enrollmentSpeechTime;
	}
	public Double getRemainingEnrollmentSpeechTime() {
		return remainingEnrollmentSpeechTime;
	}
	public void setRemainingEnrollmentSpeechTime(Double remainingEnrollmentSpeechTime) {
		this.remainingEnrollmentSpeechTime = remainingEnrollmentSpeechTime;
	}
	public ZonedDateTime getCreatedDateTime() {
		return createdDateTime;
	}
	public void setCreatedDateTime(ZonedDateTime createdDateTime) {
		this.createdDateTime = createdDateTime;
	}
	public ZonedDateTime getLastActionDateTime() {
		return lastActionDateTime;
	}
	public void setLastActionDateTime(ZonedDateTime lastActionDateTime) {
		this.lastActionDateTime = lastActionDateTime;
	}
	public EnrollmentStatus getEnrollmentStatus() {
		return enrollmentStatus;
	}
	public void setEnrollmentStatus(EnrollmentStatus enrollmentStatus) {
		this.enrollmentStatus = enrollmentStatus;
	}
	
	
}
