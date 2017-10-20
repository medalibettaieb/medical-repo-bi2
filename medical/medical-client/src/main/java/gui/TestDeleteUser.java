package gui;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import persistence.User;
import services.BasicOpsRemote;

public class TestDeleteUser {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		BasicOpsRemote basicOpsRemote = (BasicOpsRemote) context
				.lookup("medical-ear/medical-ejb/BasicOps!services.BasicOpsRemote");

		User user = basicOpsRemote.findUserById(4);

		basicOpsRemote.deleteUser(user);

	}

}
