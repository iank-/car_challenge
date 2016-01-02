package CarTracker;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.JAXBElement;

@Path("/vehicle")
public class VehicleResource {

	@Context
	UriInfo uriInfo;
	@Context
	Request request;
	String id;
	public VehicleResource(UriInfo uriInfo, Request request, String id) {
		this.uriInfo = uriInfo;
		this.request = request;
		this.id = id;
	}
	
	//Application integration     
	  @GET
	  @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	  public Vehicle getVehicle() {
	    Vehicle v = VehicleDao.instance.getModel().get(id);
	    if(v == null) {
	    	throw new RuntimeException("Get: vehicle with " + id +  " not found");
	    }
	    return v;
	  }
	  
	  // for the browser
	  @GET
	  @Produces(MediaType.TEXT_XML)
	  public Vehicle getVehicleHtml() {
		  Vehicle v = VehicleDao.instance.getModel().get(id);
	    if(v == null) {
	    	throw new RuntimeException("Get: vehicle with " + id +  " not found");
	    }
	    return v;
	  }
	  
	  @PUT
	  @Consumes(MediaType.APPLICATION_XML)
	  public Response putVehicle(JAXBElement<Vehicle> vehicle) {
		Vehicle v = vehicle.getValue();
	    return putAndGetResponse(v);
	  }
	  
	  @DELETE
	  public void deleteTodo() {
		Vehicle c = VehicleDao.instance.getModel().remove(id);
	    if(c==null)
	      throw new RuntimeException("Delete: vehicle with " + id +  " not found");
	  }
	  
	  private Response putAndGetResponse(Vehicle v) {
	    Response res;
	    if(VehicleDao.instance.getModel().containsKey(v.getId())) {
	      res = Response.noContent().build();
	    } else {
	      res = Response.created(uriInfo.getAbsolutePath()).build();
	    }
	    VehicleDao.instance.getModel().put(v.getId(), v);
	    return res;
	  }
	  
	
}
