package ph.mramos.ocjsfd.controller;

import java.io.Serializable;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Named
@ViewScoped
public class LocaleController implements Serializable {

	private static final long serialVersionUID = 1417603097444088600L;
	private static final Logger log = LoggerFactory.getLogger(LocaleController.class);
	private List<String> localeCodes;
	private String localeCode;

	@PostConstruct
	void init() {
		localeCodes = Stream.of("en", "fr", "es").collect(Collectors.toList());
		localeCode = localeCodes.get(0);
	}
	
	public void submit() {
	}
	
	public void selectLocale() {
		UIViewRoot viewRoot = FacesContext.getCurrentInstance().getViewRoot();
		viewRoot.setLocale(new Locale(localeCode));
	}
	
	public String getMessage() {
		FacesContext fc = FacesContext.getCurrentInstance();
//		ResourceBundle resourceBundle = fc.getApplication().getResourceBundle(fc, "ph.mramos.ocjsfd.messages");
		
		ResourceBundle resourceBundle = ResourceBundle.getBundle("ph.mramos.ocjsfd.messages", fc.getViewRoot().getLocale());
		return resourceBundle.getString("greetings");
	}

	public List<String> getLocaleCodes() {
		return localeCodes;
	}

	public String getLocaleCode() {
		return localeCode;
	}

	public void setLocaleCode(String localeCode) {
		this.localeCode = localeCode;
	}

}
