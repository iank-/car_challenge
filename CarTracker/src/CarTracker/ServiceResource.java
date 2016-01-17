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

@Path("/service")
public class ServiceResource {

	@Context
	UriInfo uriInfo;
	@Context
	Request request;
	String id;
	public ServiceResource(UriInfo uriInfo, Request request, String id) {
		this.uriInfo = uriInfo;
		this.request = request;
		this.id = id;
	}
	
	//Application integration     
	  @GET
	  @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	  public Service getService() {
		Service v = ServiceDao.instance.getModel().get(id);
	    if(v == null) {
	    	throw new RuntimeException("Get: Service with " + id +  " not found");
	    }
	    return v;
	  }
	  
	  // for the browser
	  @GET
	  @Produces(MediaType.TEXT_XML)
	  public Service getServiceHtml() {
		  Service v = ServiceDao.instance.getModel().get(id);
	    if(v == null) {
	    	throw new RuntimeException("Get: Service with " + id +  " not found");
	    }
	    return v;
	  }
	  
	  @PUT
	  @Consumes(MediaType.APPLICATION_XML)
	  public Response putService(JAXBElement<Service> service) {
		  Service s = service.getValue();
	    return putAndGetResponse(s);
	  }
	  
	  @DELETE
	  public void deleteTodo() {
		  Service c = ServiceDao.instance.getModel().remove(id);
	    if(c==null)
	      throw new RuntimeException("Delete: Service with " + id +  " not found");
	  }
	  
	  private Response putAndGetResponse(Service s) {
	    Response res;
	    if(ServiceDao.instance.getModel().containsKey(s.getId())) {
	      res = Response.noContent().build();
	    } else {
	      res = Response.created(uriInfo.getAbsolutePath()).build();
	    }
	    ServiceDao.instance.getModel().put(s.getId(), s);
	    return res;
	  }
	  
	
}