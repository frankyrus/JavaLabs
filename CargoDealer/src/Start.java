
public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Plane plane = new Plane(1200000, "Kamikadze", 900, 40000, 13000);
		Train train = new Train(1000000, "Gendalf", 120, 80000 * 13, 13);
		Car car = new Car(600, "Ahmed", 110, 5000, 3);

		System.out.println(
				"Price and time for the aircraft at 1300km: " + plane.getPrice(1300) + ", " + plane.getTime(1300));
		System.out.println(
				"Price and time for the train at 1300km: " + train.getPrice(1300) + ", " + train.getTime(1300));
		System.out.println("Price and time for the car at 1300km: " + car.getPrice(1300) + ", " + car.getTime(1300));
	}

}
