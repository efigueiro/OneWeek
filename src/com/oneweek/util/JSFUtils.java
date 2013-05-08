/**
 * 
 */
package com.oneweek.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 * @author everson_figueiro
 * 
 */
public class JSFUtils {

	public final static void addMessageInfo(String message, String detail) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, message, detail));
	}

	public final static void addMessageInfo(String message) {
		addMessageInfo(message, "");
	}

	public final static void addMessageWarn(String message, String detail) {
		FacesMessage facesMessage = new FacesMessage(
				FacesMessage.SEVERITY_WARN, message, detail);
		FacesContext.getCurrentInstance().addMessage(null, facesMessage);
	}

	public final static void addMessageWarn(String message) {
		addMessageWarn(message, "");
	}

	public final static void addMessageError(String message, String detail) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_ERROR, message, ""));
	}

	public final static void addMessageError(String message) {
		addMessageError(message, "");
	}

}
