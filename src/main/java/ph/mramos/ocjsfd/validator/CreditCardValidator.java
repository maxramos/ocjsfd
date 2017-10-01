package ph.mramos.ocjsfd.validator;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("creditCardValidator")
public class CreditCardValidator implements Validator, Serializable {

	private static final long serialVersionUID = 7386772821830966027L;

	private String errorSummary;
	private String errorDetail;
	
	@Override
	public void validate(FacesContext fc, UIComponent component, Object value) {
		if (!"1234123412341234".equals(value)) {
			throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, errorSummary, errorDetail));
		}
	}

	public void setErrorSummary(String errorSummary) {
		this.errorSummary = errorSummary;
	}

	public void setErrorDetail(String errorDetail) {
		this.errorDetail = errorDetail;
	}

}
