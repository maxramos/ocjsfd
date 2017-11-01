package ph.mramos.ocjsfd.controller;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.validator.ValidatorException;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Named
@ViewScoped
public class AjaxController implements Serializable {

	private static final long serialVersionUID = -7525787917429604785L;
	private static final Logger log = LoggerFactory.getLogger(AjaxController.class);

	private String item;
	private String message;

	public void onMenuChange(AjaxBehaviorEvent event) {
		log.info("Menu Change");
	}

	public void validateMessage(FacesContext fc, UIComponent component, Object value) {
		if ("exc".equals(value)) {
			throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid Message.", "Invalid Message."));
		}

		if ("fail".equals(value)) {
			throw new RuntimeException("Error occured when processing message.");
		}
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
