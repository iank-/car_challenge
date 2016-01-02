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

@Path("/vehicles")
public class VehiclesResource {

	@Context
	UriInfo uriInfo;
	@Context
	Request request;

	 // Return the list of Vehicles to the user in the browser
	  @GET
	  @Produces(MediaType.TEXT_XML)
	  public List<Vehicle> getVehiclesBrowser() {
	    List<Vehicle> vehicles = new ArrayList<Vehicle>();
	    vehicles.addAll(VehicleDao.instance.getModel().values());
	    return vehicles;
	  }

	  // Return the list of Vehicles for applications
	  @GET
	  @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	  public List<Vehicle> getVehicles() {
	    List<Vehicle> vehicles = new ArrayList<Vehicle>();
	    vehicles.addAll(VehicleDao.instance.getModel().values());
	    return vehicles;
	  }

	  // Returns the number of Vehicles
	  // Use http://localhost:8080/CarTracker/rest/vehicles/count
	  // to get the total number of records
	  @GET
	  @Path("count")
	  @Produces(MediaType.TEXT_PLAIN)
	  public String getCount() {
	    int count = VehicleDao.instance.getModel().size();
	    return String.valueOf(count);
	  }

	  @POST
	  @Produces(MediaType.TEXT_HTML)
	  @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	  public void newVehicle(
		  @FormParam("id") String id,
	      @FormParam("make") String make,
	      @FormParam("model") String model,
	      @FormParam("year") int year,
	      @FormParam("odometerReading") int odometerReading,
	      @Context HttpServletResponse servletResponse) throws IOException {
		  
		  Vehicle vehicle = new Vehicle(id);
		  vehicle.setMake(make);
		  vehicle.setModel(model);
		  vehicle.setYear(year);
		  vehicle.setOdometerReading(odometerReading);
		  
		  VehicleDao.instance.getModel().put(id, vehicle);

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
