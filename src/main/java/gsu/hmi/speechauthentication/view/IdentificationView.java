package gsu.hmi.speechauthentication.view;

import java.io.IOException;

import gsu.hmi.speechauthentication.model.EnrollmentStatus;
import gsu.hmi.speechauthentication.model.User;
import gsu.hmi.speechauthentication.service.IdentificationService;
import gsu.hmi.speechauthentication.service.UserService;
import gsu.hmi.speechauthentication.service.VoiceRecorderService;

public class IdentificationView {
	UserService userService = new UserService();
	VoiceRecorderService voiceRecorderService = new VoiceRecorderService();
	IdentificationService identificationService = new IdentificationService();

	public User createIdentificationProfile(User user) {
		userService.createIdentificationProfile(user);
		System.out.println("Identification profile created");
		System.out.println("User : " + user.getName());
		System.out.println("Identification profile ID : " + user.getIdentificationProfile().getId());
		System.out.println("-------------------------------------");
		return user;
	}
	
	public User enrollIdentificationProfile(User user) throws IOException {		
		while (!EnrollmentStatus.ENROLLED.equals(user.getIdentificationProfile().getEnrollmentStatus())) {
			voiceRecorderService.recordVoiceForMicrosoftAzure();
			identificationService.enrollIdentificationProfileByUser(user, true);
			System.out.println("Remaining enrollment time : " + user.getIdentificationProfile().getRemainingEnrollmentSpeechTime());
			System.out.println("-------------------------------------");			
		}
		
		System.out.println("Enrollment successfully completed for user " + user.getName());
		System.out.println("-------------------------------------");
		return user;
	}
}
