import java.util.Scanner;

public class Calculator {
	public static void main(String[] args) {
		Calculator app = new Calculator();
		app.startCalculator();
	}

	public void startCalculator() {
		Scanner input = new Scanner(System.in);
		String symbol;
		do {
			System.out.println("Input two different numbers");
			float a = input.nextFloat();
			float b = input.nextFloat();
			input.nextLine();
			System.out.println("Input +, -, * or / to view result, exit to leave program");

			System.console().flush();
			symbol = input.nextLine();
			double output = operator.getType(symbol).calculate(a, b);
			System.out.println(output);
		} while (!symbol.equals("exit"));
		
		input.close();
	}
}