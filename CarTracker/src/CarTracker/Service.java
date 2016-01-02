package CarTracker;

public class Service {
	private String name;
	private int avgCost;
	private boolean isAvailableOnAllVehicles;
	private boolean isAvailableOnGasolineVehicles;
	private boolean isAvailableOnElectricVehicles;
	private boolean isAvailableOnDieselVehicles;
	
	public Service(String name, int avgCost, boolean isAvailableOnAllVehicles) {
		this(name, avgCost, true, true, true);
	}
	
	public Service(String name, int avgCost, boolean isAvailableOnGasolineVehicles, 
			boolean isAvailableOnElectricVehicles, boolean isAvailableOnDieselVehicles) {
		
		this.name = name;
		this.avgCost = avgCost;
		this.isAvailableOnGasolineVehicles = isAvailableOnGasolineVehicles;
		this.isAvailableOnElectricVehicles = isAvailableOnElectricVehicles;
		this.isAvailableOnDieselVehicles = isAvailableOnDieselVehicles;
		
		if (isAvailableOnGasolineVehicles
				&& isAvailableOnElectricVehicles
				&& isAvailableOnDieselVehicles) {
			
			this.isAvailableOnAllVehicles = true;
		} else {
			this.isAvailableOnAllVehicles = false;
		}
			
	}

	public String getName() {
		return name;
	}

	public int getAvgCost() {
		return avgCost;
	}

	public boolean isAvailableOnGasolineVehicles() {
		return isAvailableOnGasolineVehicles;
	}
	
	public boolean isAvailableOnElectricVehicles() {
		return isAvailableOnElectricVehicles;
	}
	
	public boolean isAvailableOnDieselVehicles() {
		return isAvailableOnDieselVehicles;
	}
	
}
