package gsu.hmi.speechauthentication.service;

import java.util.List;

import gsu.hmi.speechauthentication.controller.VerificationController;
import gsu.hmi.speechauthentication.model.User;

public class VerificationService {
	VerificationController verificationController = new VerificationController();
	
	public void enrollVerificationProfileByUser(User user) {
		verificationController.azureVerificationEnrollmentRequest(user);
	}
	
	public void resetVerificationProfileByUser(User user) {
		verificationController.resetVerificationProfileEnrollmentByUser(user);
	}
	
	public List<String> getPhrasesForEnglish() {
		return verificationController.getVerificationPhrases();
	}
}
