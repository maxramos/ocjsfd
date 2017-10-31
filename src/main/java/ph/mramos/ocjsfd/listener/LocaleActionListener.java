package ph.mramos.ocjsfd.listener;

import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LocaleActionListener implements ActionListener {

	private static final Logger log = LoggerFactory.getLogger(LocaleActionListener.class);

	@Override
	public void processAction(ActionEvent event) throws AbortProcessingException {
		log.info("On Submit (tag)" + event.getPhaseId());
	}

}
