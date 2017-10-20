package services;

import java.util.List;

import javax.ejb.Local;

import persistence.User;

@Local
public interface BasicOpsLocal {
	void addUser(User user);

	void updateUser(User user);

	void deleteUser(User user);

	void deleteUserBiId(int id);

	List<User> findAllUsers();
}
