package ph.mramos.ocjsfd.controller;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.inject.Named;
import javax.validation.Valid;

import ph.mramos.ocjsfd.model.User;

@Named
@RequestScoped
public class ValidatorController {

	private String username;
	private String name;
	private Integer age;
	private Double salary;
	private String ipAddress;
	private String address;
	
	@Valid
	private User user = new User();
	
	public String submit() {
		Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
		flash.put("username", username);
		flash.put("name", name);
		flash.put("age", age);
		flash.put("salary", salary);
		flash.put("ipAddress", ipAddress);
		flash.put("address", address);
		flash.put("user", user);
		return "success?faces-redirect=true";
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
