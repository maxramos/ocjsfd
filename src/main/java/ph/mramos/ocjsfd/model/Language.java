package ph.mramos.ocjsfd.model;

import java.io.Serializable;

public class Language implements Serializable {

	private static final long serialVersionUID = -8719908690063482995L;

	private String key;
	private String value;

	public Language() {
		super();
	}

	public Language(String key, String value) {
		this.key = key;
		this.value = value;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
