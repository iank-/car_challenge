package CarTracker;

import CarTracker.Vehicle.VehicleType;

public class DieselVehicle extends Vehicle {
	public DieselVehicle() {
		this.setVehicleType(VehicleType.DIESEL);
	}
	
	public DieselVehicle(String id) {
		this.setVehicleType(VehicleType.DIESEL);
		this.id = id;
	}
}
