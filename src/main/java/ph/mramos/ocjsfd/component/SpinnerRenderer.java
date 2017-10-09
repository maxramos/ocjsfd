package ph.mramos.ocjsfd.component;

import java.io.IOException;
import java.util.Map;

import javax.faces.component.EditableValueHolder;
import javax.faces.component.UIComponent;
import javax.faces.component.ValueHolder;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.FacesRenderer;
import javax.faces.render.Renderer;

@FacesRenderer(componentFamily = "ph.mramos.ocjsfd.component", rendererType = "ph.mramos.ocjsfd.component.SpinnerRenderer")
public class SpinnerRenderer extends Renderer {

	@Override
	public void encodeBegin(FacesContext fc, UIComponent component) throws IOException {
		ResponseWriter writer = fc.getResponseWriter();
		String clientId = component.getClientId(fc);

		// input field
		writer.startElement("input", component);
		writer.writeAttribute("name", clientId, null);
		Object value = ((ValueHolder) component).getValue();
		if (value != null) {
			writer.writeAttribute("value", value, "value");
		}
		Object size = component.getAttributes().get("size");
		if (size != null) {
			writer.writeAttribute("size", size, "size");
		}
		writer.endElement("input");

		// decrement button
		writer.startElement("input", component);
		writer.writeAttribute("type", "submit", null);
		writer.writeAttribute("name", clientId + ".less", null);
		writer.writeAttribute("value", "<", "value");
		writer.endElement("input");

		// increment button
		writer.startElement("input", component);
		writer.writeAttribute("type", "submit", null);
		writer.writeAttribute("name", clientId + ".more", null);
		writer.writeAttribute("value", ">", "value");
		writer.endElement("input");
	}

	@Override
	public void decode(FacesContext fc, UIComponent component) {
		Map<String, String> requesParamtMap = fc.getExternalContext().getRequestParameterMap();
		String clientId = component.getClientId(fc);

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
			int newValue = getIncrementedValue(submittedValue, increment, component);
			((EditableValueHolder) component).setSubmittedValue("" + newValue);
		} catch (NumberFormatException e) {
			((EditableValueHolder) component).setSubmittedValue(requesParamtMap.get(clientId));
		}
	}

//	@Override
//	public Object getConvertedValue(FacesContext fc, UIComponent component, Object submittedValue) throws ConverterException {
//		if (submittedValue instanceof String) {
//			Converter converter = ((ValueHolder) component).getConverter();
//
//			if (converter != null) {
//				return converter.getAsObject(fc, component, (String) submittedValue);
//			}
//		}
//
//		return submittedValue;
//	}

	private static int getIncrementedValue(int submittedValue, int increment, UIComponent component) {
		Integer minimum = toInteger(component.getAttributes().get("minimum"));
		Integer maximum = toInteger(component.getAttributes().get("maximum"));
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
