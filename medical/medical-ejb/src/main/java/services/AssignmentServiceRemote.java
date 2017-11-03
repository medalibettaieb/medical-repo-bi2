package services;

import java.util.List;

import javax.ejb.Remote;

import persistence.Room;
import persistence.User;

@Remote
public interface AssignmentServiceRemote {
	void assignPatientToRoom(User user, Room room);

	void assignSupervisorToRoom(User user, Room room);

	void assignDoctorToRoom(User user, Room room);

	void assignRoomsToSupervisor(List<Room> rooms, User superviser);

}
