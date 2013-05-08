package com.oneweek.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

import com.oneweek.model.entity.User;
import com.oneweek.model.service.LoginService;
import com.oneweek.util.JSFUtils;
import com.oneweek.util.MessageProvider;

@ManagedBean(name = "loginMBean")
@RequestScoped
public class LoginMBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String email;
	private String password;
	private User user;
	
	
	@PostConstruct
	public void init() {
		this.user = new User();
	}

	public String validate() throws Exception {
		User authenticated = new User();
		authenticated = LoginService.getInstance().validate(user);
		try {
			if (StringUtils.isEmpty(authenticated.getEmail())) {
				JSFUtils.addMessageInfo(MessageProvider.getInstance().getValue("userNotFound"));
				return "index.xhtml";
			} else {
				FacesContext fc = FacesContext.getCurrentInstance();
				HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
				session.setAttribute("authenticated", authenticated);
				return "/modules/main.xhtml";
			}
		} catch (Exception e) {
			JSFUtils.addMessageInfo("User not found!");
		}
		return null;
	}
	
	public String invalidate() {
		FacesContext fc = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
		session.invalidate();
		return "/index.xhtml";
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
