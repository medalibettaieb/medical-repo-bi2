package persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 * Entity implementation class for Entity: User
 *
 */
@Entity

public class User implements Serializable {

	@Id
	private int id;
	private String name;

	@OneToOne
	private Room patientsRoom;

	@OneToMany(mappedBy = "superviser")
	private List<Room> supervisedRooms;

	@ManyToMany
	private List<Room> visitedRooms;
	private static final long serialVersionUID = 1L;

	public User() {
		super();
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Room getPatientsRoom() {
		return patientsRoom;
	}

	public void setPatientsRoom(Room patientsRoom) {
		this.patientsRoom = patientsRoom;
	}

	public List<Room> getSupervisedRooms() {
		return supervisedRooms;
	}

	public void setSupervisedRooms(List<Room> supervisedRooms) {
		this.supervisedRooms = supervisedRooms;
	}

	public List<Room> getVisitedRooms() {
		return visitedRooms;
	}

	public void setVisitedRooms(List<Room> visitedRooms) {
		this.visitedRooms = visitedRooms;
	}

}
