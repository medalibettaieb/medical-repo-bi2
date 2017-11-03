package persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: Room
 *
 */
@Entity
@Table(name="T_ROOM")
public class Room implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int capacity;
	private int number;

	@OneToOne(mappedBy = "patientsRoom")
	private User patient;

	@ManyToOne(cascade=CascadeType.MERGE)
	private User superviser;

	@ManyToMany(mappedBy = "visitedRooms")
	private List	<User> visitedDoctors;
	private static final long serialVersionUID = 1L;

	public Room() {
		super();
	}

	public Room(int capacity, int number) {
		super();
		this.capacity = capacity;
		this.number = number;
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
