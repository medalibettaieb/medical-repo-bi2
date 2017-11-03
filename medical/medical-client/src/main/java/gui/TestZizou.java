package gui;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import persistence.User;
import services.BasicOpsRemote;
import services.HelloRemote;

public class TestZizou {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		BasicOpsRemote basicOpsRemote = (BasicOpsRemote) context
				.lookup("medical-ear/medical-ejb/BasicOps!services.BasicOpsRemote");

		
HelloRemote helloRemote= (HelloRemote) context.lookup("medical-ear/medical-ejb/Hellobean!services.HelloRemote");
helloRemote.zizou();
		

	}

}
