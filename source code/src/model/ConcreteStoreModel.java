package model;

public class ConcreteStoreModel {
	private String name;
	private String packingType;
	private double cost;

	public ConcreteStoreModel(String name, String packingType, double cost) {
		this.name = name;
		this.packingType = packingType;
		this.cost = cost;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPackingType() {
		return packingType;
	}

	public void setPackingType(String packingType) {
		this.packingType = packingType;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}
}
