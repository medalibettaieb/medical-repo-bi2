package services;

import java.util.List;

import javax.ejb.Local;

import persistence.Room;
import persistence.User;

@Local
public interface BasicOpsLocal {
	void addUser(User user);

	void updateUser(User user);

	void deleteUser(User user);

	void deleteUserById(int id);

	User findUserById(int id);

	List<User> findAllUsers();
	
	void addRoom(Room room);
	
	void updateRoom(Room room);

	void deleteRoom(Room room);
	
	Room findRoomById(int id);
	List<Room> findAllRooms();
}
