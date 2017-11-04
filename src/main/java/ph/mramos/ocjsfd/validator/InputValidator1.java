package ph.mramos.ocjsfd.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ph.mramos.ocjsfd.model.Input;

@FacesValidator("inputValidator1")
public class InputValidator1 implements Validator {

	private static final Logger log = LoggerFactory.getLogger(InputValidator1.class);

	public InputValidator1() {
		super();
		log.info("constructor: InputValidator1()");
	}

	@Override
	public void validate(FacesContext fc, UIComponent component, Object value) throws ValidatorException {
		log.info("method: validate(): " + value);

		if ("failvalmethod".equals(((Input) value).getValue())) {
			log.info("class1: Invalid input: " + value);
			throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Summary class1: Invalid input: " + value, "Detail class1: Invalid input: " + value));
		}

	}

}
