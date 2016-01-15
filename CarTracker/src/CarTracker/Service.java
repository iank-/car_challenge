package CarTracker;

import java.util.ArrayList;
import java.util.HashMap;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Service {
	
	private String id;
	
	private String name;
	private boolean availableOnElectric;
	private boolean availableOnDiesel;
	private boolean availableOnGasoline;
	
	
	public Service() {
		
	}
	
	public Service(String id) {
		this.id = id;
	}
	
	public String getId() {
		return this.id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isAvailableOnElectric() {
		return availableOnElectric;
	}

	public void setAvailableOnElectric(boolean availableOnElectric) {
		this.availableOnElectric = availableOnElectric;
	}

	public boolean isAvailableOnDiesel() {
		return availableOnDiesel;
	}

	public void setAvailableOnDiesel(boolean availableOnDiesel) {
		this.availableOnDiesel = availableOnDiesel;
	}

	public boolean isAvailableOnGasoline() {
		return availableOnGasoline;
	}

	public void setAvailableOnGasoline(boolean availableOnGasoline) {
		this.availableOnGasoline = availableOnGasoline;
	}
	
	
	
}
