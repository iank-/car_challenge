package CarTracker;

import java.util.ArrayList;
import java.util.Iterator;

import CarTracker.Vehicle;

public enum ServiceDao {
	instance;
	
	private ArrayList<Service> contentProvider = new ArrayList<Service>();
	
	private ServiceDao() {
		
	}
	
	public ArrayList<Service> getModel() {
		return contentProvider;
	}
	
	public Service getServiceWithName(String name) {
		
		Iterator<Service> serviceIterator = contentProvider.iterator();
		while (serviceIterator.hasNext()) {
			Service service = serviceIterator.next();
			
			if (service.getName() == name) {
				return service;
			}
		}
		return null;
	}
	
}