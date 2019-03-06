package gsu.hmi.speechauthentication.service;

import java.time.ZonedDateTime;
import java.util.List;

import gsu.hmi.speechauthentication.controller.ProfileController;
import gsu.hmi.speechauthentication.model.User;

public class UserService {
	ProfileController profileController = new ProfileController();
	
	public User createUserProfile(String userName) {
		User user = new User();
		user.setCreatedDate(ZonedDateTime.now());
		user.setModifiedDate(ZonedDateTime.now());
		user.setName(userName);
		return user;
	}
	
	public User getUserByUserName(String userName, List<User> users) {
		for (User user : users) {
			if (userName.equals(user.getName())) {
				return user;
			} else {
				continue;
			}
		}
		return null;
	}
	
	public User createIdentificationProfile(User user) {
		profileController.createIdentificationProfileForUser(user);
		return user;
	}
	
	public User createVerificationProfile(User user) {
		profileController.createVerificationProfileForUser(user);
		return user;
	}
	
	public User deleteIdentificationProfile(User user) {
		profileController.deleteIdentificationProfileForUser(user);
		return user;
	}
	
	public User deleteVerificationProfile(User user) {
		profileController.deleteVerificationProfileForUser(user);
		return user;
	}
	
	public void deleteUserProfile(User user) {
		//TODO: After hibernate integration
	}
	
	public List<User> getAllProfiles() {
		//TODO: After hibernate integration
		return null;
	}

}
