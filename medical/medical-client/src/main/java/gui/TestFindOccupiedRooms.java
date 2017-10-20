package gui;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import services.BasicOpsRemote;
import services.ReportingServiceRemote;

public class TestFindOccupiedRooms {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		BasicOpsRemote basicOpsRemote = (BasicOpsRemote) context
				.lookup("medical-ear/medical-ejb/BasicOps!services.BasicOpsRemote");

		ReportingServiceRemote reportingServiceRemote = (ReportingServiceRemote) context
				.lookup("medical-ear/medical-ejb/ReportingService!services.ReportingServiceRemote");

		int nb = reportingServiceRemote.findOccupiedRooms();

		System.out.println(nb);
	}

}
