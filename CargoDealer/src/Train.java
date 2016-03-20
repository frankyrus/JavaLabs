
public final class Train extends Freighter {
	private int numberOfCarriage;

	public int getNumberOfCarriage() {
		return numberOfCarriage;
	}

	public void setNumberOfCarriage(int numberOfCarriage) {
		this.numberOfCarriage = numberOfCarriage;
	}

	/**
	 * @param pricePerHour
	 * @param driverName
	 * @param speed
	 * @param capacity
	 * @param numberOfCarriage
	 */
	public Train(double pricePerHour, String driverName, double speed, double capacity, int numberOfCarriage) {
		super(pricePerHour, driverName, speed, capacity);
		this.numberOfCarriage = numberOfCarriage;
	}
	
}
