package gsu.hmi.speechauthentication.model;

import java.time.ZonedDateTime;

public class Operation {
	
	private String id;
	private OperationStatus status;
	private ZonedDateTime createdDate;
	private ZonedDateTime modifiedDate;
	private String message;
	private String processingResult;
	private EnrollmentStatus enrollmentStatus;
	private Integer enrollmentSpeechTime;
	private Integer remainingEnrollmentSpeechTime;
	private Integer speechTime;
	private String identifiedProfileId;
	private Confidence confidence;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public OperationStatus getStatus() {
		return status;
	}
	public void setStatus(OperationStatus status) {
		this.status = status;
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
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getProcessingResult() {
		return processingResult;
	}
	public void setProcessingResult(String processingResult) {
		this.processingResult = processingResult;
	}
	public EnrollmentStatus getEnrollmentStatus() {
		return enrollmentStatus;
	}
	public void setEnrollmentStatus(EnrollmentStatus enrollmentStatus) {
		this.enrollmentStatus = enrollmentStatus;
	}
	public Integer getEnrollmentSpeechTime() {
		return enrollmentSpeechTime;
	}
	public void setEnrollmentSpeechTime(Integer enrollmentSpeechTime) {
		this.enrollmentSpeechTime = enrollmentSpeechTime;
	}
	public Integer getRemainingEnrollmentSpeechTime() {
		return remainingEnrollmentSpeechTime;
	}
	public void setRemainingEnrollmentSpeechTime(Integer remainingEnrollmentSpeechTime) {
		this.remainingEnrollmentSpeechTime = remainingEnrollmentSpeechTime;
	}
	public Integer getSpeechTime() {
		return speechTime;
	}
	public void setSpeechTime(Integer speechTime) {
		this.speechTime = speechTime;
	}
	public String getIdentifiedProfileId() {
		return identifiedProfileId;
	}
	public void setIdentifiedProfileId(String identifiedProfileId) {
		this.identifiedProfileId = identifiedProfileId;
	}
	public Confidence getConfidence() {
		return confidence;
	}
	public void setConfidence(Confidence confidence) {
		this.confidence = confidence;
	}
	
	
}
