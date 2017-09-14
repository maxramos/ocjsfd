package ph.mramos.ocjsfd.controller;

import javax.enterprise.context.RequestScoped;
import javax.faces.event.ComponentSystemEvent;
import javax.inject.Named;

@Named
@RequestScoped
public class NavigationController {
	
	private String username;
	private String message;
	
	public void submit() {
		if ("max".equals(username) || "mac".equals(username)) {
//			return "success";
		}
		
//		return "fail";
	}

	public void onBeforeRenderView(ComponentSystemEvent event) {
		message = "This is a message";
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
