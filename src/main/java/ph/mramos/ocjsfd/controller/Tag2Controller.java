package ph.mramos.ocjsfd.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.model.SelectItem;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Named
@RequestScoped
public class Tag2Controller {

	private static final Logger log = LoggerFactory.getLogger(Tag2Controller.class);

	private String timestamp;
	private String username;
	private String password;
	private String address;
	private String maritalStatus;
	private boolean employed;
	private List<String> food;
	private String country;
	private List<String> drink;
	private Integer salary;
	private List<String> color;

	public String save() {
		Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
		flash.put("timestamp", timestamp);
		flash.put("username", username);
		flash.put("password", password);
		flash.put("address", address);
		flash.put("maritalStatus", maritalStatus);
		flash.put("employed", employed);
		flash.put("food", food);
		flash.put("country", country);
		flash.put("drink", drink);
		flash.put("salary", salary);
		flash.put("color", color);

		if (food instanceof ArrayList) {
			log.info("Collection is ArrayList");
		} else if (food instanceof LinkedList) {
			log.info("Collection is LinkedList");
		} else {
			log.info("Collection is unknown");
		}

		return "success?faces-redirect=true";
	}

	public List<String> getFoods() {
		return Arrays.asList("Chicken", "Burger", "Spaghetti");
	}

	public Map<String, String> getCountries() {
		Map<String, String> countries = new LinkedHashMap<>();
		countries.put("Philippines", "ph");
		countries.put("United States", "us");
		countries.put("China", "ch");
		countries.put("Japan", "jp");
		return countries;
	}

	public String[] getDrinks() {
		return Arrays.asList("Coke", "Sprite", "Royal").toArray(new String[3]);
	}

	public SelectItem[] getSalaries() {
		return new SelectItem[] {
				new SelectItem(250_000, "< 250,000"),
				new SelectItem(500_000, "< 500,000"),
				new SelectItem(750_000, "< 750,000"),
				new SelectItem(1_000_000, "< 1,000,000")
		};
	}

	public Set<String> getColors() {
		return new TreeSet<>(Arrays.asList("Red", "Blue", "Yellow", "Orange"));
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

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public boolean isEmployed() {
		return employed;
	}

	public void setEmployed(boolean employed) {
		this.employed = employed;
	}

	public List<String> getFood() {
		return food;
	}

	public void setFood(List<String> food) {
		this.food = food;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public List<String> getDrink() {
		return drink;
	}

	public void setDrink(List<String> drink) {
		this.drink = drink;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public List<String> getColor() {
		return color;
	}

	public void setColor(List<String> color) {
		this.color = color;
	}

}
