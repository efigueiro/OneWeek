package com.oneweek.util;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

import javax.faces.context.FacesContext;

public class MessageProvider {

	private static MessageProvider messageProvider;
	private ResourceBundle bundle;
	
	private MessageProvider() {
	}

	public static MessageProvider getInstance() {
		if (messageProvider == null) {
			messageProvider = new MessageProvider();
		}
		return messageProvider;
	}

	public ResourceBundle getBundle() {
		if (bundle == null) {
			FacesContext context = FacesContext.getCurrentInstance();
			bundle = context.getApplication().getResourceBundle(context, "msg");
		}
		return bundle;
	}
	
	
	public String getValue(String key) {
		String result = null;
		try {
			result = getBundle().getString(key);
		} catch (MissingResourceException e) {
			result = "???" + key + "??? not found";
		}
		return result;
	}

}
