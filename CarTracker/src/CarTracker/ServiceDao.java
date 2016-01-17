package CarTracker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import CarTracker.Vehicle;

public enum ServiceDao {
	instance;
	
	private Map<String, Service> contentProvider = new HashMap<>();
	
	private ServiceDao() {
		
		if (this.contentProvider == null) {
			this.contentProvider = new HashMap<>();
		}
		
	}
	
	public Service getServiceForName(String name) {
		List<Service> services = new ArrayList<Service>();
	    services.addAll(this.getModel().values());
	    for (Service s : services) {
	    	if (s.getName().equalsIgnoreCase(name)) {
	    		return s;
	    	}
	    }
	    
	    return null;
	}
	
	public Map<String, Service> getModel() {
		return contentProvider;
	}
	
	public Service getServiceForId(String id) {
		return contentProvider.get(id);
	}
	
}
