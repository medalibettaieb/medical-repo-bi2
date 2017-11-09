package ctr;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import persistence.User;
import services.BasicOpsLocal;
import services.BasicOpsRemote;
@ManagedBean
@ViewScoped
public class UserManagementBean {
	private User user;
	@EJB
	private BasicOpsLocal basicOpsLocal;

	public String doAddUser() {
		basicOpsLocal.addUser(user);
		return "/login?faces-redirect=true";
	}

	@PostConstruct
	private void init() {
		user = new User();
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	

}
