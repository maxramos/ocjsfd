package ph.mramos.ocjsfd.controller;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Named
@RequestScoped
public class SecurityController {

	private String username;
	private String password;

	public String authenticate() {
		FacesContext fc = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) fc.getExternalContext().getRequest();

		try {
			request.login(username, password);

			if (request.isUserInRole("user")) {
				return "/security/protected/form?faces-redirect=true";
			} else if (request.isUserInRole("admin")) {
				return "/security/protected/admin/form?faces-redirect=true";
			}

			return "/security/form?faces-redirect=true";
		} catch (ServletException e) {
			return "/security/error";
		}
	}

	public String logout() throws ServletException {
		FacesContext fc = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) fc.getExternalContext().getRequest();
		HttpSession session = (HttpSession) fc.getExternalContext().getSession(true);
		request.logout();
		session.invalidate();
		return "/security/form?faces-redirect=true";
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
