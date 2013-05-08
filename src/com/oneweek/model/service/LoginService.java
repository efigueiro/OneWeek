package com.oneweek.model.service;

import com.oneweek.model.dao.LoginDao;
import com.oneweek.model.entity.User;

public class LoginService {

	private static LoginService loginService;

	private LoginService() {
	}

	public static LoginService getInstance() {
		if (loginService == null) {
			loginService = new LoginService();
		}
		return loginService;
	}
	
	public User validate (User user) throws Exception {
		User authenticated = new User();
		authenticated = LoginDao.getInstance().validate(user); 
		return authenticated;
	}

}
