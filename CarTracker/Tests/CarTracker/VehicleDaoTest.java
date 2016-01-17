package CarTracker;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class VehicleDaoTest {
	
	@Before
	public void beforeTest() {
		
		Vehicle v0 = new GasolineVehicle("0");
		v0.setMake("BMW");
		v0.setModel("525i");
		v0.setYear(2006);
		v0.setOdometerReading(1337);
		VehicleDao.instance.getModel().put("0", v0);
		
		Vehicle v1 = new ElectricVehicle("1");
		v1.setMake("Tesla");
		v1.setModel("S");
		v1.setYear(2015);
		v1.setOdometerReading(20);
		VehicleDao.instance.getModel().put("1", v1);		
		
		Vehicle v2 = new DieselVehicle("2");
		v2.setMake("Volkswagen");
		v2.setModel("Golf TDI");
		v2.setYear(2009);
		v2.setOdometerReading(5000);
		VehicleDao.instance.getModel().put("2", v2);	
	}
	


	@Test
	public void testGetModel() {
		assertNotNull("DAO model must not be empty.", VehicleDao.instance.getModel());
	}

	@Test
	public void testGetVehicleForId() {
		
		String expectedId = "1";
		
		Vehicle result;
		result = VehicleDao.instance.getVehicleForId("1");
		
		assertNotNull("Lookup vehicle by id failed.", result);
		assertEquals("ID of result must match queried ID", expectedId, result.getId());
		assertEquals("Field make not retreived successfully.", "Tesla", result.getMake());
		assertEquals("Field model not retreived successfully.", "S", result.getModel());
		assertEquals("Field year not retreived successfully.", 2015, result.getYear());
		assertEquals("Field odometer reading not retreived successfully.", 20, result.getOdometerReading());

	}

}
