package ph.mramos.ocjsfd.listener;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LifeCycleListener implements PhaseListener {

	private static final long serialVersionUID = -2404582612023220974L;
	private static final Logger log = LoggerFactory.getLogger(LifeCycleListener.class);



	public LifeCycleListener() {
		super();
		log.info("Constructor: LifeCycleListener");
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.ANY_PHASE;
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
