package gui;

import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import persistence.Room;
import persistence.User;
import services.AssignmentServiceRemote;
import services.BasicOpsRemote;

public class TestAssignSupperviserToRoom {
	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		BasicOpsRemote basicOpsRemote = (BasicOpsRemote) context
				.lookup("medical-ear/medical-ejb/BasicOps!services.BasicOpsRemote");
		AssignmentServiceRemote assignmentServiceRemote = (AssignmentServiceRemote) context
				.lookup("medical-ear/medical-ejb/AssignmentService!services.AssignmentServiceRemote");

		
		Room room = basicOpsRemote.findRoomById(1);
		Room room2 = basicOpsRemote.findRoomById(2);

		List<Room> rooms = new ArrayList<>();
		rooms.add(room);
		rooms.add(room2);

		User superviser = basicOpsRemote.findUserById(5);
		assignmentServiceRemote.assignRoomsToSupervisor(rooms, superviser);
}
}
