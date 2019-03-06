package gsu.hmi.speechauthentication.service;

import java.util.ArrayList;
import java.util.List;

import gsu.hmi.speechauthentication.controller.RecognitionController;
import gsu.hmi.speechauthentication.model.Operation;
import gsu.hmi.speechauthentication.model.OperationStatus;
import gsu.hmi.speechauthentication.model.User;

public class RecognitionService {
	RecognitionController recognitionController = new RecognitionController();
	
	public OperationStatus getOperationStatus(Operation operation) {
		recognitionController.getRecognitionStatusByOperationId(operation.getId());
		return operation.getStatus();
	}
	
	public String getIdentifiedUserIdFromUsers(List<User> users) {
		List<String> enrollmentProfileIds = new ArrayList<String>();
		for (User user : users) {
			enrollmentProfileIds.add(user.getIdentificationProfile().getId());
		}
		Operation operation = recognitionController.azureIdentificationRequest(enrollmentProfileIds, true);
		
		while (operation.getStatus().equals(OperationStatus.NOT_STARTED) || operation.getStatus().equals(OperationStatus.RUNNING)) {
			System.out.println("INFO: Operation status is " + operation.getStatus() + " trying again"); 
			operation = recognitionController.azureIdentificationRequest(enrollmentProfileIds, true);
		}
		
		if (operation.getStatus().equals(OperationStatus.SUCCEEDED)) {
			return operation.getIdentifiedProfileId();
		}
		
		return "";
	}
	
	public boolean isUserVerified(User user) {
		String result = recognitionController.azureVerificationRequest(user);
		
		if (result.equals("Accept")) {
			return true;
		} else {
			return false;
		}
	}

}
