import java.util.ArrayList;
import java.util.Collections;

import Devices.Device;
import Devices.DeviceList;
import Devices.Search;

public class HomeAppliance {
	public static void main(String[] args) {
		HomeAppliance app = new HomeAppliance();
		app.startInit();
	}

	public void startInit() {
		DeviceList d = new DeviceList();

		DeviceList.TV tv = d.new TV(80, "black", 0.77f, 14, true, 32);

		DeviceList.Laptop laptop = d.new Laptop(45, "silver", 0.65f, 2, true, 7100);

		DeviceList.Refrigerator refrigerator = d.new Refrigerator(150, "white", 0.80f, 45, true, 200);

		DeviceList.VaсuumCleaner cleaner = d.new VaсuumCleaner(1800, "brown", 0.58f, 3, true, 580);

		DeviceList.WashingMachine washingMachine = d.new WashingMachine(1000, "white", 0.70f, 40, true, 8);

		ArrayList<Device> devices = new ArrayList<Device>();

		devices.add(tv);
		devices.add(laptop);
		devices.add(refrigerator);
		devices.add(cleaner);
		devices.add(washingMachine);
		int sum = 0;
		for (Device device : devices) {
			sum += device.getPower();
		}
		System.out.println(sum);

		Collections.sort(devices);

		System.out.println("Device list after sorting:");

		for (Device device : devices) {
			System.out.println(device.toString());
		}

		Search sr = new Search();
		sr.searchEfficiency(devices);
	}
}
