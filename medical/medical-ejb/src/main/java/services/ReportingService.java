package services;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import persistence.Room;

/**
 * Session Bean implementation class ReportingService
 */
@Stateless
public class ReportingService implements ReportingServiceRemote, ReportingServiceLocal {
	@PersistenceContext
	private EntityManager entityManager;
	@EJB
	private BasicOpsLocal basicOpsLocal;

	/**
	 * Default constructor.
	 */
	public ReportingService() {
	}

	@Override
	public int findOccupiedRooms() {
		int nb = 0;
		List<Room> rooms = basicOpsLocal.findAllRooms();
		for (Room r : rooms) {
			if (r.getPatient() != null) {
				nb++;
			} else {
				System.err.println("RAS");
			}
		}
		return nb;
	}

}
