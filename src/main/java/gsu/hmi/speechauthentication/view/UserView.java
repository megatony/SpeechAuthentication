package gsu.hmi.speechauthentication.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import gsu.hmi.speechauthentication.model.EnrollmentStatus;
import gsu.hmi.speechauthentication.model.User;
import gsu.hmi.speechauthentication.service.IdentificationService;
import gsu.hmi.speechauthentication.service.RecognitionService;
import gsu.hmi.speechauthentication.service.UserService;
import gsu.hmi.speechauthentication.service.VerificationService;
import gsu.hmi.speechauthentication.service.VoiceRecorderService;

public class UserView {
	UserService userService = new UserService();
	
	public User createUser() {
		String name = "";
		try {
			System.out.println("Enter an user name: ");
			BufferedReader ob = new BufferedReader(new InputStreamReader(System.in));
			name = ob.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("-------------------------------------");
		return userService.createUserProfile(name);
	}
	
	public User findUser(String userName, List<User> users) {
		return userService.getUserByUserName(userName, users);
	}
}
