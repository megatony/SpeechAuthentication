package gsu.hmi.speechauthentication.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import gsu.hmi.speechauthentication.model.User;
import gsu.hmi.speechauthentication.service.RecognitionService;
import gsu.hmi.speechauthentication.service.UserService;
import gsu.hmi.speechauthentication.service.VoiceRecorderService;

public class RecognitionView {
	UserService userService = new UserService();
	VoiceRecorderService voiceRecorderService = new VoiceRecorderService();
	RecognitionService recognitionService = new RecognitionService();

	public String identifyUser(List<User> users) throws IOException {
		System.out.println("When you are ready, please any button to identify yourself");
		BufferedReader ob = new BufferedReader(new InputStreamReader(System.in));
		
		voiceRecorderService.recordVoiceForMicrosoftAzure();
		
		return recognitionService.getIdentifiedUserIdFromUsers(users);
	}
	
	public boolean verifyUser(User user) throws IOException {
		System.out.println("When you are ready, please enter to start");
		
		BufferedReader ob = new BufferedReader(new InputStreamReader(System.in));
		String waitForAnswer = ob.readLine();
		
		voiceRecorderService.recordVoiceForMicrosoftAzure();
		
		if (recognitionService.isUserVerified(user)) {
			return true;
		}
		
		return false;
	}
}
