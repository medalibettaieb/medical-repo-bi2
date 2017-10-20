package gui;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import persistence.Room;
import persistence.User;
import services.AssignmentServiceRemote;
import services.BasicOpsRemote;

public class TestAssignPatientToRoom {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		BasicOpsRemote basicOpsRemote = (BasicOpsRemote) context
				.lookup("medical-ear/medical-ejb/BasicOps!services.BasicOpsRemote");
		AssignmentServiceRemote assignmentServiceRemote = (AssignmentServiceRemote) context
				.lookup("medical-ear/medical-ejb/AssignmentService!services.AssignmentServiceRemote");

		User user = basicOpsRemote.findUserById(4);
		Room room = basicOpsRemote.findRoomById(1);

		assignmentServiceRemote.assignPatientToRoom(user, room);
		
		User user2=basicOpsRemote.findUserById(5);
		Room room2=basicOpsRemote.findRoomById(2);
		assignmentServiceRemote.assignPatientToRoom(user2, room2);
		
		User user3=basicOpsRemote.findUserById(6);;
		Room room3=basicOpsRemote.findRoomById(3);;
		assignmentServiceRemote.assignPatientToRoom(user3, room3);

	}

}
