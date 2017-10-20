package services;

import java.util.List;

import javax.ejb.Remote;

import persistence.User;

@Remote
public interface BasicOpsRemote {
	void addUser(User user);

	void updateUser(User user);

	void deleteUser(User user);

	void deleteUserBiId(int id);

	List<User> findAllUsers();
}
