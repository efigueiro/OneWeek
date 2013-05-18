package com.oneweek.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "navigationMBean")
@RequestScoped
public class NavigationMBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String createCustomer() {
		return "/modules/customer/create.xhtml";
	}
	
	public String retrieveCustomer() {
		return "/modules/customer/retrieve.xhtml";
	}
}
