package ph.mramos.ocjsfd.component;

import java.io.IOException;
import java.util.Map;

import javax.faces.component.FacesComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.convert.IntegerConverter;

@FacesComponent("ph.mramos.ocjsfd.Spinner")
public class UISpinner extends UIInput {

	public UISpinner() {
		setConverter(new IntegerConverter());
		setRendererType(null);
	}
	
	@Override
	public void encodeBegin(FacesContext fc) throws IOException {
		ResponseWriter writer = fc.getResponseWriter();
		String clientId = getClientId(fc);
		
		// input field
		writer.startElement("input", this);
		writer.writeAttribute("name", clientId, null);
		Object value = getValue();
		if (value != null) {
			writer.writeAttribute("value", value, "value");
		}
		Object size = getAttributes().get("size");
		if (size != null) {
			writer.writeAttribute("size", size, "size");
		}
		writer.endElement("input");
		
		// decrement button
		writer.startElement("input", this);
		writer.writeAttribute("type", "submit", null);
		writer.writeAttribute("name", clientId + ".less", null);
		writer.writeAttribute("value", "<", "value");
		writer.endElement("input");
		
		// increment button
		writer.startElement("input", this);
		writer.writeAttribute("type", "submit", null);
		writer.writeAttribute("name", clientId + ".more", null);
		writer.writeAttribute("value", ">", "value");
		writer.endElement("input");
	}
	
	@Override
	public void decode(FacesContext fc) {
		Map<String, String> requesParamtMap = fc.getExternalContext().getRequestParameterMap();
		String clientId = getClientId(fc);
		
		int increment;
		
		if (requesParamtMap.containsKey(clientId + ".more")) {
			increment = 1;
		} else if (requesParamtMap.containsKey(clientId + ".less")) {
			increment = -1;
		} else {
			increment = 0;
		}
		
		try {
			int submittedValue = Integer.parseInt(requesParamtMap.get(clientId));
			int newValue = getIncrementedValue(submittedValue, increment);
			setSubmittedValue("" + newValue);
		} catch (NumberFormatException e) {
			setSubmittedValue(requesParamtMap.get(clientId));
		}
	}
	
	private int getIncrementedValue(int submittedValue, int increment) {
		Integer minimum = toInteger(getAttributes().get("minimum"));
		Integer maximum = toInteger(getAttributes().get("maximum"));
		int newValue = submittedValue + increment;
		
		if ((minimum == null || newValue >= minimum) && (maximum == null || newValue <= maximum)) {
			return newValue;
		} else {
			return submittedValue;
		}
	}
	
	private static Integer toInteger(Object value) {
		if (value == null) {
			return null;
		}
		
		if (value instanceof Number) {
			return ((Number) value).intValue();
		}
		
		if (value instanceof String) {
			return Integer.parseInt((String) value);
		}
		
		throw new IllegalArgumentException("Cannot convert " + value);
	}
}
