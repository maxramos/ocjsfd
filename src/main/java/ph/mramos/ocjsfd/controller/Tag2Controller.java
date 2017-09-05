package ph.mramos.ocjsfd.controller;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.inject.Named;

@Named
@RequestScoped
public class Tag2Controller {

	private String timestamp;
	private String username;
	private String password;
	private String address;

	public String save() {
		Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
		flash.put("timestamp", timestamp);
		flash.put("username", username);
		flash.put("password", password);
		flash.put("address", address);
		
		return "success?faces-redirect=true";
	}
	
	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
