package com.webapp.login;

public class LoginService {
	
	public boolean isUservalid(String username, String password)
	{
		if(username.equals("agilesh")&& password.equals("dummy")) {
			return true;
		}
		return false;
	}

}
