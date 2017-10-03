package ph.mramos.ocjsfd.converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@FacesConverter(value = "usernameConverter")
public class UsernameConverter implements Converter {

	private static final Logger log = LoggerFactory.getLogger(PasswordConverter.class);

	public UsernameConverter() {
		super();
		log.info("Constructor: UsernameConverter");
	}

	@Override
	public Object getAsObject(FacesContext fc, UIComponent component, String value) {
		log.info("Username Converter: " + value);

		if ("exc".equals(value)) {
			throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Username can't be converted.", "Username can't be converted.") );
		}

		return value;
	}

	@Override
	public String getAsString(FacesContext fc, UIComponent component, Object value) {
		log.info("Username Converter: " + value);
		return (String) value;
	}

}
