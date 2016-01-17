package CarTracker;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ServiceDaoTest {
	
	@Before
	public void beforeTest() {
		
		Service s0 = new Service("0");
		s0.setName("oil_change");
		s0.setAvailableOnDiesel(true);
		s0.setAvailableOnElectric(false);
		s0.setAvailableOnGasoline(true);
		ServiceDao.instance.getModel().put("0", s0);
		
		Service s1 = new Service("1");
		s1.setName("replace_sparkplugs");
		s1.setAvailableOnDiesel(false);
		s1.setAvailableOnElectric(false);
		s1.setAvailableOnGasoline(true);
		ServiceDao.instance.getModel().put("1", s1);
		
		Service s2 = new Service("2");
		s2.setName("replace_brakes");
		s2.setAvailableOnDiesel(true);
		s2.setAvailableOnElectric(true);
		s2.setAvailableOnGasoline(true);
		ServiceDao.instance.getModel().put("2", s2);
	}
	
	@Test
	public void testGetServiceForName() {
		
		String expectedName = "replace_brakes";
		
		Service result;
		result = ServiceDao.instance.getServiceForName("replace_brakes");
		
		assertNotNull("Lookup service by name failed.", result);
		assertEquals("Name of result must match queried service name.", expectedName, result.getName());
		assertEquals("Field availableOnDiesel not retreived successfully.", true, result.isAvailableOnDiesel());
		assertEquals("Field availableOnElectric not retreived successfully.", true, result.isAvailableOnElectric());
		assertEquals("Field availableOnGasoline not retreived successfully.", true, result.isAvailableOnGasoline());

	}

	@Test
	public void testGetModel() {
		assertNotNull("DAO model must not be empty.", ServiceDao.instance.getModel());
	}

	@Test
	public void testGetServiceForId() {
		
		String expectedId = "0";
		
		Service result;
		result = ServiceDao.instance.getServiceForName("oil_change");
		
		assertNotNull("Lookup service by ID failed.", result);
		assertEquals("ID of result must match queried ID", expectedId, result.getId());
		assertEquals("Field availableOnDiesel not retreived successfully.", true, result.isAvailableOnDiesel());
		assertEquals("Field availableOnElectric not retreived successfully.", false, result.isAvailableOnElectric());
		assertEquals("Field availableOnGasoline not retreived successfully.", true, result.isAvailableOnGasoline());
		
	}

}
