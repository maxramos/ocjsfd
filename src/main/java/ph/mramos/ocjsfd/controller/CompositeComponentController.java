package ph.mramos.ocjsfd.controller;

import java.util.Date;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.inject.Named;

@Named
@RequestScoped
public class CompositeComponentController {

//	@Future
	private Date expiry;

	public String submit() {
		Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
		flash.put("expiry", expiry);
		return "success?faces-redirect=true";
	}

	public Date getExpiry() {
		return expiry;
	}

	public void setExpiry(Date expiry) {
		this.expiry = expiry;
	}

}
