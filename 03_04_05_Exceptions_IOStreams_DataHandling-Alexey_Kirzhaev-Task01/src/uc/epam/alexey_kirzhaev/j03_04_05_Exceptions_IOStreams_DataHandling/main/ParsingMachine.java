package uc.epam.alexey_kirzhaev.j03_04_05_Exceptions_IOStreams_DataHandling.main;

import java.io.*;

import uc.epam.alexey_kirzhaev.j03_04_05_Exceptions_IOStreams_DataHandling.components.Component;
import uc.epam.alexey_kirzhaev.j03_04_05_Exceptions_IOStreams_DataHandling.components.Part;
import uc.epam.alexey_kirzhaev.j03_04_05_Exceptions_IOStreams_DataHandling.parser.FrequentLetter;
import uc.epam.alexey_kirzhaev.j03_04_05_Exceptions_IOStreams_DataHandling.parser.Parser;
import uc.epam.alexey_kirzhaev.j03_04_05_Exceptions_IOStreams_DataHandling.parser.Task;

public class ParsingMachine {
	public static void main(String args[]) {
		ParsingMachine app = new ParsingMachine();
		app.startParser();

	}

	public void startParser() {
		Task task = new Task();
		backup();
		Parser parser = new Parser();
		Part textPart = (Part) parser.textParsing(parser.getText());
		System.out.println(textPart);
		Part outSentences = (Part) task.getSentenceList(textPart);
		printSortedList(outSentences);
		FrequentLetter fl = new FrequentLetter();
		fl.searchLetter();
	}

	public static void printSortedList(Part sentences) {
		System.out.println("Sorted strings");
		String firstString = "|";
		for (int k = 0; k < sentences.getItems().get(sentences.getItems().size()-1).toString().length(); k++) {
			firstString += "=";
		}
		firstString += "=====================|";
		String secondString = "|  №  |";
		for (int k = 0; k < (sentences.getItems().get(sentences.getItems().size()-1).toString().length()/2)-4; k++) {
			secondString = secondString + " ";
		}
		secondString += "Sentence";
		for (int k = 0; k < (sentences.getItems().get(sentences.getItems().size()-1).toString().length()/2)-4; k++) {
			secondString += " ";
		}
		secondString += "| Word`s Count |";
		String thirdString = "|=====+";
		for (int k = 0; k < sentences.getItems().get(sentences.getItems().size()-1).toString().length(); k++) {
			thirdString += "=";
		}
		thirdString += "+==============|";
		String  spaceString = "|=====+";
		for (int k = 0; k < sentences.getItems().get(sentences.getItems().size()-1).toString().length(); k++) {
			spaceString += "=";
		}
		spaceString += "+==============|";
		int i = 0;
		System.out.printf("%s\n%s\n%s\n", firstString, secondString, thirdString);
		for (Component s : sentences.getItems()) {
			String tempSpace = "";
			i++;
			for (int j = 0; j < (sentences.getItems().get(sentences.getItems().size()-1).toString().length()-s.toString().length())/2; j++) {
				tempSpace += " ";
			}
			System.out.print(String.format("|%d    |%s%s%s|             %d|\n%s\n", i, tempSpace, s.toString().trim(), tempSpace, s.toString().length(), spaceString));
		}
	}

	public void backup() {
		File f = new File("/Users/Franky_rus/Documents/Eclipse/lab3/resource/backup/book.bak");
		FileWriter fw = null;
		try {
			if (!f.exists()) {
				f.createNewFile();
			}
			fw = new FileWriter(f, false);
		} catch (IOException e) {
			System.err.println("Ошибка открытия потока " + e);
			System.exit(1);
		}
		BufferedWriter bw = new BufferedWriter(fw);
		PrintWriter pw = new PrintWriter(bw);
		try {
			BufferedReader brr = new BufferedReader(
					new FileReader("/Users/Franky_rus/Documents/Eclipse/lab3/resource/original/book.txt"));
			String tmp = "";
			while ((tmp = brr.readLine()) != null) {
				String[] s = tmp.split("\\n");
				for (String res : s)
					pw.println(res);
			}
			brr.close();
			pw.close();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
