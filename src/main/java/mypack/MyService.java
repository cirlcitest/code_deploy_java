package mypack;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
@Path("/myresource")

public class MyService {




 
    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!";
    }
    
    
    
    @GET
    @Path("/object")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getObject() {
    	
    	
    	Response response  = null;
    	Student s = new Student();
    	s.setName("Abhishake");
    	s.setAge(23);
    	response = Response
				.status(javax.ws.rs.core.Response.Status.OK)
				.entity(s).build();
        
        
        return response;
        
    }
    
    
    @POST
    @Path("/addStudent")
    @Produces(MediaType.APPLICATION_JSON)
    public Response addStudent(Student s) {
    	
    	System.out.println("inside of add student "+s);
    	Response response  = null;
    	JDBCExample.saveStudent(s);
    	response = Response
				.status(javax.ws.rs.core.Response.Status.OK)
				.entity(s).build();
        
        
        return response;
        
    }
    
    @GET
    @Path("/getStudent/{roll}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response getStudent(@PathParam ("roll") int roll) {
    	
    	System.out.println("insdie of getStudent"+roll);
    	
    	Response response  = null;
    	String name =  JDBCExample.getStudent(roll);
    	response = Response
				.status(javax.ws.rs.core.Response.Status.OK)
				.entity(name).build();
        
        
        return response;
        
    }
    
}