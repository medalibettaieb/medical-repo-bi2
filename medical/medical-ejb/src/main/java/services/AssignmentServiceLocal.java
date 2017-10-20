package services;

import javax.ejb.Local;

import persistence.Room;
import persistence.User;

@Local
public interface AssignmentServiceLocal {
	void assignPatientToRoom(User user, Room room);

	void assignSupervisorToRoom(User user, Room room);

	void assignDoctorToRoom(User user, Room room);
}
