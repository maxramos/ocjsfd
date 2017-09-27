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
		if ("".equals(value)) {
			return new User();
		}
		
		String[] vals = value.split(",");
		
		if (vals.length == 5) {
			Integer age;
			Double salary;
			
			try {
				age = Integer.parseInt(vals[2]);
			} catch (NumberFormatException e) {
				age = null;
			}
			
			try {
				salary = Double.parseDouble(vals[3]);
			} catch (NumberFormatException e) {
				salary = null;
			}
		
			return new User(vals[0],vals[1],age, salary,vals[4]);
		}
		
		return new User(value);
	}

	@Override
	public String getAsString(FacesContext fc, UIComponent component, Object value) {
		User user = (User) value;
		return String.format("%s,%s,%s,%s,%s", user.getUsername(), user.getName(), user.getAge(), user.getSalary(), user.getIpAddress());
	}

}
