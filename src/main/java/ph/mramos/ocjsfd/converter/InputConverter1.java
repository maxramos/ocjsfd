package ph.mramos.ocjsfd.converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ph.mramos.ocjsfd.model.Input;

@FacesConverter("inputConverter1")
public class InputConverter1 implements Converter {

	private static final Logger log = LoggerFactory.getLogger(InputConverter1.class);

	public InputConverter1() {
		super();
		log.info("constructor: InputConverter1()");
	}

	@Override
	public Object getAsObject(FacesContext fc, UIComponent component, String value) {
		log.info("method: getAsObject(): " + value);

		if ("failcon".equals(value)) {
			throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Summary1: Can't convert input: " + value, "Detail1: Can't convert input: " + value));
		}

		return new Input(value);
	}

	@Override
	public String getAsString(FacesContext fc, UIComponent component, Object obj) {
		Input input = (Input) obj;
		String value = input.getValue();
		log.info("method: getAsString(): " + value);
		return value;
	}

}
