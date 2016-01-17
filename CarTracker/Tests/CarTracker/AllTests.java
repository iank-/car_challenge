package CarTracker;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ ServiceDaoTest.class, VehicleDaoTest.class, VehicleServiceOccurrenceDaoTest.class,
		VehicleServiceOccurrenceTest.class })
public class AllTests {

}
