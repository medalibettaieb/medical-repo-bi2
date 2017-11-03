package services;

import java.util.List;

import javax.ejb.Local;

import persistence.Room;
import persistence.User;

@Local
public interface AssignmentServiceLocal {
	void assignPatientToRoom(User user, Room room);

	void assignSupervisorToRoom(User user, Room room);

	void assignRoomsToSupervisor(List<Room> rooms, User superviser);
}
