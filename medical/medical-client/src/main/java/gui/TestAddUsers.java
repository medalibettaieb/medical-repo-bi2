package gui;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import persistence.Doctor;
import persistence.Gender;
import persistence.Patient;
import persistence.Supervisor;
import services.BasicOpsRemote;

public class TestAddUsers {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		BasicOpsRemote basicOpsRemote = (BasicOpsRemote) context
				.lookup("medical-ear/medical-ejb/BasicOps!services.BasicOpsRemote");

		Patient patient = new Patient("ali", Gender.MALE);
		Patient patient2 = new Patient("salma", Gender.FEMALE);
		Patient patient3 = new Patient("rami", Gender.MALE);

		Doctor doctor = new Doctor("mohamed", "general");
		Doctor doctor2 = new Doctor("laila", "genico");

		Supervisor supervisor = new Supervisor("hassen", "pro");

		basicOpsRemote.addUser(supervisor);
		basicOpsRemote.addUser(doctor);
		basicOpsRemote.addUser(doctor2);
		basicOpsRemote.addUser(patient);
		basicOpsRemote.addUser(patient2);
		basicOpsRemote.addUser(patient3);

	}

}
