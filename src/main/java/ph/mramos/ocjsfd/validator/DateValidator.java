package ph.mramos.ocjsfd.validator;

import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("dateValidator")
public class DateValidator implements Validator {

	@Override
	public void validate(FacesContext fc, UIComponent component, Object value) throws ValidatorException {
		Date date = (Date) value;

		if (date == null) {
			return;
		}

		if (date.before(new Date())) {
			throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Date should be in the future: " + value, "Date should be in the future: " + value));
		}
	}

}
