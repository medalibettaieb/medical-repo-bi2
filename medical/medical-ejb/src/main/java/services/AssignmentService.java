package services;

import java.util.List;

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
	@EJB
	private ReportingServiceLocal reportingServiceLocal;

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
		room.setSuperviser(user);

		basicOpsLocal.updateRoom(room);
	}

	@Override
	public void assignDoctorToRoom(User user, Room room) {
		
	}

	@Override
	public void assignRoomsToSupervisor(List<Room> rooms, User superviser) {
		List<Room> oldRooms=reportingServiceLocal.findRoomsBySupervisor(superviser.getId());
	for (Room r : rooms) {
			oldRooms.add(r);
		}
		//superviser.linkRoomsToThisUser(oldRooms);

		basicOpsLocal.updateUser(superviser);
	}

}
