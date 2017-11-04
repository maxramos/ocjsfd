package ph.mramos.ocjsfd.controller;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.validator.ValidatorException;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ph.mramos.ocjsfd.model.Input;

@Named
@RequestScoped
public class LifeCycleRequestScopedController implements Serializable {

	private static final long serialVersionUID = 2362133227979078979L;
	private static final Logger log = LoggerFactory.getLogger(LifeCycleRequestScopedController.class);

	private Input input1;
	private Input input2;
	private String submitVal;

	public LifeCycleRequestScopedController() {
		super();
		log.info("constructor: LifeCycleRequestScopedController()");
	}

	public String submit() {
		log.info("method: submit()");
		return null;
	}

	public void submitActionListener(ActionEvent event) {
		log.info("method: submitActionListener(): " + event.getComponent().getClientId());
	}

	public void input1ValueChangeListener(ValueChangeEvent event) {
		log.info("method: input1ValueChangeListener(): old: " + event.getOldValue() + " new: " + event.getNewValue());
	}

	public void input2ValueChangeListener(ValueChangeEvent event) {
		log.info("method: input2ValueChangeListener(): old: " + event.getOldValue() + " new: " + event.getNewValue());
	}

	public void validateInput(FacesContext fc, UIComponent component, Object value) {
		log.info("method: validateInput(): " + value);

		if ("failvalmethod".equals(((Input) value).getValue())) {
			log.info("method: Invalid input: " + value);
			throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Summary method: Invalid input: " + value, "Detail method: Invalid input: " + value));
		}
	}

	public Input getInput1() {
		log.info("method: getInput1(): " + input1);
		return input1;
	}

	public void setInput1(Input input1) {
		log.info("method: setInput1()");
		this.input1 = input1;
	}

	public Input getInput2() {
		log.info("method: getInput2(): " + input2);
		return input2;
	}

	public void setInput2(Input input2) {
		log.info("method: setInput2()");
		this.input2 = input2;
	}

	public void setSubmitVal(String submitVal) {
		log.info("method: setSubmitVal(): " + submitVal);
		this.submitVal = submitVal;
	}

}
