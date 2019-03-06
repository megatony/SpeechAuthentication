package gsu.hmi.speechauthentication.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import gsu.hmi.speechauthentication.model.AzureHttpClient;
import gsu.hmi.speechauthentication.model.EnrollmentStatus;
import gsu.hmi.speechauthentication.model.User;
import gsu.hmi.speechauthentication.model.VerificationProfile;

public class VerificationController {
	AzureHttpClient azureHttpClient = new AzureHttpClient();
	private String ENDPOINT_URL = "https://westus.api.cognitive.microsoft.com/spid/v1.0/";
	
	public void azureVerificationEnrollmentRequest(User user) {
		try {
			VerificationProfile verificationProfile = user.getVerificationProfile();

			URIBuilder builder = new URIBuilder(ENDPOINT_URL + "verificationProfiles/" + user.getVerificationProfile().getId() + "/enroll");

			URI uri = builder.build();
			azureHttpClient.preparePostRequest(uri);
			azureHttpClient.addVoiceFileToPostRequest();
			String jsonResponse = azureHttpClient.executePostRequestAndGetEntity();
			
			JSONObject jsonObject = new JSONObject(jsonResponse);
			String enrollingStatus = jsonObject.getString("enrollmentStatus");
			Long enrollmentsCount = jsonObject.getLong("enrollmentsCount");
			Long remainingEnrollmentsCount = jsonObject.getLong("remainingEnrollments");
			String phrase = jsonObject.getString("phrase");
			
			verificationProfile.setEnrollmentsCount(enrollmentsCount);
			verificationProfile.setRemainingEnrollmentsCount(remainingEnrollmentsCount);
			
			if (enrollingStatus.equals("Enrolling")) {
				verificationProfile.setEnrollmentStatus(EnrollmentStatus.ENROLLING);
			} else if (enrollingStatus.equals("Training")) {
				verificationProfile.setEnrollmentStatus(EnrollmentStatus.TRAINING);

			} else if (enrollingStatus.equals("Enrolled")) {
				verificationProfile.setEnrollmentStatus(EnrollmentStatus.ENROLLED);
			}
			
			user.setVerificationProfile(verificationProfile);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void resetVerificationProfileEnrollmentByUser(User user) {
		try {
			URIBuilder builder = new URIBuilder(ENDPOINT_URL + "verificationProfiles/" + user.getVerificationProfile().getId() + "/reset");

			URI uri = builder.build();
			azureHttpClient.preparePostRequest(uri);
			azureHttpClient.executePostRequestAndGetEntity();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public List<VerificationProfile> getAllVerificationProfiles() {		
		try {
			URIBuilder builder = new URIBuilder(ENDPOINT_URL + "verificationProfiles");
			URI uri = builder.build();
			azureHttpClient.prepareGetRequest(uri);
			azureHttpClient.executeGetRequestAndGetEntity();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//TODO: Implement
		return new ArrayList<VerificationProfile>();
	}
	
	public VerificationProfile getVerificationProfileByUser(User user) {
		VerificationProfile verificationProfile = new VerificationProfile();
				
		try {
			URIBuilder builder = new URIBuilder(ENDPOINT_URL + "verificationProfiles/" + user.getVerificationProfile().getId());
			URI uri = builder.build();
			azureHttpClient.prepareGetRequest(uri);
			azureHttpClient.executeGetRequestAndGetEntity();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return verificationProfile;
	}
	
	public List<String> getVerificationPhrases() {
				
		try {
			URIBuilder builder = new URIBuilder(ENDPOINT_URL + "verificationPhrases?locale=" + "en-US");
			URI uri = builder.build();
			azureHttpClient.prepareGetRequest(uri);
			azureHttpClient.executeGetRequestAndGetEntity();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new ArrayList<String>();
	}

}
