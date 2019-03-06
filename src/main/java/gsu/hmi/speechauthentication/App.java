package gsu.hmi.speechauthentication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import gsu.hmi.speechauthentication.model.IdentificationProfile;
import gsu.hmi.speechauthentication.model.Language;
import gsu.hmi.speechauthentication.model.User;
import gsu.hmi.speechauthentication.model.VerificationProfile;
import gsu.hmi.speechauthentication.view.RecognitionView;
import gsu.hmi.speechauthentication.view.UserView;
import gsu.hmi.speechauthentication.view.VerificationView;

public class App 
{
	private static ArrayList<User> users = new ArrayList();
	
	public static void menu() throws IOException {
		UserView userView = new UserView();
    	VerificationView verificationView = new VerificationView();
    	RecognitionView recognitionView = new RecognitionView();
    	
		System.out.println("Welcome!");
    	System.out.println("1 - Login");
    	System.out.println("2 - New User");
    	System.out.println("3 - All Users");
    	System.out.println("Please select 1, 2 or 3. You may press any different key to be exit.");
		BufferedReader ob = new BufferedReader(new InputStreamReader(System.in));
		String ans = ob.readLine();
		
		if (ans.equals("1")) {
			System.out.println("Enter your username");
			BufferedReader ob1 = new BufferedReader(new InputStreamReader(System.in));
			String ans1 = ob1.readLine();
			User user = userView.findUser(ans1, users);
	    	
	    	if (recognitionView.verifyUser(user)) {
	    		System.out.println("Login process is successful for " + user.getName() + " " + user.getVerificationProfile().getId());
	    	} else {
	    		System.out.println("Login failed for " + user.getName() + " " + user.getVerificationProfile().getId());
	    	}
	    	System.out.println("-------------------");
			menu();
		} else if (ans.equals("2")) {
			User user = userView.createUser();
	    	VerificationProfile verificationProfile = new VerificationProfile();
	    	verificationProfile.setLocale(Language.English);
	    	user.setVerificationProfile(verificationProfile);
	    	
	    	user = verificationView.createVerificationProfile(user);
			user = verificationView.enrollVerificationProfile(user);

			users.add(user);
			System.out.println("-------------------");
			menu();
		} else if (ans.equals("3")) {
			System.out.println("User list: ");
			for (User user : users) {
				System.out.println(user.getName() + " ID: " + user.getVerificationProfile().getId());
				System.out.println("-------------------");
			}
			menu();
		} else {
			System.out.println("-------------------");
			menu();
			System.exit(0);
		}
	}
	
    public static void main( String[] args ) throws IOException
    {
    	menu();   	
    }
}
