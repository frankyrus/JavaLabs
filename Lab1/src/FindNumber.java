import java.util.Scanner;

public class FindNumber {

	public static void main(String[] args) {
		FindNumber app = new FindNumber();
		app.start();
	}
	
	private void start() {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[100];
		System.out.println("Size of array?");
		int n = sc.nextInt();
		System.out.println("Input numbers:");
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
			}
		sc.close();
		for (int i = 0; i < n; i++)
		if ((arr[i] % 5 == 0) || (arr[i] % 10 == 0)) {
			System.out.println(arr[i] + " is a good number.");
		}
	}
}
