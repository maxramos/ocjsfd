package ph.mramos.ocjsfd.listener;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ApplyRequestValuesPhaseListener implements PhaseListener {

	private static final long serialVersionUID = 433848013497449418L;
	private static final Logger log = LoggerFactory.getLogger(ApplyRequestValuesPhaseListener.class);

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.APPLY_REQUEST_VALUES;
	}

	@Override
	public void beforePhase(PhaseEvent event) {
		log.info("Start Phase: " + event.getPhaseId());
	}

	@Override
	public void afterPhase(PhaseEvent event) {
		log.info("End Phase: " + event.getPhaseId());
	}

}
