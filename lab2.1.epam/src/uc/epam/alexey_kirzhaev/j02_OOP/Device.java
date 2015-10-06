package uc.epam.alexey_kirzhaev.j02_OOP;

public abstract class Device implements Comparable<Device> {
	private int power;
	private String color;
	private float efficiency;
	private int weight;
	private boolean status;

	public Device(int power, String color, float efficiency, int weight, boolean status) {
		super();
		this.power = power;
		this.color = color;
		this.efficiency = efficiency;
		this.weight = weight;
		this.status = status;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public float getEfficiency() {
		return efficiency;
	}

	public void setEfficiency(float efficiency) {
		this.efficiency = efficiency;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

}
