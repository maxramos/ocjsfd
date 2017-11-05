package ph.mramos.ocjsfd.controller;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Named
@RequestScoped
public class FlashController {

	private static final Logger log = LoggerFactory.getLogger(FlashController.class);

	private String input;

	public String submit() {
		FacesContext fc = FacesContext.getCurrentInstance();
		Flash flash = fc.getExternalContext().getFlash();
		flash.put("input", input);
		flash.put("inputkeep", input);
		fc.addMessage(null, new FacesMessage(input));

		if ("forward".equals(input)) {
			return "forward";
		} else if ("forwardkeep".equals(input)) {
			flash.setKeepMessages(true);
			return "forward";
		} else if ("redirect".equals(input)) {
			log.info("Keep Message: " + flash.isKeepMessages());
			return "redirect?faces-redirect=true";
		} else if ("redirectkeep".equals(input)) {
			flash.setKeepMessages(true);
			log.info("Keep Message: " + flash.isKeepMessages());
			return "redirect?faces-redirect=true";
		}

		return null;
	}

	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}

}
