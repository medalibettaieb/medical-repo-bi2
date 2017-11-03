package services;

import javax.ejb.Stateless;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

/**
 * Session Bean implementation class ZinoubaHabean
 */
@Stateless
public class Hellobean implements HelloRemote, HelloLocal {

	/**
	 * Default constructor.
	 */
	public Hellobean() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void zizou() {
		Client client = ClientBuilder.newClient();

		// The base URL of the service
		WebTarget target = client.target("http://localhost:18080/Hello_Restful/rest/H");

		// consuming sayHello method
		// Get the response from the target URL:
		Response response = target.request().get();
		// Read the result as a String:
		String result = response.readEntity(String.class);
		// Print the result to the standard output:
		System.out.println(result);
		response.close();

		// Building the relative URL manually for the sayHelloTo method:
		WebTarget helloTo1 = target.path("Foulen");
		// Get the response from the target URL:
		Response response1 = helloTo1.request().get();
		// Read the result as a String:
		String result1 = response1.readEntity(String.class);
		// Print the result to the standard output:
		System.out.println(result1);
		response1.close();

		// Building the relative URL manually for the sayHelloTo2 method:
		WebTarget helloTo2 = target.queryParam("nom", "Foulen");
		// Get the response from the target URL:
		Response response2 = helloTo2.request().get();
		// Read the result as a String:
		String result2 = response2.readEntity(String.class);
		// Print the result to the standard output:
		System.out.println(result2);
		response2.close();

		client.close();
	}

}
