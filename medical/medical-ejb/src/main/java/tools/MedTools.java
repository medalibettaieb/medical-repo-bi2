package tools;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import persistence.Doctor;
import persistence.Gender;
import persistence.Patient;
import persistence.Room;
import persistence.Supervisor;
import services.BasicOpsLocal;

@Singleton
@LocalBean
@Startup
public class MedTools {
	@EJB
	private BasicOpsLocal basicOpsLocal;

	/**
	 * Default constructor.
	 */
	public MedTools() {
		// TODO Auto-generated constructor stub
	}

	@PostConstruct
	public void init() {
		
		Patient patient= new Patient("salah",Gender.MALE );
		Patient patient2 = new Patient("mohamed", Gender.MALE);
		Patient patient3 = new Patient("rihab",Gender.FEMALE);
		

	
		Supervisor supervisor = new Supervisor("ali", "1");
		Supervisor supervisor2 = new Supervisor("sana", "2");

		Room room = new Room(2, 1);
		Room room2 = new Room(3, 2);
		Room room3 = new Room(4, 3);
		

		basicOpsLocal.addUser(patient);
		basicOpsLocal.addUser(patient2);
		basicOpsLocal.addUser(patient3);
		
		basicOpsLocal.addUser(supervisor);
		basicOpsLocal.addUser(supervisor2);

		basicOpsLocal.updateRoom(room);
		basicOpsLocal.updateRoom(room2);
		basicOpsLocal.updateRoom(room3);

		

	}

}


