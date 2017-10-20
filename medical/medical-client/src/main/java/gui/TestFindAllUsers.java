package gui;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import persistence.User;
import services.BasicOpsRemote;

public class TestFindAllUsers {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		BasicOpsRemote basicOpsRemote = (BasicOpsRemote) context
				.lookup("medical-ear/medical-ejb/BasicOps!services.BasicOpsRemote");

		List<User> users = basicOpsRemote.findAllUsers();
		for (User u : users) {
			System.out.println(u.getName());
		}

	}

}
