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

@Path("/services")
public class ServicesResource {

	@Context
	UriInfo uriInfo;
	@Context
	Request request;

	 // Return the list of Vehicles to the user in the browser
	  @GET
	  @Produces(MediaType.TEXT_XML)
	  public List<Service> getServicesBrowser() {
	    List<Service> services = new ArrayList<Service>();
	    services.addAll(ServiceDao.instance.getModel().values());
	    return services;
	  }

	  // Return the list of Vehicles for applications
	  @GET
	  @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	  public List<Service> getServices() {
	    List<Service> services = new ArrayList<Service>();
	    services.addAll(ServiceDao.instance.getModel().values());
	    return services;
	  }

	  // Returns the number of Vehicles
	  // Use http://localhost:8080/CarTracker/rest/vehicles/count
	  // to get the total number of records
	  @GET
	  @Path("count")
	  @Produces(MediaType.TEXT_PLAIN)
	  public String getCount() {
	    int count = ServiceDao.instance.getModel().size();
	    return String.valueOf(count);
	  }

	  @POST
	  @Produces(MediaType.TEXT_HTML)
	  @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	  public void newService(
		  @FormParam("name") String name,
	      @FormParam("availableOnGasoline") int availableOnGasoline,
	      @FormParam("availableOnElectric") int availableOnElectric,
	      @FormParam("availableOnDiesel") int availableOnDiesel,
	      @Context HttpServletResponse servletResponse) throws IOException {
		  
		  Service s = new Service();
		  s.setName(name);
		  s.setAvailableOnDiesel(availableOnDiesel==0 ? false : true);
		  s.setAvailableOnElectric(availableOnElectric==0 ? false : true);
		  s.setAvailableOnGasoline(availableOnGasoline==0 ? false : true);
		  
		  int count = VehicleDao.instance.getModel().size();
		  
		  ServiceDao.instance.getModel().put(Integer.toString(count + 1), s);

		  servletResponse.sendRedirect("../service_vehicle.html");
	  }

	  // Defines that the next path parameter after vehicle is
	  // treated as a parameter and passed to the TodoResources
	  // Allows to type http://localhost:8080/CarTracker/rest/todos/1
	  // 1 will be treaded as parameter vehicle and passed to TodoResource
	  @Path("{service}")
	  public ServiceResource getVehicle(@PathParam("service") String id) {
	    return new ServiceResource(uriInfo, request, id);
	  }


}
