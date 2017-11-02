package ph.mramos.ocjsfd.controller;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ExceptionQueuedEvent;
import javax.faces.event.ExceptionQueuedEventContext;
import javax.inject.Named;

@Named
@RequestScoped
public class ErrorHandlerController {

	public String errorCode() {
		throw new RuntimeException("Error 500.");
	}

	public String errorException() {
		try {
			throw new NullPointerException("Error NullPointer.");
		} catch (Exception e) {
			FacesContext fc = FacesContext.getCurrentInstance();
			ExceptionQueuedEventContext eventContext = new ExceptionQueuedEventContext(fc, e);
			eventContext.getAttributes().put("testKey", "testValue");
			fc.getApplication().publishEvent(fc, ExceptionQueuedEvent.class, eventContext);
		}

		return null;
	}

}
