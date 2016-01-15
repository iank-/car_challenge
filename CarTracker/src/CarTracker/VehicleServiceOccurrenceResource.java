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

@Path("/vehicleServiceOccurrence")
public class VehicleServiceOccurrenceResource {

	@Context
	UriInfo uriInfo;
	@Context
	Request request;
	String id;
	public VehicleServiceOccurrenceResource(UriInfo uriInfo, Request request, String id) {
		this.uriInfo = uriInfo;
		this.request = request;
		this.id = id;
	}
	
	//Application integration     
	  @GET
	  @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	  public VehicleServiceOccurrence getVehicleServiceOccurrence() {
	    VehicleServiceOccurrence v = VehicleServiceOccurrenceDao.instance.getModel().get(id);
	    if(v == null) {
	    	throw new RuntimeException("Get: vehicle service occurrence with " + id +  " not found");
	    }
	    return v;
	  }
	  
	  // for the browser
	  @GET
	  @Produces(MediaType.TEXT_XML)
	  public VehicleServiceOccurrence getVehicleServiceOccurrenceHtml() {
		VehicleServiceOccurrence v = VehicleServiceOccurrenceDao.instance.getModel().get(id);
	    if(v == null) {
	    	throw new RuntimeException("Get: Vehicle Service Occurrence with " + id +  " not found");
	    }
	    return v;
	  }
	  
	  @PUT
	  @Consumes(MediaType.APPLICATION_XML)
	  public Response putVehicleServiceOccurrence(JAXBElement<VehicleServiceOccurrence> v) {
		VehicleServiceOccurrence vso = v.getValue();
	    return putAndGetResponse(vso);
	  }
	  
	  @DELETE
	  public void deleteVehicleServiceOccurrence() {
		VehicleServiceOccurrence vso = VehicleServiceOccurrenceDao.instance.getModel().remove(id);
	    if (vso == null)
	      throw new RuntimeException("Delete: Vehicle Service Occurrence with " + id +  " not found");
	  }
	  
	  private Response putAndGetResponse(VehicleServiceOccurrence v) {
	    Response res;
	    if(VehicleServiceOccurrenceDao.instance.getModel().containsKey(v.getId())) {
	      res = Response.noContent().build();
	    } else {
	      res = Response.created(uriInfo.getAbsolutePath()).build();
	    }
	    VehicleServiceOccurrenceDao.instance.getModel().put(v.getId(), v);
	    return res;
	  }
	  
	
}
