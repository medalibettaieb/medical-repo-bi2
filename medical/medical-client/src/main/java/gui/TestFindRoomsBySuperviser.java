package gui;

import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import persistence.Room;
import persistence.Supervisor;
import persistence.User;
import services.AssignmentServiceRemote;
import services.BasicOpsRemote;

public class TestFindRoomsBySuperviser {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		BasicOpsRemote basicOpsRemote = (BasicOpsRemote) context
				.lookup("medical-ear/medical-ejb/BasicOps!services.BasicOpsRemote");
		AssignmentServiceRemote assignmentServiceRemote = (AssignmentServiceRemote) context
				.lookup("medical-ear/medical-ejb/AssignmentService!services.AssignmentServiceRemote");

		Supervisor supervisor = (Supervisor) basicOpsRemote.findUserById(5);
		List<Room> rooms= new ArrayList<Room>();
		rooms=supervisor.getSupervisedRooms();
		for (int i = 0; i < rooms.size(); i++) {
			System.out.println(rooms.get(i).getNumber());
		}

	}

}
