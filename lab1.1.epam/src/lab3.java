import java.util.Scanner;

public class lab3 {
	public static void main(String[] args) {
		lab3 app = new lab3();
		app.startLab3();
	}

	public void startLab3() {
		Scanner input = new Scanner(System.in);
		do {
			System.out.println("Input two different numbers");
			float a = input.nextFloat();
			float b = input.nextFloat();
			input.nextLine();
			System.out.println("Input +, -, * or / to view result, exit to leave program");
			String symbol = input.nextLine();
			if (symbol.equals("+")) {
				System.out.println(sumLab3(a, b));
			} else if (symbol.equals("-")) {
				System.out.println(diffLab3(a, b));
			} else if (symbol.equals("*")) {
				System.out.println(compLab3(a, b));
			} else if (symbol.equals("/")) {
				System.out.println(divLab3(a, b));
			} else if (symbol.equals("exit")) {
				System.exit(0);
			}
		} while (true);
	}

	public float sumLab3(float a, float b) {
		return a + b;
	}

	public float diffLab3(float a, float b) {
		return a - b;
	}

	public float compLab3(float a, float b) {
		return a * b;
	}

	public float divLab3(float a, float b) {
		return a / b;
	}
}