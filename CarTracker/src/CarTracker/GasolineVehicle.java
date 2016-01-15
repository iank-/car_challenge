package CarTracker;

import CarTracker.Vehicle.VehicleType;

public class GasolineVehicle extends Vehicle {

	public GasolineVehicle() {
		this.setVehicleType(VehicleType.GASOLINE);
	}
	
	public GasolineVehicle(String id) {
		this.setVehicleType(VehicleType.GASOLINE);
		this.id = id;
	}
}
