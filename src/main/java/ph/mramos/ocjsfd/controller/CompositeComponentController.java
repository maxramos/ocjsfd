package ph.mramos.ocjsfd.controller;

import java.util.Date;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Named
@RequestScoped
public class CompositeComponentController {

	private static final Logger log = LoggerFactory.getLogger(CompositeComponentController.class);

	//	@Future
	private Date expiry;

	public String submit() {
		Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
		flash.put("expiry", expiry);
		return "success?faces-redirect=true";
	}

	public String now() {
		log.info("Setting to current date.");
		expiry = new Date();
		return null;
	}

	public Date getExpiry() {
		return expiry;
	}

	public void setExpiry(Date expiry) {
		this.expiry = expiry;
	}

}
