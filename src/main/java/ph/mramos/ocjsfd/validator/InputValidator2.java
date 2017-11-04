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

@FacesValidator("inputValidator2")
public class InputValidator2 implements Validator {

	private static final Logger log = LoggerFactory.getLogger(InputValidator2.class);

	public InputValidator2() {
		super();
		log.info("constructor: InputValidator2()");
	}

	@Override
	public void validate(FacesContext fc, UIComponent component, Object value) throws ValidatorException {
		log.info("method: validate(): " + value);

		if ("failvalmethod".equals(((Input) value).getValue())) {
			log.info("class2: Invalid input: " + value);
			throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Summary class2: Invalid input: " + value, "Detail class2: Invalid input: " + value));
		}
	}
}
