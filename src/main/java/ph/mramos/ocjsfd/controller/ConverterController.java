package ph.mramos.ocjsfd.controller;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import ph.mramos.ocjsfd.model.User;

@Named
@RequestScoped
public class ConverterController {

	private Double weight = 9_246.1357D;
	private BigDecimal cost = new BigDecimal("95478.32");
	private Double percentage = 0.9568D;
	
	private Date birthday = Date.from(LocalDate.of(1990, 06, 25).atStartOfDay(ZoneId.of("UTC")).toInstant());
	private Date birthtime = Date.from(LocalTime.of(13, 30, 45).atDate(LocalDate.now()).atZone(ZoneId.of("UTC")).toInstant());
	private Date timestamp = Date.from(LocalDateTime.now().atZone(ZoneId.of("UTC")).toInstant());
	
	private User user = new User("max");
	
	public String submit() {
		return "success?faces-redirect=true";
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public BigDecimal getCost() {
		return cost;
	}

	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}

	public Double getPercentage() {
		return percentage;
	}

	public void setPercentage(Double percentage) {
		this.percentage = percentage;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Date getBirthtime() {
		return birthtime;
	}

	public void setBirthtime(Date birthtime) {
		this.birthtime = birthtime;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
