package services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import persistence.Room;
import persistence.Supervisor;
import persistence.User;

/**
 * Session Bean implementation class BasicOps
 */
@Stateless
public class BasicOps implements BasicOpsRemote, BasicOpsLocal {
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public BasicOps() {
	}

	@Override
	public void addUser(User user) {
		entityManager.persist(user);
	}

	@Override
	public void updateUser(User user) {
		entityManager.merge(user);
	}

	@Override
	public void deleteUser(User user) {
		entityManager.remove(user);
	}

	@Override
	public void deleteUserById(int id) {
		entityManager.remove(findUserById(id));
	}

	@Override
	public List<User> findAllUsers() {
		String jpql = "SELECT u FROM User u";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}

	@Override
	public User findUserById(int id) {
		return entityManager.find(User.class, id);
	}

	@Override
	public void addRoom(Room room) {
		entityManager.persist(room);

	}

	@Override
	public Room findRoomById(int id) {
		return entityManager.find(Room.class, id);
	}

	@Override
	public List<Room> findAllRooms() {
		String jpql = "SELECT u FROM Room u";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}

	@Override
	public void updateRoom(Room room) {
		entityManager.merge(room);
	}

	@Override
	public void deleteRoom(Room room) {
		entityManager.remove(room);
		
	}

	@Override
	public User authentification(String username, String pwd) {
		
		String jpql = "SELECT z FROM User z WHERE z.username=:username and z.pwd=:pwd";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("username", username);
		query.setParameter("pwd", pwd);
		User user= null;
		try {
		  user=(User)query.getSingleResult();

	
} catch (Exception e) {
	// TODO: handle exception
}

		return user;
	
		
	}

	@Override
	public List<Supervisor> findAllSupervisors() {
		String jpql = "SELECT u FROM Supervisor u";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}

	@Override
	public Supervisor findSupervisorByName(String name) {
		return entityManager.createQuery("SELECT c FROM Supervisor c WHERE c.name=:p", Supervisor.class)
				.setParameter("p", name).getSingleResult();
		
	}
	
}
