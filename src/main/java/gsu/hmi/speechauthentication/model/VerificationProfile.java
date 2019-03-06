package gsu.hmi.speechauthentication.model;

import java.time.ZonedDateTime;

public class VerificationProfile {
	
	private String id;
	private Language locale;
	private Long enrollmentsCount;
	private Long remainingEnrollmentsCount;
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
	public Long getEnrollmentsCount() {
		return enrollmentsCount;
	}
	public void setEnrollmentsCount(Long enrollmentsCount) {
		this.enrollmentsCount = enrollmentsCount;
	}
	public Long getRemainingEnrollmentsCount() {
		return remainingEnrollmentsCount;
	}
	public void setRemainingEnrollmentsCount(Long remainingEnrollmentsCount) {
		this.remainingEnrollmentsCount = remainingEnrollmentsCount;
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
