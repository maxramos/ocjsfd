package ph.mramos.ocjsfd.component;

import javax.faces.component.FacesComponent;
import javax.faces.component.UIInput;
import javax.faces.convert.IntegerConverter;

@FacesComponent("ph.mramos.ocjsfd.component.Spinner")
public class Spinner extends UIInput {

	public Spinner() {
//		setConverter(new IntegerConverter());
//		setRendererType("ph.mramos.ocjsfd.component.SpinnerRenderer");
	}

	@Override
	public String getFamily() {
		return "ph.mramos.ocjsfd.component";
	}

}
