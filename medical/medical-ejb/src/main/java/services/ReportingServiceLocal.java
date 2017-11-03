package services;

import java.util.List;

import javax.ejb.Local;

import persistence.Room;

@Local
public interface ReportingServiceLocal {
	int findOccupiedRooms();
	List<Room> findRoomsBySupervisor(int id);
}
