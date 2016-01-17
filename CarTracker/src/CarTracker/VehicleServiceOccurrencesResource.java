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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Path("/vehicleServiceOccurrences")
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
	    serviceOccurrences.addAll(VehicleServiceOccurrenceDao.instance.getModel().values());
	    return serviceOccurrences;
	  }

	  // Return the list of Services for applications
	  @GET
	  @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	  public List<VehicleServiceOccurrence> getVehicleServiceOccurrences() {
	    List<VehicleServiceOccurrence> serviceOccurrences = new ArrayList<VehicleServiceOccurrence>();
	    serviceOccurrences.addAll(VehicleServiceOccurrenceDao.instance.getModel().values());
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
	  public void newVehicleServiceOccurrence(
	    
	      @FormParam("vehicleId") String vehicleId,
	      @FormParam("serviceName") String serviceName,
	      @FormParam("odometerReading") int odometerReading,
	      @Context HttpServletResponse servletResponse) throws IOException {
		  
		  System.out.println("NEW VSO!! Looking for vehicle id=" + vehicleId);

		  Vehicle vehicle = VehicleDao.instance.getVehicleForId(vehicleId);
		  if (vehicle == null) {
			  System.out.println("Unknown vehicle with id " + vehicleId);
			  throw new RuntimeException("unknown vehicle with id" + vehicleId);

		  }
		  
		  System.out.println("Found vehicle " + vehicle.id);
		  
		  Service service = ServiceDao.instance.getServiceForName(serviceName);
		  if (service == null) {
		    
		    System.out.println("Unknown service " + serviceName);
			  throw new RuntimeException("unknown service" + serviceName);

		  }
		  
		  System.out.println("Found service " + service.getName());

		  
		  VehicleServiceOccurrence vso = new VehicleServiceOccurrence();
		  vso.setOdometerReading(odometerReading);
		  
		  try {
			  vso.setServiceAndVehicle(vehicle, service);
		  } catch (ServiceNotCompatibleException e) {
			  
			  System.out.println("vehicle " + vehicle.getId() + " is of type " + vehicle.getVehicleType().toString() + " and is not compatible with service " + service.getName());
			  throw new RuntimeException("not compatible");
			  //servletResponse.sendRedirect("../error.html");
			  
		  }
		  
		  System.out.println("compatible. continuing..");
		  
		  int count = VehicleServiceOccurrenceDao.instance.getModel().size();
		  VehicleServiceOccurrenceDao.instance.getModel().put(Integer.toString(count + 1), vso);
		  
		  servletResponse.sendRedirect("../rest/vehicleServiceOccurrences");
	  }

	  // Defines that the next path parameter after vehicle is
	  // treated as a parameter and passed to the TodoResources
	  // Allows to type http://localhost:8080/CarTracker/rest/todos/1
	  // 1 will be treaded as parameter vehicle and passed to TodoResource
	  @Path("{vehicleServiceOccurrence}")
	  public VehicleServiceOccurrenceResource getVehicle(@PathParam("vehicleServiceOccurrence") String id) {
	    return new VehicleServiceOccurrenceResource(uriInfo, request, id);
	  }

}