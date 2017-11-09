package ctr;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import persistence.Room;
import persistence.Supervisor;
import services.AssignmentServiceLocal;
import services.BasicOpsLocal;

@ManagedBean
@ViewScoped
public class RoomManagementBean {

		@EJB
	private BasicOpsLocal basicOpsLocal;
		@EJB
	private AssignmentServiceLocal  assignmentServiceLocal;

		private String nameSelected=null;
	private Supervisor supervisorSelected = new Supervisor();
	private Boolean formVisibility = false;
	private Boolean buttonStatus = false;
	private Room roomSelected = new Room();
	@ManagedProperty(value = "#{identity}")
	private Identity identity;


	public void doAddRoom(){
		basicOpsLocal.addRoom(roomSelected);
		formVisibility = false;
	}
	public void doUpdateRoom() {
		basicOpsLocal.updateRoom(roomSelected);
		formVisibility = false;
	}
	public void doAssignSuervisorToRoom() {
		System.out.println("********");
		supervisorSelected=basicOpsLocal.findSupervisorByName(nameSelected);
		
		assignmentServiceLocal.assignSupervisorToRoom(supervisorSelected, roomSelected);
		
		System.out.println("********");formVisibility = false;
		roomSelected = new Room();
	}


	public void changeVisibility() {
		formVisibility = true;
	}
	

	
	public Boolean getFormVisibility() {
		return formVisibility;
	}

	public void setFormVisibility(Boolean formVisibility) {
		this.formVisibility = formVisibility;
	}

	
	public Boolean getButtonStatus() {
		return buttonStatus;
	}
	public void setButtonStatus(Boolean buttonStatus) {
		this.buttonStatus = buttonStatus;
	}
	public Room getRoomSelected() {
		return roomSelected;
	}
	public void setRoomSelected(Room roomSelected) {
		this.roomSelected = roomSelected;
	}
	public Identity getIdentity() {
		return identity;
	}

	public void setIdentity(Identity identity) {
		this.identity = identity;
	}
	public Supervisor getSupervisorSelected() {
		return supervisorSelected;
	}
	public void setSupervisorSelected(Supervisor supervisorSelected) {
		this.supervisorSelected = supervisorSelected;
	}
	public String getNameSelected() {
		return nameSelected;
	}
	public void setNameSelected(String nameSelected) {
		this.nameSelected = nameSelected;
	}

	

}
