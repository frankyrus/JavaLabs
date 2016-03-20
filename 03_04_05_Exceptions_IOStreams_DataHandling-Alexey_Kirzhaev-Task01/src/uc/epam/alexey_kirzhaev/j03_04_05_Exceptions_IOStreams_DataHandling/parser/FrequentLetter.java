package uc.epam.alexey_kirzhaev.j03_04_05_Exceptions_IOStreams_DataHandling.parser;

public class FrequentLetter {
	public void searchLetter() {
		int[] l = new int[5];
		Parser p = new Parser();
		String text = p.getText();
		for (int i = 0; i < text.length(); i++) {
			switch (text.toLowerCase().charAt(i)) {
			case 'a': {
				l[0]++;
				break;
			}
			case 'e': {
				l[1]++;
				break;
			}
			case 'i': {
				l[2]++;
				break;
			}
			case 'u': {
				l[3]++;
				break;
			}
			case 'o': {
				l[4]++;
				break;
			}
			}
		}
		if (l[0] > l[1] && l[0] > l[2] && l[0] > l[3] && l[0] > l[4]) {
			System.out.println("'a' is the most frequent open letter");
		}
		if (l[1] > l[0] && l[1] > l[2] && l[1] > l[3] && l[1] > l[4]) {
			System.out.println("'e' is the most frequent open letter");
		}
		if (l[2] > l[0] && l[2] > l[1] && l[2] > l[3] && l[2] > l[4]) {
			System.out.println("'i' is the most frequent open letter");
		}
		if (l[3] > l[1] && l[3] > l[0] && l[3] > l[2] && l[0] > l[4]) {
			System.out.println("'u' is the most frequent open letter");
		}
		if (l[4] > l[0] && l[4] > l[1] && l[4] > l[2] && l[4] > l[3]) {
			System.out.println("'o' is the most frequent open letter");
		}
	}
}
