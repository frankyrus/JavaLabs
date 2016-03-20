import java.util.Scanner;

public class ShortestLongestStrings {
	int index;

	public static void main(String[] args) {
		ShortestLongestStrings app = new ShortestLongestStrings();
		app.start();
	}

	public void start() {
		System.out.println("Input strings, then input exit end press Enter.");
		String[] arr = new String[100];

		inputLines(arr);

		String shortest = searchShortest(arr);
		String longest = searchLongest(arr);

		output(shortest, longest);
	}

	public int inputLines(String[] arr) {
		String buf;
		Scanner input = new Scanner(System.in);
		int i = 0;
		do {
			buf = input.nextLine();
			arr[i++] = buf;
		} while (!buf.equals("exit"));
		arr[--i] = null;
		index = i;
		input.close();
		return i;
	}

	public String searchShortest(String[] arr) {
		String shortest = null;
		int minLength = arr[0].length();
		for (int i = 0; i < index; i++) {
			if (minLength > arr[i].length()) {
				shortest = arr[i];
				minLength = arr[i].length();
			}
		}
		return shortest;
	}

	public String searchLongest(String[] arr) {
		String longest = null;
		int maxLength = arr[0].length();
		for (int i = 0; i < index; i++) {
			if (maxLength < arr[i].length()) {
				longest = arr[i];
				maxLength = arr[i].length();
			}
		}
		return longest;
	}

	public void output(String shortest, String longest) {
		String finalOut;
		finalOut = "The shortest string: " + shortest + "\n";

		if ((shortest.length() == 1) || (shortest.length() == 0)) {
			finalOut += shortest.length() + " symbol.\n";
		} else {
			finalOut += shortest.length() + " symbols.\n";
		}

		finalOut += "The longest string: " + longest + "\n";

		if ((longest.length() == 1) || (longest.length() == 0)) {
			finalOut += longest.length() + " symbol.";
		} else {
			finalOut += longest.length() + " symbols.";
		}
		System.out.println(finalOut);
	}
}