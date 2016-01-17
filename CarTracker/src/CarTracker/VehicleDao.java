package CarTracker;

import java.util.HashMap;
import java.util.Map;

import CarTracker.Vehicle;

public enum VehicleDao {
	instance;
	
	private Map<String, Vehicle> contentProvider = new HashMap<>();
	
	private VehicleDao() {
		

		
	}
	
	public Map<String, Vehicle> getModel() {
		return contentProvider;
	}
	
	public Vehicle getVehicleForId(String id) {
		return contentProvider.get(id);
	}
	
}
