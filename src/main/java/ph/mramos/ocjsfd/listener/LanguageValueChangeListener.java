package ph.mramos.ocjsfd.listener;

import javax.faces.event.AbortProcessingException;
import javax.faces.event.ValueChangeEvent;
import javax.faces.event.ValueChangeListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LanguageValueChangeListener implements ValueChangeListener {
	
	private static final Logger log = LoggerFactory.getLogger(LanguageValueChangeListener.class);

	@Override
	public void processValueChange(ValueChangeEvent event) throws AbortProcessingException {
		log.info("Phase ID: " + event.getPhaseId());
		log.info("Old Language: " + event.getOldValue());
		log.info("New Language: " + event.getNewValue());
	}

}
