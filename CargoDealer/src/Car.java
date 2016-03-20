
public final class Car extends Freighter {
	private double axleLoad;

	public double getAxleLoad() {
		return axleLoad;
	}

	public void setAxleLoad(double axleLoad) {
		this.axleLoad = axleLoad;
	}

	/**
	 * @param pricePerHour
	 * @param driverName
	 * @param speed
	 * @param capacity
	 * @param axleLoad
	 */
	public Car(double pricePerHour, String driverName, double speed, double capacity, double axleLoad) {
		super(pricePerHour, driverName, speed, capacity);
		this.axleLoad = axleLoad;
	}
}
