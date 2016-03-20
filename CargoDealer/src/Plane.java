
public final class Plane extends Freighter {
	private double height;
	
	/**
	 * @param pricePerHour
	 * @param driverName
	 * @param speed
	 * @param capacity
	 * @param height
	 */
	public Plane(double pricePerHour, String driverName, double speed, double capacity, double height) {
		super(pricePerHour, driverName, speed, capacity);
		this.height = height;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}
	

}
