package gui;

import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import persistence.Room;
import persistence.Supervisor;
import services.AssignmentServiceRemote;
import services.BasicOpsRemote;

public class TestAddRoomWithSupervisor  {
	public static void main(String[] args) throws NamingException {
	Context context = new InitialContext();
	BasicOpsRemote basicOpsRemote = (BasicOpsRemote) context
			.lookup("medical-ear/medical-ejb/BasicOps!services.BasicOpsRemote");
	AssignmentServiceRemote assignmentServiceRemote = (AssignmentServiceRemote) context
			.lookup("medical-ear/medical-ejb/AssignmentService!services.AssignmentServiceRemote");

	
	Room room =new Room(100, 100);
	Supervisor supervisor= new Supervisor("jean", "chef depart");
	room.setSuperviser(supervisor);
	basicOpsRemote.updateRoom(room);
	
	}

	
}
