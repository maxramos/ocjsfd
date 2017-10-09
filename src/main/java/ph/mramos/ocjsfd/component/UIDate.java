package ph.mramos.ocjsfd.component;

import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoField;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.component.FacesComponent;
import javax.faces.component.NamingContainer;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.convert.ConverterException;

@FacesComponent("ph.mramos.ocjsfd.component.UIDate")
public class UIDate extends UIInput implements NamingContainer {

	@Override
	public String getFamily() {
		return "javax.faces.NamingContainer";
	}

	@Override
	public void encodeBegin(FacesContext fc) throws IOException {
		Date date = (Date) getValue();

		if (date == null) {
			super.encodeBegin(fc);
			return;
		}

		int month = date.toInstant().atZone(ZoneId.systemDefault()).get(ChronoField.MONTH_OF_YEAR);
		int day = date.toInstant().atZone(ZoneId.systemDefault()).get(ChronoField.DAY_OF_MONTH);
		int year = date.toInstant().atZone(ZoneId.systemDefault()).get(ChronoField.YEAR);

		UIInput monthComponent = (UIInput) findComponent("month");
		UIInput dayComponent = (UIInput) findComponent("day");
		UIInput yearComponent = (UIInput) findComponent("year");

		monthComponent.setValue(month);
		dayComponent.setValue(day);
		yearComponent.setValue(year);

		super.encodeBegin(fc);
	}

	@Override
	public Object getSubmittedValue() {
		return this;
	}

	@Override
	protected Object getConvertedValue(FacesContext fc, Object value) throws ConverterException {
		UIInput monthComponent = (UIInput) findComponent("month");
		UIInput dayComponent = (UIInput) findComponent("day");
		UIInput yearComponent = (UIInput) findComponent("year");

		try {
			int month = Integer.parseInt((String) monthComponent.getSubmittedValue());
			int day = Integer.parseInt((String) dayComponent.getSubmittedValue());
			int year = Integer.parseInt((String) yearComponent.getSubmittedValue());

			Date date = Date.from(LocalDate.of(year, month, day).atStartOfDay(ZoneId.systemDefault()).toInstant());
			return date;
		} catch (NumberFormatException e) {
			throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error converting date.", "Error converting date."));
		}
	}



}
