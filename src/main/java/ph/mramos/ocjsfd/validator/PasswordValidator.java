package ph.mramos.ocjsfd.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@FacesValidator(value= "passwordValidator")
public class PasswordValidator implements Validator {

	private static final Logger log = LoggerFactory.getLogger(PasswordValidator.class);

	public PasswordValidator() {
		super();
		log.info("Constructor: PasswordValidator");
	}

	@Override
	public void validate(FacesContext fc, UIComponent component, Object value) throws ValidatorException {
		if (value == null) {
			log.info("Password Validator: null");
			throw new ValidatorException(new FacesMessage("Password Required"));
		}

		if ("".equals(value.toString())) {
			log.info("Password Validator: empty");
			throw new ValidatorException(new FacesMessage("Password Required"));
		}

		if ("exv".equals(value.toString())) {
			log.info("Password Validator: " + value);
			throw new ValidatorException(new FacesMessage("Password Invalid"));
		}

		log.info("Password Validator: " + value);
	}

}
