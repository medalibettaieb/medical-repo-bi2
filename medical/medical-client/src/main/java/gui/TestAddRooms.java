package gui;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import persistence.Room;
import services.BasicOpsRemote;

public class TestAddRooms {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		BasicOpsRemote basicOpsRemote = (BasicOpsRemote) context
				.lookup("medical-ear/medical-ejb/BasicOps!services.BasicOpsRemote");

		Room room = new Room(2, 60);
		Room room2 = new Room(1, 90);
		Room room3 = new Room(2, 20);
		Room room4 = new Room(1, 40);

		basicOpsRemote.addRoom(room);
		basicOpsRemote.addRoom(room2);
		basicOpsRemote.addRoom(room3);
		basicOpsRemote.addRoom(room4);

	}

}
