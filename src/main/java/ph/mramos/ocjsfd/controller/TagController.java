package ph.mramos.ocjsfd.controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class TagController {

	private String creditCard = "1234 1234 1234 1234";

	public String getCreditCard() {
		return creditCard;
	}
	
}
