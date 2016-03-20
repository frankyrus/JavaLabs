
public abstract class Freighter {
	private double pricePerHour;
	private String driverName;
	private double speed;
	/**
	 * @param pricePerHour
	 * @param driverName
	 * @param speed
	 * @param capacity
	 */
	public Freighter(double pricePerHour, String driverName, double speed, double capacity) {
		super();
		this.pricePerHour = pricePerHour;
		this.driverName = driverName;
		this.speed = speed;
		this.capacity = capacity;
	}

	private double capacity;

	public double getPricePerHour() {
		return pricePerHour;
	}

	public void setPricePerHour(double pricePerHour) {
		this.pricePerHour = pricePerHour;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public double getCapacity() {
		return capacity;
	}

	public void setCapacity(double capacity) {
		this.capacity = capacity;
	}
	
	public double getPrice(double distance) {
	return (getTime(distance))*pricePerHour;
	}
	
	public double getTime(double distance) {
		return (distance/speed);
	}
}
