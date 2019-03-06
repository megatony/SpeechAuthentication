package gsu.hmi.speechauthentication.controller;

import gsu.hmi.speechauthentication.model.User;
import gsu.hmi.speechauthentication.view.UserView;

public class UserController {
	private User user;
	private UserView userView;
	
	public UserController(User user, UserView userView) {
		this.user = user;
		this.userView = userView;
	}
	
}
