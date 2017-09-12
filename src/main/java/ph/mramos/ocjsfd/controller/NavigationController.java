package ph.mramos.ocjsfd.controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class NavigationController {
	
	private String username;
	
	public String submit() {
		if ("max".equals(username)) {
			return "success";
		}
		
		return "fail";
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
