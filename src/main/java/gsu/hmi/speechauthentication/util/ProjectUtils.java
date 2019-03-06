package gsu.hmi.speechauthentication.util;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.json.JSONArray;
import org.json.JSONObject;

public class ProjectUtils {
	
	public void to(HttpEntity response) {
		try {
			String json = IOUtils.toString(response.getContent());
			JSONArray array = new JSONArray(json);
			for (int i = 0; i < array.length(); i++) {
			    JSONObject object = array.getJSONObject(i);
			    System.out.println(object.getString("error"));
			}
		} catch (Exception e) {
			
		}
		
	} 
}
