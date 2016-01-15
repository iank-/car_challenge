package CarTracker;

public class ElectricVehicle extends Vehicle {

	public ElectricVehicle() {
		this.setVehicleType(VehicleType.ELECTRIC);
	}
	
	public ElectricVehicle(String id) {
		this.setVehicleType(VehicleType.ELECTRIC);
		this.id = id;
	}
}
