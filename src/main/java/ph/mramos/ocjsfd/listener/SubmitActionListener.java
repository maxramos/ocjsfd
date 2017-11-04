package ph.mramos.ocjsfd.listener;

import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SubmitActionListener implements ActionListener {

	private static final Logger log = LoggerFactory.getLogger(SubmitActionListener.class);

	public SubmitActionListener() {
		super();
		log.info("constructor: SubmitActionListener()");
	}

	@Override
	public void processAction(ActionEvent event) throws AbortProcessingException {
		log.info("method: processAction(): " + event.getComponent().getClientId());
	}

}
