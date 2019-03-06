package gsu.hmi.speechauthentication.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class AzureHttpClient {

	private static String OCP_APIM_SUBSCRIPTION_KEY = "MASKED_AZURE_PASS";
	static final String RECORDING_PATH = "C:/Users/GLB90062128/Documents/Fax/xd.wav";
	
	private HttpClient httpclient;
	private HttpPost postRequest;
	private HttpGet getRequest;
	private HttpDelete deleteRequest;
	
	public AzureHttpClient() {
		 httpclient = HttpClients.createDefault();
	}
	
	public void addAzureValidationToRequest(HttpRequest httpRequest) {
		httpRequest.setHeader("Content-Type", "application/json");
		httpRequest.setHeader("Ocp-Apim-Subscription-Key", OCP_APIM_SUBSCRIPTION_KEY);	
	}
	
	public void preparePostRequest(URI uri) {
		postRequest = new HttpPost(uri);
		addAzureValidationToRequest(postRequest);
	}
	
	public void prepareGetRequest(URI uri) {
		getRequest = new HttpGet(uri);
		addAzureValidationToRequest(getRequest);
	}
	
	public void prepareDeleteRequest(URI uri) {
		deleteRequest = new HttpDelete(uri);
		addAzureValidationToRequest(deleteRequest);
	}
	
	public String executePostRequestAndGetEntity() {
		HttpResponse response;
		try {
			response = httpclient.execute(postRequest);
			String responseAsString = IOUtils.toString(response.getEntity().getContent());
			System.out.println(responseAsString);
	        return responseAsString;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public String executeGetRequestAndGetEntity() {
		HttpResponse response;
		try {
			response = httpclient.execute(getRequest);
			String responseAsString = IOUtils.toString(response.getEntity().getContent());
			System.out.println(responseAsString);
	        return responseAsString;
	        } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public String executeDeleteRequestAndGetEntity() {
		HttpResponse response;
		try {
			response = httpclient.execute(deleteRequest);
			String responseAsString = IOUtils.toString(response.getEntity().getContent());
			System.out.println(responseAsString);
	        return responseAsString;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public void addVoiceFileToPostRequest() {
		File recordedVoice = new File(RECORDING_PATH);
		// TODO: Recording path must be common
		
		InputStreamEntity reqEntity;
		try {
			reqEntity = new InputStreamEntity(
			            new FileInputStream(recordedVoice), -1, ContentType.APPLICATION_OCTET_STREAM);
			reqEntity.setChunked(true);
	        
			postRequest.setEntity(reqEntity);
		} catch (FileNotFoundException e) {
			System.out.println("ERROR: File path cannot found " + RECORDING_PATH);
		}       
	}
	
	public void addLanguageToPostRequest(String language) {
		StringEntity reqEntity;
		try {
			//TODO: Language should get from language obj
			reqEntity = new StringEntity("{\"locale\":\"en-us\"}");
	        reqEntity.setContentType(ContentType.APPLICATION_JSON.getMimeType());

	        postRequest.setEntity(reqEntity);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
