package ph.mramos.ocjsfd.converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@FacesConverter(value = "passwordConverter")
public class PasswordConverter implements Converter {

	private static final Logger log = LoggerFactory.getLogger(PasswordConverter.class);

	public PasswordConverter() {
		super();
		log.info("Constructor: PasswordConverter");
	}

	@Override
	public Object getAsObject(FacesContext fc, UIComponent component, String value) {
		log.info("Password Converter: " + value);

		if ("exc".equals(value)) {
			throw new ConverterException(new FacesMessage("Password can't be converted."));
		}

		return value;
	}

	@Override
	public String getAsString(FacesContext fc, UIComponent component, Object value) {
		log.info("Password Converter: " + value);
		return (String) value;
	}

}
