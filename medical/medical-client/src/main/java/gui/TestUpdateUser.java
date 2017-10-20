package gui;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import persistence.User;
import services.BasicOpsRemote;

public class TestUpdateUser {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		BasicOpsRemote basicOpsRemote = (BasicOpsRemote) context
				.lookup("medical-ear/medical-ejb/BasicOps!services.BasicOpsRemote");

		User user = basicOpsRemote.findUserById(2);
		
		user.setName("new look");
		
		basicOpsRemote.updateUser(user);

		

	}

}
