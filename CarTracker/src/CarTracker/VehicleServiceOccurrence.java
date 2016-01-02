package CarTracker;

import CarTracker.Vehicle.VehicleType;

public class VehicleServiceOccurrence {

	private Vehicle vehicle;
	private Service service;
	private int odometerReading;
	
	public VehicleServiceOccurrence(Vehicle vehicle, Service service, int odometerReading) throws ServiceNotCompatibleException {
		if (vehicle.getVehicleType() == VehicleType.ELECTRIC && !service.isAvailableOnElectricVehicles()) {
			throw new ServiceNotCompatibleException("Service " + service.getName() + " is not compatible with electric vehicle " + vehicle.getId() + "!");
		}
		if (vehicle.getVehicleType() == VehicleType.DIESEL && !service.isAvailableOnDieselVehicles()) {
			throw new ServiceNotCompatibleException("Service " + service.getName() + " is not compatible with diesel vehicle " + vehicle.getId() + "!");
		}
		if (vehicle.getVehicleType() == VehicleType.GASOLINE && !service.isAvailableOnGasolineVehicles()) {
			throw new ServiceNotCompatibleException("Service " + service.getName() + " is not compatible with gasoline vehicle " + vehicle.getId() + "!");
		}
		
		this.service = service;
		this.vehicle = vehicle;
		this.odometerReading = odometerReading;
	}
	
	public Vehicle getVehicle() {
		return this.vehicle;
	}
	
	public Service getService() {
		return this.service;
	}
	
	public int getOdometerReading() {
		return this.odometerReading;
	} 
	
}
