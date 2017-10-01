package ph.mramos.ocjsfd.converter;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

@FacesConverter("creditCardConverter")
public class CreditCardConverter implements Converter, Serializable {

	private static final long serialVersionUID = -4266835058096241204L;
	
	private String separator;
	
	@Override
	public Object getAsObject(FacesContext fc, UIComponent component, String value) {
		Pattern pattern = Pattern.compile("\\d{4}-\\d{4}-\\d{4}-\\d{4}".replaceAll("-", separator));
		Matcher matcher = pattern.matcher(value);
		
		if (value == null || "".equals(value)) {
			return "";
		}
		
		if (!matcher.matches()) {
			throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Credit Card conversion error.", 
					"Credit Card conversion error: " + value));
		}
		
		return value.replaceAll("-", "");
	}

	@Override
	public String getAsString(FacesContext fc, UIComponent component, Object value) {
		String val = (String) value;
		
		if (val == null || "".equals(val)) {
			return "";
		}
		
		String cc = String.format("%s-%s-%s-%s", val.substring(0, 4), val.substring(4, 8), val.substring(8, 12), val.substring(12, 16));
		return cc.replaceAll("-", separator);
	}
	
	public void setSeparator(String separator) {
		this.separator = separator;
	}

}
