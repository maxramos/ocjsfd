package ph.mramos.ocjsfd.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@FacesValidator(value= "usernameValidator")
public class UsernameValidator implements Validator {
	private static final Logger log = LoggerFactory.getLogger(UsernameValidator.class);

	public UsernameValidator() {
		super();
		log.info("Constructor: UsernameValidator");
	}

	@Override
	public void validate(FacesContext fc, UIComponent component, Object value) throws ValidatorException {
		if (value == null) {
			log.info("Username Validator: null");
			throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Username Required", "Username Required"));
		}

		if ("".equals(value.toString())) {
			log.info("Username Validator: empty");
			throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Username Required", "Username Required"));
		}

		if ("exv".equals(value.toString())) {
			log.info("Username Validator: " + value);
			throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Username Invalid", "Username Invalid"));
		}

		log.info("Username Validator: " + value);
	}
}
