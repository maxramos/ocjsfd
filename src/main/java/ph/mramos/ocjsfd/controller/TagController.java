package ph.mramos.ocjsfd.controller;

import java.util.Arrays;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIOutput;
import javax.faces.component.html.HtmlForm;
import javax.faces.event.ActionEvent;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Named
@RequestScoped
public class TagController {

	private static final Logger log = LoggerFactory.getLogger(TagController.class);
	
	private String creditCard = "1234 1234 1234 1234";
	private List<Integer> numbers = Arrays.asList(5, 6, 7, 8, 9);
	
	public void form2ActionListener(ActionEvent event) {
		UIOutput _out0 = (UIOutput) event.getComponent().findComponent(":out0");
		UIOutput _form1_out1 = (UIOutput) event.getComponent().findComponent(":form1:out1");
		UIOutput _form2_out1 = (UIOutput) event.getComponent().findComponent(":form2:out1");
		UIOutput form2_out1 = (UIOutput) event.getComponent().findComponent("form2:out1");
		UIOutput out2 = (UIOutput) event.getComponent().findComponent("out2");
		HtmlForm _form1 = (HtmlForm) event.getComponent().findComponent(":form1");
		HtmlForm form2 = (HtmlForm) event.getComponent().findComponent("form2");
		
		log.info(":out0 = " + _out0.getValue());
		log.info(":form1:out1 = " + _form1_out1.getValue());
		log.info(":form2:out1 = " + _form2_out1.getValue());
		log.info("form2:out1 = " + form2_out1.getValue());
		log.info("out2 = " + out2.getValue());
		log.info(":form1 = " + _form1.getLang());
		log.info("form2 = " + form2.getLang());
	}

	public String getCreditCard() {
		return creditCard;
	}
	
	public List<Integer> getNumbers() {
		return numbers;
	}
	
}
