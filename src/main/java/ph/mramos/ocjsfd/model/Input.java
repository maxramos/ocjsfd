package ph.mramos.ocjsfd.model;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Input implements Serializable {

	private static final long serialVersionUID = 1129309215981778743L;
	private static final Logger log = LoggerFactory.getLogger(Input.class);

	private String value;

	public Input() {
		super();
		log.info("constructor: Input()");
	}

	public Input(String value) {
		this.value = value;
		log.info("constructor: Input(String)");
	}

	public String getValue() {
		log.info("method: getValue()");
		return value;
	}

	public void setValue(String value) {
		log.info("method: setValue()");
		this.value = value;
	}

	@Override
	public String toString() {
		return "Input [value=" + value + "]";
	}

}
