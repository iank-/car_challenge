package CarTracker;

import java.util.ArrayList;
import java.util.Iterator;

import CarTracker.Vehicle;

public enum VehicleServiceOccurrenceDao {
	instance;
	
	private ArrayList<VehicleServiceOccurrence> contentProvider = new ArrayList<VehicleServiceOccurrence>();
	
	private VehicleServiceOccurrenceDao() {
		
	}
	
	public ArrayList<VehicleServiceOccurrence> getModel() {
		return contentProvider;
	}
	
	public ArrayList<VehicleServiceOccurrence> getVehicleServiceOccurrences(Vehicle vehicle) {
		ArrayList<VehicleServiceOccurrence> filteredServiceOccurrencesByVehicle = new ArrayList<VehicleServiceOccurrence>();
		
		Iterator<VehicleServiceOccurrence> serviceOccurrenceIterator = contentProvider.iterator();
		while (serviceOccurrenceIterator.hasNext()) {
			VehicleServiceOccurrence serviceOccurrence = serviceOccurrenceIterator.next();
			
			if (serviceOccurrence.getVehicle().getId() == vehicle.getId()) {
				filteredServiceOccurrencesByVehicle.add(serviceOccurrence);
			}
		}
		
		return filteredServiceOccurrencesByVehicle;
	}
	
}