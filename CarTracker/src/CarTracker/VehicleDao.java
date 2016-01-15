package CarTracker;

import java.util.HashMap;
import java.util.Map;

import CarTracker.Vehicle;

public enum VehicleDao {
	instance;
	
	private Map<String, Vehicle> contentProvider = new HashMap<>();
	
	private VehicleDao() {
		
		Vehicle v1 = new GasolineVehicle("0");
		v1.setMake("BMW");
		v1.setModel("525i");
		v1.setYear(2006);
		v1.setOdometerReading(1337);
		
		contentProvider.put("0", v1);
		
	}
	
	public Map<String, Vehicle> getModel() {
		return contentProvider;
	}
	
	public Vehicle getVehicleForId(String id) {
		return contentProvider.get(id);
	}
	
}
