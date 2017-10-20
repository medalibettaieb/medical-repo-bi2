package services;

import javax.ejb.Remote;

@Remote
public interface ReportingServiceRemote {
	int findOccupiedRooms();
}
