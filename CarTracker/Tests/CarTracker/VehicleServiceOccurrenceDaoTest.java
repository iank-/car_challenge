package CarTracker;

import static org.junit.Assert.*;

import org.junit.Test;

public class VehicleServiceOccurrenceDaoTest {

	@Test
	public void testGetModel() {
		assertNotNull("DAO model must not be empty.", VehicleServiceOccurrenceDao.instance.getModel());
	}
}
