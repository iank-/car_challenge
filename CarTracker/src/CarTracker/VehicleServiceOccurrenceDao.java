package CarTracker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import CarTracker.Vehicle;

public enum VehicleServiceOccurrenceDao {
	instance;
	
	private Map<String, VehicleServiceOccurrence> contentProvider = new HashMap<>();
	private int numberOfEntries;
	
	private VehicleServiceOccurrenceDao() {
		this.numberOfEntries = 0;
	}
	

	public Map<String, VehicleServiceOccurrence> getModel() {
		return contentProvider;
	}
	
	public ArrayList<VehicleServiceOccurrence> getVehicleServiceOccurrencesByVehicle(Vehicle vehicle) {
		ArrayList<VehicleServiceOccurrence> filteredServiceOccurrencesByVehicle = new ArrayList<VehicleServiceOccurrence>();
		/*
		Iterator<VehicleServiceOccurrence> serviceOccurrenceIterator = contentProvider.iterator();
		while (serviceOccurrenceIterator.hasNext()) {
			VehicleServiceOccurrence serviceOccurrence = serviceOccurrenceIterator.next();
			
			if (serviceOccurrence.getVehicle().getId() == vehicle.getId()) {
				filteredServiceOccurrencesByVehicle.add(serviceOccurrence);
			}
		}
		*/
		return filteredServiceOccurrencesByVehicle;
	}

	
}