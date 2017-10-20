package services;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import persistence.Room;
import persistence.User;

/**
 * Session Bean implementation class AssignmentService
 */
@Stateless
public class AssignmentService implements AssignmentServiceRemote, AssignmentServiceLocal {
	@PersistenceContext
	private EntityManager entityManager;

	@EJB
	private BasicOpsLocal basicOpsLocal;

	/**
	 * Default constructor.
	 */
	public AssignmentService() {
	}

	@Override
	public void assignPatientToRoom(User user, Room room) {
		user.setPatientsRoom(room);
		
		basicOpsLocal.updateUser(user);

	}

	@Override
	public void assignSupervisorToRoom(User user, Room room) {
		// TODO Auto-generated method stub

	}

	@Override
	public void assignDoctorToRoom(User user, Room room) {
		// TODO Auto-generated method stub

	}

}
