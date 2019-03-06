package gsu.hmi.speechauthentication.service;

import gsu.hmi.speechauthentication.controller.IdentificationController;
import gsu.hmi.speechauthentication.model.User;

public class IdentificationService {
	IdentificationController identificationController = new IdentificationController();
	
	public void enrollIdentificationProfileByUser(User user, Boolean isShortAudio) {
		identificationController.azureIdentificationEnrollmentRequest(user.getIdentificationProfile().getId(), isShortAudio);
	}

}
