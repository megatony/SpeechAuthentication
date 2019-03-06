package gsu.hmi.speechauthentication.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import gsu.hmi.speechauthentication.model.EnrollmentStatus;
import gsu.hmi.speechauthentication.model.User;
import gsu.hmi.speechauthentication.service.RecognitionService;
import gsu.hmi.speechauthentication.service.UserService;
import gsu.hmi.speechauthentication.service.VerificationService;
import gsu.hmi.speechauthentication.service.VoiceRecorderService;


public class VerificationView {
	UserService userService = new UserService();
	VoiceRecorderService voiceRecorderService = new VoiceRecorderService();
	VerificationService verificationService = new VerificationService();
	RecognitionService recognitionService = new RecognitionService();

	public User createVerificationProfile(User user) {
		userService.createVerificationProfile(user);
		System.out.println("Verification profile created");
		System.out.println("User : " + user.getName());
		System.out.println("Verification profile ID : " + user.getVerificationProfile().getId());
		System.out.println("-------------------------------------");
		return user;
	}
	
	public User enrollVerificationProfile(User user) throws IOException {
		System.out.println("Please say one of the these sentences: ");
		for (String phrase : verificationService.getPhrasesForEnglish()) {
			System.out.println(phrase);
		}
		System.out.println("When you are ready, please enter to start");
		
		BufferedReader ob = new BufferedReader(new InputStreamReader(System.in));
		String waitForAnswer = ob.readLine();
		
		while (!EnrollmentStatus.ENROLLED.equals(user.getVerificationProfile().getEnrollmentStatus())) {
			voiceRecorderService.recordVoiceForMicrosoftAzure();
			verificationService.enrollVerificationProfileByUser(user);
			System.out.println("Remaining enrollment count : " + user.getVerificationProfile().getRemainingEnrollmentsCount());
			System.out.println("-------------------------------------");			
		}
		
		System.out.println("Enrollment successfully completed for user " + user.getName());
		System.out.println("-------------------------------------");
		return user;
	}
}
