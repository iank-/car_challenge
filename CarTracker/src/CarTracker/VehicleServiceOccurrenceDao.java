package CarTracker;

import java.util.HashMap;
import java.util.Map;


public enum VehicleServiceOccurrenceDao {
	instance;
	
	private Map<String, VehicleServiceOccurrence> contentProvider = new HashMap<>();
	
	private VehicleServiceOccurrenceDao() {
		if (this.contentProvider == null) {
			this.contentProvider = new HashMap<>();
		}
	}
	

	public Map<String, VehicleServiceOccurrence> getModel() {
		return contentProvider;
	}

	
}