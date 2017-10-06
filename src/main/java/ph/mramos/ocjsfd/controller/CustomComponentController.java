package ph.mramos.ocjsfd.controller;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.inject.Named;

@Named
@RequestScoped
public class CustomComponentController {

	private Integer month = 1;
	private Integer year = 2017;

	public String submit() {
		Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
		flash.put("month", month);
		flash.put("year", year);
		return "success?faces-redirect=true";
	}
	
	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

}
