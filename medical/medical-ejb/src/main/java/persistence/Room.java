package persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 * Entity implementation class for Entity: Room
 *
 */
@Entity

public class Room implements Serializable {

	@Id
	private int id;
	private int capacity;
	private int number;

	@OneToOne(mappedBy = "patientsRoom")
	private User patient;

	@ManyToOne
	private User superviser;

	@ManyToMany(mappedBy = "visitedRooms")
	private List<User> visitedDoctors;
	private static final long serialVersionUID = 1L;

	public Room() {
		super();
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCapacity() {
		return this.capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getNumber() {
		return this.number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public User getPatient() {
		return patient;
	}

	public void setPatient(User patient) {
		this.patient = patient;
	}

	public User getSuperviser() {
		return superviser;
	}

	public void setSuperviser(User superviser) {
		this.superviser = superviser;
	}

	public List<User> getVisitedDoctors() {
		return visitedDoctors;
	}

	public void setVisitedDoctors(List<User> visitedDoctors) {
		this.visitedDoctors = visitedDoctors;
	}

}
