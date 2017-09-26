package ph.mramos.ocjsfd.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("addressValidator")
public class AddressValidator implements Validator {

	@Override
	public void validate(FacesContext fc, UIComponent component, Object value) throws ValidatorException {
		if (!"makati".equals(value)) {
			throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid address.", "Invalid address: " + value));
		}
	}

}
