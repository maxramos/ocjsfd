package ph.mramos.ocjsfd.controller;

import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.event.ComponentSystemEvent;
import javax.inject.Named;

@Named
@RequestScoped
public class NavigationController {
	
	private String username;
	private String message;
	private Integer age = 20;
	private String birthPlace = "Lucena City";
	
	public String submit() {
		if ("max".equals(username)) {
			return "success";
		}
		
		if ("mac".equals(username)) {
			return null;
		}
		 
		return "fail";
	}
	
	public String submit2() {
		Map<String, String> map = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
		flash.put("age", map.get("age"));
		flash.put("birthPlace", map.get("birthPlace"));
		return "redirect4?faces-redirect=true";
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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getBirthPlace() {
		return birthPlace;
	}

	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}

}
