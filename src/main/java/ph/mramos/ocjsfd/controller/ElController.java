package ph.mramos.ocjsfd.controller;

import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIViewRoot;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.inject.Named;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Named
@RequestScoped
public class ElController {

	public String submit() {
		FacesContext fc = FacesContext.getCurrentInstance();
		ExternalContext ec = fc.getExternalContext();
		UIViewRoot view = fc.getViewRoot();
		
		Flash flash = ec.getFlash();
		flash.put("flashKey", "Flash scoped value");
		
		HttpServletRequest request = (HttpServletRequest) ec.getRequest();
		request.setAttribute("requestKey", "Request scoped value");
		
		view.getViewMap().put("viewKey", "View scoped value");
		
		HttpSession session = (HttpSession) ec.getSession(true);
		session.setAttribute("sessionKey", "Session scoped value");
		
		ServletContext application = (ServletContext) ec.getContext();
		application.setAttribute("applicationKey", "Application scoped value");
		
		return "forward";
	}
	
}
