package services;

import java.util.List;

import javax.ejb.Remote;

import persistence.Room;
import persistence.User;

@Remote
public interface BasicOpsRemote {
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
}
