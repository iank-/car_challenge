package CarTracker;

import java.util.ArrayList;
import java.util.HashMap;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Vehicle {
	
	protected String id;
	
	protected String make;
	protected String model;
	protected int year;
	protected int odometerReading;
	
	protected enum VehicleType {
		ELECTRIC,
		GASOLINE,
		DIESEL;
	}
	
	private VehicleType vehicleType;
	
	protected static ArrayList<HashMap<String, String>> maintenanceTasks;
	
	public Vehicle() {
		
	}
	
	public Vehicle(String id) {
		this.id = id;
	}
	
	public String getId() {
		return this.id;
	}
	
	public String getMake() {
		return this.make;
	}
	
	public String getModel() {
		return this.model;
	}
	
	public int getYear() {
		return this.year;
	}
	
	public int getOdometerReading() {
		return this.odometerReading;
	}
	
	public void setId(String id) {
		this.id = id;
	}	
	
	public void setMake(String make) {
		this.make = make;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	
	public void setOdometerReading(int odometerReading) {
		this.odometerReading = odometerReading;
	}

	public VehicleType getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
	}

	
}
