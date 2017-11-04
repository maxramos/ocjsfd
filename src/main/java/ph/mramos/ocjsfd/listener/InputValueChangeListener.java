package ph.mramos.ocjsfd.listener;

import javax.faces.event.AbortProcessingException;
import javax.faces.event.ValueChangeEvent;
import javax.faces.event.ValueChangeListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InputValueChangeListener implements ValueChangeListener {

	private static final Logger log = LoggerFactory.getLogger(InputValueChangeListener.class);

	public InputValueChangeListener() {
		super();
		log.info("constructor: InputValueChangeListener()");
	}

	@Override
	public void processValueChange(ValueChangeEvent event) throws AbortProcessingException {
		log.info("method: processValueChange(): old: " + event.getOldValue() + " new: " + event.getNewValue());
	}

}
