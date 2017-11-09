package ctr;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import persistence.Patient;
import persistence.Supervisor;
import persistence.User;
import services.BasicOpsLocal;

@ManagedBean
@SessionScoped
public class Identity {
	@EJB
	private BasicOpsLocal basicOpsLocal;
	private Boolean loggedInAsAgent = false;
	private User user = new User();
	private boolean isLogged = false;

	public String logout() {
		isLogged = false;
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/login?faces-redirect=true";
	}
	public String doLogin() {
		String navigateTo = "";
		User userLoggedIn = basicOpsLocal.authentification(user.getUsername(), user.getPwd());
		if (userLoggedIn != null) {
			isLogged = true;
			user = userLoggedIn;
			if (userLoggedIn instanceof Patient) {
				navigateTo = "/pages/patient/patient?faces-redirect=true";
			} else if (userLoggedIn instanceof Supervisor) {
				navigateTo = "/pages/supervisor/supervisor?faces-redirect=true";
			} else {
				loggedInAsAgent = true;
				navigateTo = "/pages/agent/manageRooms?faces-redirect=true";
			
				}
		} else {
			loggedInAsAgent = false;
			navigateTo = "erreur?faces-redirect=true";
		
			System.err.println("not");
		}
		return navigateTo;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Boolean getLoggedInAsAgent() {
		return loggedInAsAgent;
	}

	public void setLoggedInAsAgent(Boolean loggedInAsAgent) {
		this.loggedInAsAgent = loggedInAsAgent;
	}

	public boolean isLogged() {
		return isLogged;
	}

	public void setLogged(boolean isLogged) {
		this.isLogged = isLogged;
	}
}
