package ph.mramos.ocjsfd.listener;

import javax.faces.component.UIViewRoot;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.SystemEvent;
import javax.faces.event.SystemEventListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PostContructViewMapListener implements SystemEventListener {

	private static final Logger log = LoggerFactory.getLogger(PostContructViewMapListener.class);

	@Override
	public void processEvent(SystemEvent event) throws AbortProcessingException {
		log.info("View Post Construct");
	}

	@Override
	public boolean isListenerForSource(Object source) {
		if (source instanceof UIViewRoot) {
			log.info("is a ViewRoot");
			return true;
		}

		log.info("is not a ViewRoot");
		return false;
	}

}
