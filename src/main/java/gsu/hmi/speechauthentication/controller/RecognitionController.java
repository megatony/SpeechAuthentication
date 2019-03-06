package gsu.hmi.speechauthentication.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.client.utils.URIBuilder;
import org.json.JSONObject;

import gsu.hmi.speechauthentication.model.AzureHttpClient;
import gsu.hmi.speechauthentication.model.Operation;
import gsu.hmi.speechauthentication.model.User;

public class RecognitionController {
	AzureHttpClient azureHttpClient = new AzureHttpClient();
	private String ENDPOINT_URL = "https://westus.api.cognitive.microsoft.com/spid/v1.0/";
	
	public Operation azureIdentificationRequest(List<String> enrollmentProfileIds, boolean isShortAudio) {
		Operation operation = new Operation();
		String preparedProfileIds = "";
		StringBuilder strBuilder = new StringBuilder();

		for (String enrollmentProfileId : enrollmentProfileIds) {
			strBuilder.append(enrollmentProfileId);
			strBuilder.append(",");
		}
		preparedProfileIds = strBuilder.toString();
		preparedProfileIds = preparedProfileIds.substring(0, preparedProfileIds.length() - 1);
		
		try {
			URIBuilder builder = new URIBuilder(ENDPOINT_URL + "identify?identificationProfileIds=" + preparedProfileIds);

			if (isShortAudio) {
				builder.setParameter("shortAudio", Boolean.TRUE.toString());
			}

			URI uri = builder.build();
			azureHttpClient.preparePostRequest(uri);
			azureHttpClient.addVoiceFileToPostRequest();
			azureHttpClient.executePostRequestAndGetEntity();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return operation;
	}
	
	public String azureVerificationRequest(User user) {
		Operation operation = new Operation();
		String string = "";
		try {
			URIBuilder builder = new URIBuilder(ENDPOINT_URL + "verify?verificationProfileId=" + user.getVerificationProfile().getId());

			URI uri = builder.build();
			azureHttpClient.preparePostRequest(uri);
			azureHttpClient.addVoiceFileToPostRequest();
			String jsonResponse = azureHttpClient.executePostRequestAndGetEntity();
			
			JSONObject jsonObject = new JSONObject(jsonResponse);
			string = jsonObject.getString("result");
			String identifiedProfileId = jsonObject.getString("confidence");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return string;
	}
	
	public Operation getRecognitionStatusByOperationId(String operationId) {
		Operation operation = new Operation();
		try {
			URIBuilder builder = new URIBuilder(ENDPOINT_URL + "operations/" + operationId);
			URI uri = builder.build();
			azureHttpClient.prepareGetRequest(uri);
			azureHttpClient.executeGetRequestAndGetEntity();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//TODO: Implement
		return operation;
		
	}
}
