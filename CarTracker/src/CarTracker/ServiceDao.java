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
		
		Service s1 = new Service("0");
		s1.setName("Oil Change");
		s1.setAvailableOnDiesel(true);
		s1.setAvailableOnElectric(false);
		s1.setAvailableOnGasoline(true);
		
		contentProvider.put("0", s1);
		
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
