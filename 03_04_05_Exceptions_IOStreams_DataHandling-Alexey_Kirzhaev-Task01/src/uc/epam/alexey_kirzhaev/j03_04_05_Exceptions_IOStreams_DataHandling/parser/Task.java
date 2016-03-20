package uc.epam.alexey_kirzhaev.j03_04_05_Exceptions_IOStreams_DataHandling.parser;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import uc.epam.alexey_kirzhaev.j03_04_05_Exceptions_IOStreams_DataHandling.components.CompElements;
import uc.epam.alexey_kirzhaev.j03_04_05_Exceptions_IOStreams_DataHandling.components.Component;
import uc.epam.alexey_kirzhaev.j03_04_05_Exceptions_IOStreams_DataHandling.components.Part;
import uc.epam.alexey_kirzhaev.j03_04_05_Exceptions_IOStreams_DataHandling.components.Word;

public class Task {
	private Part sentences = new Part();
	private ArrayList<Word> words = new ArrayList<Word>();

	private Component getSentenceOnly(Component text) {
		for (Component comp : text.getItems()) {
			if (comp instanceof Component) {
				if (((Part) comp).getAttachment().equals(CompElements.SENTENCE)) {
					Part pack = new Part();
					pack.setAttachment(((Part) comp).getAttachment());
					pack.setItems(((Part) comp).getItems());
					sentences.add(pack);
				} else {
					getSentenceOnly(comp);
				}
			}
		}
		return sentences;
	}

	private boolean isThisWord(List<Word> word, Word compWord) {
		for (Word w : word) {
			if (w.getData().equals(compWord.getData())) {
				return true;
			}
		}
		return false;
	}

	private boolean isThisSentence(Component sentence) {
		if (sentence instanceof Part) {
			if (((Part) sentence).getAttachment().equals(CompElements.SENTENCE)) {
				for (Component w : ((Part) sentence).getItems()) {
					Word wr = (Word) w;
					if (wr.isPunctBool()) {
						if (wr.getData().equals("?")) {
							return true;
						}
					}
				}
			}
		}
		return false;
	}

	public Component getSentenceList(Component text) {
		Component sentences = (Component) getSentenceOnly(text);
		Comparator<Component> comp = new SentenceComparator();
		Collections.sort(sentences.getItems(), comp);
		return sentences;
	}

	public ArrayList<Word> getFromRequest(Component text, int wordLength) {
		for (Component sentence : sentences.getItems()) {
			if (((Part) sentence).getAttachment().equals(CompElements.SENTENCE)) {
				if (isThisSentence(sentence)) {
					Part pack = (Part) sentence;
					for (Component w : pack.getItems()) {
						Word wr = (Word) w;
						if ((wr.getData().length() > 0) && (wr.getData().length() == wordLength)) {
							Word gWord = new Word(wr.getData().toLowerCase());
							if (!isThisWord(words, gWord)) {
								words.add(gWord);
							}
						}
					}
				}
			} else
				getFromRequest(sentence, wordLength);
		}
		return words;
	}
}