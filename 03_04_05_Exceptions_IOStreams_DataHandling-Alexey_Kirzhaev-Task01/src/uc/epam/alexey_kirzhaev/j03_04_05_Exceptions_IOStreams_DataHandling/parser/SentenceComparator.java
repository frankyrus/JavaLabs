package uc.epam.alexey_kirzhaev.j03_04_05_Exceptions_IOStreams_DataHandling.parser;

import java.util.Comparator;

import uc.epam.alexey_kirzhaev.j03_04_05_Exceptions_IOStreams_DataHandling.components.CompElements;
import uc.epam.alexey_kirzhaev.j03_04_05_Exceptions_IOStreams_DataHandling.components.Component;
import uc.epam.alexey_kirzhaev.j03_04_05_Exceptions_IOStreams_DataHandling.components.Part;
import uc.epam.alexey_kirzhaev.j03_04_05_Exceptions_IOStreams_DataHandling.components.Word;

public class SentenceComparator implements Comparator<Component> {
	private int countWords(Component sentence) {
		int count = 0;
		if (sentence instanceof Part) {
			if (((Part) sentence).getAttachment().equals(CompElements.SENTENCE)) {
				for (Component w : ((Part) sentence).getItems()) {
					if (w instanceof Word) {
						if (((Word) w).isPunctBool() != true) {
							count++;
						}
					}
				}
			}
		}
		return count;
	}

	@Override
	public int compare(Component c, Component cc) {
		if (countWords(c) < countWords(cc)) {
			return -1;
		} else if (countWords(c) == countWords(cc)) {
			return 0;
		} else {
			return 1;
		}
	}

}
