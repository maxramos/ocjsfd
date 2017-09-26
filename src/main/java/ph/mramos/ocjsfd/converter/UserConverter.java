package ph.mramos.ocjsfd.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import ph.mramos.ocjsfd.model.User;

@FacesConverter("userConverter")
public class UserConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext fc, UIComponent component, String value) {
		return new User(value);
	}

	@Override
	public String getAsString(FacesContext fc, UIComponent component, Object value) {
		return ((User) value).getUsername();
	}

}
