package ph.mramos.ocjsfd.controller;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.inject.Named;

import ph.mramos.ocjsfd.model.User;

@Named
@RequestScoped
public class ValidatorController {

	private String username;
	private String name;
	private int age;
	private double salary;
	private String ipAddress;
	private User user;
	private String address;
	
	public String submit() {
		Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
		flash.put("username", username);
		flash.put("name", name);
		flash.put("age", age);
		flash.put("salary", salary);
		flash.put("ipAddress", ipAddress);
		flash.put("user", user);
		flash.put("address", address);
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
