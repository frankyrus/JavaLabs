package Devices;

import Devices.Device;
import java.util.ArrayList;
import java.util.Scanner;

public class Search {
	public void searchEfficiency(ArrayList<Device> device) {
		Scanner input = new Scanner(System.in);
		System.out.println("Input efficiency to search from: ");
		float searchFrom = 0;
		float searchTo = 0;
		try {
			searchFrom = input.nextFloat();
			System.out.println("Input efficiency to search to: ");
			searchTo = input.nextFloat();
		} catch (java.util.InputMismatchException e) {
			System.out.println("Input error: " + e);
		}
		for (Device o : device) {
			if ((o.getEfficiency() > searchFrom) && (o.getEfficiency() < searchTo)) {
				System.out.println(o.toString());
			}
		}

		input.close();

	}

}
