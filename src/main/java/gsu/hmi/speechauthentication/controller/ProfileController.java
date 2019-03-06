package gsu.hmi.speechauthentication.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.json.JSONArray;
import org.json.JSONObject;

import gsu.hmi.speechauthentication.model.AzureHttpClient;
import gsu.hmi.speechauthentication.model.IdentificationProfile;
import gsu.hmi.speechauthentication.model.User;
import gsu.hmi.speechauthentication.model.VerificationProfile;
import gsu.hmi.speechauthentication.util.ProjectUtils;

public class ProfileController {
	AzureHttpClient azureHttpClient = new AzureHttpClient();
	private String ENDPOINT_URL = "https://westus.api.cognitive.microsoft.com/spid/v1.0/";

	public void createIdentificationProfileForUser(User user) {
		//TODO: Get Profile Id from response
		IdentificationProfile identificationProfile = new IdentificationProfile();

		try {
			URIBuilder builder = new URIBuilder(ENDPOINT_URL + "identificationProfiles");
			URI uri = builder.build();
			
			azureHttpClient.preparePostRequest(uri);
			azureHttpClient.addLanguageToPostRequest(identificationProfile.getLocale().toString());

			String json = azureHttpClient.executePostRequestAndGetEntity();
			JSONObject json2 = new JSONObject(json);
			System.out.println(json2.getString("verificationProfileId"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		user.setIdentificationProfile(identificationProfile);
	}
	
	public void createVerificationProfileForUser(User user) {		
		
		try {
			URIBuilder builder = new URIBuilder(ENDPOINT_URL + "verificationProfiles");
			URI uri = builder.build();
			
			azureHttpClient.preparePostRequest(uri);
			azureHttpClient.addLanguageToPostRequest(user.getVerificationProfile().getLocale().toString());
			String jsonResponse = azureHttpClient.executePostRequestAndGetEntity();
			
			JSONObject jsonObject = new JSONObject(jsonResponse);
			user.getVerificationProfile().setId(jsonObject.getString("verificationProfileId"));			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteIdentificationProfileForUser(User user) {		
		try {
			URIBuilder builder = new URIBuilder(ENDPOINT_URL + "identificationProfiles/" + user.getIdentificationProfile().getId());
			URI uri = builder.build();
			azureHttpClient.prepareDeleteRequest(uri);
			azureHttpClient.executeDeleteRequestAndGetEntity();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		user.setIdentificationProfile(null);
	}
	
	public void deleteVerificationProfileForUser(User user) {
		
		try {
			URIBuilder builder = new URIBuilder(ENDPOINT_URL + "verificationProfiles/" + user.getVerificationProfile().getId());
			URI uri = builder.build();
			azureHttpClient.prepareDeleteRequest(uri);
			azureHttpClient.executeDeleteRequestAndGetEntity();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		user.setVerificationProfile(null);

	}
}
