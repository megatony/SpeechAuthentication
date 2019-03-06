package gsu.hmi.speechauthentication.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.client.utils.URIBuilder;

import gsu.hmi.speechauthentication.model.AzureHttpClient;
import gsu.hmi.speechauthentication.model.IdentificationProfile;
import gsu.hmi.speechauthentication.model.User;

public class IdentificationController {
	AzureHttpClient azureHttpClient = new AzureHttpClient();
	private String ENDPOINT_URL = "https://westus.api.cognitive.microsoft.com/spid/v1.0/";
	
	public void azureIdentificationEnrollmentRequest(String enrollmentProfileId, boolean isShortAudio) {
		try {
			URIBuilder builder = new URIBuilder(ENDPOINT_URL + "identificationProfiles/" + enrollmentProfileId + "/enroll");

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
	}
	
	public void resetIdentificationProfileEnrollmentByUser(User user) {				
		try {
			URIBuilder builder = new URIBuilder(ENDPOINT_URL + "identificationProfiles/" + user.getIdentificationProfile().getId() + "/reset");

			URI uri = builder.build();
			azureHttpClient.preparePostRequest(uri);
			azureHttpClient.executePostRequestAndGetEntity();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public IdentificationProfile getIdentificationProfileByUser(User user) {
		IdentificationProfile identificationProfile = new IdentificationProfile();
				
		try {
			URIBuilder builder = new URIBuilder(ENDPOINT_URL + "identificationProfiles/" + user.getIdentificationProfile().getId());
			URI uri = builder.build();
			azureHttpClient.prepareGetRequest(uri);
			azureHttpClient.executeGetRequestAndGetEntity();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return identificationProfile;
	}
	
	public List<IdentificationProfile> getAllIdentificationProfiles() {		
		try {
			URIBuilder builder = new URIBuilder(ENDPOINT_URL + "identificationProfiles");
			URI uri = builder.build();
			azureHttpClient.prepareGetRequest(uri);
			azureHttpClient.executeGetRequestAndGetEntity();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//TODO: Implement
		return new ArrayList<IdentificationProfile>();
		

	}
}
