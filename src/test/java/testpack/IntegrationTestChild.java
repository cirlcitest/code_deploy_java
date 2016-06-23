package testpack;

/*code testing...ttt*/
import org.junit.Ignore;

import org.junit.Test;

import junit.framework.Assert;
import mypack.JDBCExample;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.*;
import java.util.Properties;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import org.junit.experimental.categories.Category;

/*import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;*/
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.glassfish.jersey.client.ClientConfig;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@Category(IntegrationTest.class)//this is availbale in junit 4.12 not in 4.2
/* all the integration test cases classes should start from IntegrationTest*/

public class IntegrationTestChild implements IntegrationTest{
public static final String BASE_URI = "http://localhost:9090/rest";

ClientConfig config;
Client client;
WebTarget target;


@Before
public  void setUp() throws Exception {

	config = new ClientConfig();
	client = ClientBuilder.newClient(config);
	target = client.target(getBaseURI());
	System.out.println("check the ur"+target.getUri());
	
}


private static URI getBaseURI() {
	System.out.println("inside of builder");
	return UriBuilder.fromUri(BASE_URI).build();
}






@Test
public void addStudent() throws Exception{
	
		  String student = "{\"name\":\"Arup\",\"roll\":\"12\",\"age\":\"22\"}";
		  Entity entity = Entity.entity(student, MediaType.APPLICATION_JSON_TYPE);
		  Response response = target.path("/myresource").path("addStudent").request().accept(MediaType.APPLICATION_JSON).post(entity);
		  System.out.println("see the response value"+response);
		  System.out.println(target.getUri());
		  String responseAsString = response.readEntity(String.class);
		  Assert.assertEquals(200, response.getStatus());
		  System.out.println("server response"+responseAsString);
		  System.out.println("-----------------All Records -------------------");
		  JDBCExample.displayAll();

}


@Test
public void getName() throws Exception{
	
		
		
		  Response response = target.path("/myresource").path("getStudent/12").request().accept(MediaType.TEXT_PLAIN).get();
		  System.out.println("see the response value"+response);
		  System.out.println(target.getUri());
		  String responseAsString = response.readEntity(String.class);
		  Assert.assertEquals(200, response.getStatus());
		  System.out.println(">>>>>>>>>>>>>>>>>>>>>>server response"+responseAsString);
		  Assert.assertEquals("Arup",responseAsString);

}

public boolean isJSONValid(String test) {
    try {
        new JSONObject(test);
    } catch (JSONException ex) {
      
        try {
            new JSONArray(test);
        } catch (JSONException ex1) {
            return false;
        }
    }
    return true;
}


}

//String val = "{\"emailId\":\"sushd@gmail.com\",\"phoneNumber\":\"8904629976\", \"passCode\": \"Tarang@01\"}";

	//  Entity en = Entity.entity(val, MediaType.APPLICATION_JSON);

	// Response response = target.path("user").request(MediaType.APPLICATION_JSON).header("api-key","1upqbzm8zgi80rwuc9n34vsofsis3vs-").accept(MediaType.APPLICATION_JSON).post(en);
