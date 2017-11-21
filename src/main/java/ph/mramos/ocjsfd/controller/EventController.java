package ph.mramos.ocjsfd.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ComponentSystemEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ph.mramos.ocjsfd.model.Country;
import ph.mramos.ocjsfd.model.Language;

@Named
@ViewScoped
public class EventController implements Serializable {

	private static final long serialVersionUID = 3227165246571611158L;
	private static final Logger log = LoggerFactory.getLogger(EventController.class);

	// Map<String, String> countries;
	List<Country> countries;
	String country;
	// Map<String, String> languages;
	List<Language> languages;
	String language;
	String lang;

	@PostConstruct
	void init() {
		// Note: when map is used as a value for f:selectItems then itemLabel and itemValue are disregarded.
		// countries = new LinkedHashMap<>();
		// countries.put("USA", "United States");
		// countries.put("FRA", "France");
		// countries.put("ESP", "Spain");
		//
		// languages = new LinkedHashMap<>();
		// languages.put("en", "English");
		// languages.put("fr", "French");
		// languages.put("es", "Spanish");

		countries = new ArrayList<>();
		countries.add(new Country("USA", "United States"));
		countries.add(new Country("FRA", "France"));
		countries.add(new Country("ESP", "Spain"));

		languages = new ArrayList<>();
		languages.add(new Language("en", "English"));
		languages.add(new Language("fr", "French"));
		languages.add(new Language("es", "Spanish"));
	}

	public void submit() {
		log.info("Country: " + country);
		log.info("Language: " + language);
		log.info("Lang: " + lang);

		Map<String, String> requestMap = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		Map<String, Object> attributeMap = FacesContext.getCurrentInstance().getExternalContext().getRequestMap();
		log.info("Request Map: " + requestMap);
		log.info("Attribute Map: " + attributeMap);
	}

	public void submit(String _country) {
		log.info("Country: " + country);
		log.info("Language: " + language);
		log.info("_Country: " + _country);
	}

	public void onCountryChange(ValueChangeEvent event) {
		log.info("Phase ID: " + event.getPhaseId());
		log.info("Old Country: " + event.getOldValue());
		log.info("New Country: " + event.getNewValue());
		FacesContext.getCurrentInstance().renderResponse();
	}

	public void onSubmit(ActionEvent event) {
		log.info("On Submit (attribute)" + event.getPhaseId());

		Map<String, String> requestMap = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		Map<String, Object> attributeMap = FacesContext.getCurrentInstance().getExternalContext().getRequestMap();
		log.info("Request Map: " + requestMap);
		log.info("Attribute Map: " + attributeMap);
		log.info("Component Attribute (attrKey): " + event.getComponent().getAttributes().get("attrKey"));
	}

	public void onBeforePhase(PhaseEvent event) {
		log.info("View Before Phase: " + event.getPhaseId());
	}

	public void onAfterPhase(PhaseEvent event) {
		log.info("View After Phase: " + event.getPhaseId());
	}

	public void onPostAddToView(ComponentSystemEvent event) {
		log.info("Post Add To View");
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	// public Map<String, String> getCountries() {
	// return countries;
	// }

	// public Map<String, String> getLanguages() {
	// return languages;
	// }

	public List<Country> getCountries() {
		return countries;
	}

	public List<Language> getLanguages() {
		return languages;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

}
