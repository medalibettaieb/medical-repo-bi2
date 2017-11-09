package ctr;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import persistence.Supervisor;
import services.BasicOpsLocal;
@ManagedBean
@ViewScoped
public class SupervisorBean {
	private List<Supervisor> supervisors = new ArrayList<>();
	@EJB
	private BasicOpsLocal basicOpsLocal;

	public Supervisor doFindSupervisorByName(String name) {
		return basicOpsLocal.findSupervisorByName(name);
	}
	

	

	public List<Supervisor> getSupervisors() {
		supervisors = basicOpsLocal.findAllSupervisors();
		return supervisors;
	}

	public void setSupervisors(List<Supervisor> supervisors) {
		this.supervisors = supervisors;
	}

	
}
