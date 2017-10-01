package ph.mramos.ocjsfd.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "ccConverter")
public class CcConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext fc, UIComponent component, String value) {
		return value;
	}

	@Override
	public String getAsString(FacesContext fc, UIComponent component, Object value) {
		String val = (String) value;
		return val.replaceAll(" ", (String) component.getAttributes().get("separator"));
	}

}
