package persistence;

import java.io.Serializable;

import javax.persistence.Entity;

/**
 * Entity implementation class for Entity: Supervisor
 *
 */
@Entity

public class Supervisor extends User implements Serializable {

	private String level;
	private static final long serialVersionUID = 1L;

	public Supervisor() {
		super();
	}

	public Supervisor(String name, String level) {
		super(name);
		this.level = level;
	}

	public String getLevel() {
		return this.level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

}
