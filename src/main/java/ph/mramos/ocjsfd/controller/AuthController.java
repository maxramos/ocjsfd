package ph.mramos.ocjsfd.controller;

import javax.enterprise.context.RequestScoped;
import javax.faces.component.html.HtmlInputSecret;
import javax.faces.component.html.HtmlInputText;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Named
@RequestScoped
public class AuthController {

	private static final Logger log = LoggerFactory.getLogger(AuthController.class);

	private String username;
	private String password;
	private HtmlInputText inputText;
	private HtmlInputSecret inputSecret;

	public AuthController() {
		super();
		log.info("Constructor: AuthController");
	}

	public String authenticate() {
		log.info("Authenticate: " + username + ": " + password);
		return null;
	}

	public String forgotPassword() {
		log.info("Forgot Password: " + inputText.getValue() + ":" + inputSecret.getSubmittedValue());
		return null;
	}

	public void onUsernameChanged(ValueChangeEvent event) {
		log.info("Username Change Event: Old Value: " + event.getOldValue() + ", New Value: " + event.getNewValue());
	}

	public void onPasswordChanged(ValueChangeEvent event) {
		log.info("Password Change Event: Old Value: " + event.getOldValue() + ", New Value: " + event.getNewValue());
	}

	public String getUsername() {
		log.info("getUsername: " + username);
		return username;
	}

	public void setUsername(String username) {
		log.info("setUsername: " + username);
		this.username = username;
	}

	public String getPassword() {
		log.info("getPassword: " + password);
		return password;
	}

	public void setPassword(String password) {
		log.info("setPassword: " + password);
		this.password = password;
	}

	public HtmlInputText getInputText() {
		log.info("getInputText: " + inputText);
		return inputText;
	}

	public void setInputText(HtmlInputText inputText) {
		log.info("setInputText: " + inputText);
		this.inputText = inputText;
	}

	public HtmlInputSecret getInputSecret() {
		log.info("getInputSecret: " + inputSecret);
		return inputSecret;
	}

	public void setInputSecret(HtmlInputSecret inputSecret) {
		log.info("setInputSecret: " + inputSecret);
		this.inputSecret = inputSecret;
	}

}
