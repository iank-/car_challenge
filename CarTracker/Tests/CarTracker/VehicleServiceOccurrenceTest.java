package CarTracker;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import junit.framework.Assert;

public class VehicleServiceOccurrenceTest {

	Service s_okOnNotElectric, s_okOnOnlyGas, s_okOnAll, s_okOnOnlyElectric;
	Vehicle v_gas, v_electric, v_diesel;
	
	VehicleServiceOccurrence vso;
	
	@Before
	public void beforeTest() {
		
		s_okOnNotElectric = new Service("0");
		s_okOnNotElectric.setName("oil_change");
		s_okOnNotElectric.setAvailableOnDiesel(true);
		s_okOnNotElectric.setAvailableOnElectric(false);
		s_okOnNotElectric.setAvailableOnGasoline(true);
		
		s_okOnOnlyGas = new Service("1");
		s_okOnOnlyGas.setName("replace_sparkplugs");
		s_okOnOnlyGas.setAvailableOnDiesel(false);
		s_okOnOnlyGas.setAvailableOnElectric(false);
		s_okOnOnlyGas.setAvailableOnGasoline(true);
		
		s_okOnAll = new Service("2");
		s_okOnAll.setName("replace_brakes");
		s_okOnAll.setAvailableOnDiesel(true);
		s_okOnAll.setAvailableOnElectric(true);
		s_okOnAll.setAvailableOnGasoline(true);
		
		s_okOnOnlyElectric = new Service("3");
		s_okOnOnlyElectric.setName("replace_motor_battery");
		s_okOnOnlyElectric.setAvailableOnDiesel(true);
		s_okOnOnlyElectric.setAvailableOnElectric(true);
		s_okOnOnlyElectric.setAvailableOnGasoline(true);
		
		
		
		
		v_gas = new GasolineVehicle("0");
		v_gas.setMake("BMW");
		v_gas.setModel("525i");
		v_gas.setYear(2006);
		v_gas.setOdometerReading(1337);
		
		v_electric = new ElectricVehicle("1");
		v_electric.setMake("Tesla");
		v_electric.setModel("S");
		v_electric.setYear(2015);
		v_electric.setOdometerReading(20);
		
		v_diesel = new DieselVehicle("2");
		v_diesel.setMake("Volkswagen");
		v_diesel.setModel("Golf TDI");
		v_diesel.setYear(2009);
		v_diesel.setOdometerReading(5000);
		
	}
	
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	 
	
	@Test
	public void testSetServiceAndVehicle_ExpectedCompatible() {
		
		 vso = new VehicleServiceOccurrence();
		
		/*
		 * 	Service s0_okOnNotElectric, s1_okOnGas, s2_okOnAll, s3_okOnOnlyElectric;
		 *	Vehicle v0_gas, v1_electric, v2_diesel;
		 *
		 * */
		
		try {
			vso.setServiceAndVehicle(v_gas, s_okOnOnlyGas);
		} catch (ServiceNotCompatibleException e) {
			fail("Not expecting ServiceNotCompatibleException! - v_gas and s_okOnOnlyGas");
		}
		
		try {
			vso.setServiceAndVehicle(v_electric, s_okOnAll);
		} catch (ServiceNotCompatibleException e) {
			fail("Not expecting ServiceNotCompatibleException! - v_electric and s_okOnAll");
		}
		
		try {
			vso.setServiceAndVehicle(v_diesel, s_okOnNotElectric);
		} catch (ServiceNotCompatibleException e) {
			fail("Not expecting ServiceNotCompatibleException! - v_diesel and s_okOnNotElectric");
		}
		
	}
	
	@Test
	public void testSetServiceAndVehicle_ExpectedNotCompatible_Gasoline() {
		
		vso = new VehicleServiceOccurrence();

		try {
			vso.setServiceAndVehicle(v_gas, s_okOnOnlyElectric);
		} catch (ServiceNotCompatibleException e) {
			// expected
		}

	}
	
	@Test
	public void testSetServiceAndVehicle_ExpectedNotCompatible_Diesel() {
		
		vso = new VehicleServiceOccurrence();

		try {
			vso.setServiceAndVehicle(v_diesel, s_okOnOnlyGas);
		} catch (ServiceNotCompatibleException e) {
			// expected
		}
	}
	
	@Test
	public void testSetServiceAndVehicle_ExpectedNotCompatible_Electric() {
		
		vso = new VehicleServiceOccurrence();
		
		try {
			vso.setServiceAndVehicle(v_electric, s_okOnNotElectric);
		} catch (ServiceNotCompatibleException e) {
			// expected
		}
	}

}
