package ph.mramos.ocjsfd.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ELFunctions {

	private static final Logger log = LoggerFactory.getLogger(ELFunctions.class);

	public static String getFile(String filename) {
		log.info("EL Functions: " + filename);
		return "Test File";
	}

}
