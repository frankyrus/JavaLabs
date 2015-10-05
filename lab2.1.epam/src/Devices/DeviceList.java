package Devices;

public class DeviceList {
	public class TV extends Device implements Socket {
		private int diagonal;

		public TV(int power, String color, float efficiency, int weight, boolean status, int diagonal) {
			super(power, color, efficiency, weight, status);
			this.diagonal = diagonal;
		}

		public int getDiagonal() {
			return diagonal;
		}

		public void setDiagonal(int diagonal) {
			this.diagonal = diagonal;
		}

		@Override
		public String toString() {
			String info = String.format("%s %7s %.2g %s %b %s\n", getPower(), getColor(), getEfficiency(), getWeight(),
					isStatus(), getDiagonal());

			return info;
		}

		@Override
		public int compareTo(Device o) {

			int compareage = ((Device) o).getWeight();
			return this.getWeight() - compareage;
		}
	}

	public class Laptop extends Device implements Socket {
		private int batteryCapacity;

		public int getBatteryCapacity() {
			return batteryCapacity;
		}

		public void setBatteryCapacity(int batеeryCapacity) {
			this.batteryCapacity = batеeryCapacity;
		}

		public Laptop(int power, String color, float efficiency, int weight, boolean status, int batеeryCapacity) {
			super(power, color, efficiency, weight, status);
			this.batteryCapacity = batеeryCapacity;
		}

		@Override
		public String toString() {
			String info = String.format("%s %7s %.2g %s %b %s\n", getPower(), getColor(), getEfficiency(), getWeight(),
					isStatus(), getBatteryCapacity());

			return info;
		}

		@Override
		public int compareTo(Device o) {
			int compareage = ((Device) o).getWeight();
			return this.getWeight() - compareage;
		}

	}

	public class Refrigerator extends Device implements Socket {
		private int capacity;

		public int getCapacity() {
			return capacity;
		}

		public void setCapacity(int capacity) {
			this.capacity = capacity;
		}

		public Refrigerator(int power, String color, float efficiency, int weight, boolean status, int capacity) {
			super(power, color, efficiency, weight, status);
			this.capacity = capacity;
		}

		@Override
		public String toString() {
			String info = String.format("%s %7s %.2g %s %b %s\n", getPower(), getColor(), getEfficiency(), getWeight(),
					isStatus(), getCapacity());

			return info;
		}

		@Override
		public int compareTo(Device o) {
			int compareage = ((Device) o).getWeight();
			return this.getWeight() - compareage;
		}

	}

	public class VaсuumCleaner extends Device implements Socket {
		private int powerOfCleaning;

		public int getPowerOfCleaning() {
			return powerOfCleaning;
		}

		public void setPowerOfCleaning(int powerOfCleaning) {
			this.powerOfCleaning = powerOfCleaning;
		}

		public VaсuumCleaner(int power, String color, float efficiency, int weight, boolean status,
				int powerOfCleaning) {
			super(power, color, efficiency, weight, status);
			this.powerOfCleaning = powerOfCleaning;
		}

		@Override
		public String toString() {
			String info = String.format("%s %7s %.2g %s %b %s\n", getPower(), getColor(), getEfficiency(), getWeight(),
					isStatus(), getPowerOfCleaning());

			return info;
		}

		@Override
		public int compareTo(Device o) {
			int compareage = ((Device) o).getWeight();
			return this.getWeight() - compareage;
		}
	}

	public class WashingMachine extends Device implements Socket {
		private int volume;

		public int getVolume() {
			return volume;
		}

		public void setVolume(int volume) {
			this.volume = volume;
		}

		public WashingMachine(int power, String color, float efficiency, int weight, boolean status, int volume) {
			super(power, color, efficiency, weight, status);
			this.volume = volume;
		}

		@Override
		public String toString() {
			String info = String.format("%s %7s %.2g %s %b %s\n", getPower(), getColor(), getEfficiency(), getWeight(),
					isStatus(), getVolume());

			return info;
		}

		@Override
		public int compareTo(Device o) {
			int compareage = ((Device) o).getWeight();
			return this.getWeight() - compareage;
		}

	}
}
