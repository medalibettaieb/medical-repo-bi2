package persistence;

import java.io.Serializable;
import javax.persistence.*;
import persistence.User;

/**
 * Entity implementation class for Entity: Patient
 *
 */
@Entity

public class Patient extends User implements Serializable {

	private Gender gender;
	private static final long serialVersionUID = 1L;

	public Patient() {
		super();
	}

	public Patient(String name, Gender gender) {
		super(name);
		this.gender = gender;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}
   
}
