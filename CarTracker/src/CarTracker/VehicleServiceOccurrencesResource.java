package CarTracker;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Path("/serviceOccurrences")
public class VehicleServiceOccurrencesResource {
	@Context
	UriInfo uriInfo;
	@Context
	Request request;

	 // Return the list of Services to the user in the browser
	  @GET
	  @Produces(MediaType.TEXT_XML)
	  public List<VehicleServiceOccurrence> getVehicleServiceOccurrencesBrowser() {
	    List<VehicleServiceOccurrence> serviceOccurrences = new ArrayList<VehicleServiceOccurrence>();
	    serviceOccurrences.addAll(VehicleServiceOccurrenceDao.instance.getModel());
	    return serviceOccurrences;
	  }

	  // Return the list of Services for applications
	  @GET
	  @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	  public List<VehicleServiceOccurrence> getVehicleServiceOccurrences() {
	    List<VehicleServiceOccurrence> serviceOccurrences = new ArrayList<VehicleServiceOccurrence>();
	    serviceOccurrences.addAll(VehicleServiceOccurrenceDao.instance.getModel());
	    return serviceOccurrences;
	  }

	  // Returns the number of Service Occurrences
	  // Use http://localhost:8080/CarTracker/rest/serviceOccurrences/count
	  // to get the total number of records
	  @GET
	  @Path("count")
	  @Produces(MediaType.TEXT_PLAIN)
	  public String getCount() {
	    int count = VehicleServiceOccurrenceDao.instance.getModel().size();
	    return String.valueOf(count);
	  }

	  @POST
	  @Produces(MediaType.TEXT_HTML)
	  @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	  public void newServiceOccurrence(
	    
	      @FormParam("vehicleId") String vehicleId,
	      @FormParam("serviceName") String serviceName,
	      @FormParam("odometerReading") int odometerReading,
	      @Context HttpServletResponse servletResponse) throws IOException {

		  Vehicle vehicle = VehicleDao.instance.getVehicleForId(vehicleId);
		  if (vehicle == null) {
			  servletResponse.sendRedirect("../error.html");
		  }
		  
		  Service service = ServiceDao.instance.getServiceWithName(serviceName);
		  if (service == null) {
			  servletResponse.sendRedirect("../error.html");
		  }
		  
		  VehicleServiceOccurrence vso = null;
		  
		  try {
			  vso = new VehicleServiceOccurrence(vehicle, service, odometerReading);
			  
		  } catch (ServiceNotCompatibleException e) {
			  servletResponse.sendRedirect("../error.html");
		  }
		  
		  VehicleServiceOccurrenceDao.instance.getModel().add(vso);
		  
		  servletResponse.sendRedirect("../service_vehicle.html");
	  }

	  // Defines that the next path parameter after vehicle is
	  // treated as a parameter and passed to the TodoResources
	  // Allows to type http://localhost:8080/CarTracker/rest/todos/1
	  // 1 will be treaded as parameter vehicle and passed to TodoResource
	  @Path("{vehicle}")
	  public VehicleResource getVehicle(@PathParam("vehicle") String id) {
	    return new VehicleResource(uriInfo, request, id);
	  }

}
