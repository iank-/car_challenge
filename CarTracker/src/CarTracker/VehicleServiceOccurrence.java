package CarTracker;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import CarTracker.Vehicle.VehicleType;


@XmlRootElement
public class VehicleServiceOccurrence {

	private String id;


	
	private int odometerReading;
	
	@XmlElement(name="vehicleId")
	private String vehicleId;
	
	@XmlElement(name="serviceName")
	private String serviceName;

	public VehicleServiceOccurrence() {
		
	}
	
	public VehicleServiceOccurrence(String id) {
		this.id = id;
	}
	

	public void setServiceAndVehicle(Vehicle v, Service s) throws ServiceNotCompatibleException {
		if (v.getVehicleType() == VehicleType.ELECTRIC && !s.isAvailableOnElectric()) {
			throw new ServiceNotCompatibleException("Service " + s.getName() + " is not compatible with electric vehicle " + v.getId() + "!");
		}
		if (v.getVehicleType() == VehicleType.DIESEL && !s.isAvailableOnDiesel()) {
			throw new ServiceNotCompatibleException("Service " + s.getName() + " is not compatible with diesel vehicle " + v.getId() + "!");
		}
		if (v.getVehicleType() == VehicleType.GASOLINE && !s.isAvailableOnGasoline()) {
			throw new ServiceNotCompatibleException("Service " + s.getName() + " is not compatible with gasoline vehicle " + v.getId() + "!");
		}
		
		this.vehicleId = v.getId();
		this.serviceName = s.getName();
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getId() {
		return this.id;
	}
	
	
	public int getOdometerReading() {
		return this.odometerReading;
	} 
	
	public void setOdometerReading(int odometerReading) {
		this.odometerReading = odometerReading;
	} 
	
	public String getVehicleId() {
		return vehicleId;
	}

	public String getServiceName() {
		return serviceName;
	}
	
}