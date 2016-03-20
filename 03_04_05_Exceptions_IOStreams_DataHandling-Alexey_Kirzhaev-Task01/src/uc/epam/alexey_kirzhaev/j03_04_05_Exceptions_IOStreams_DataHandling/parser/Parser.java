package uc.epam.alexey_kirzhaev.j03_04_05_Exceptions_IOStreams_DataHandling.parser;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import uc.epam.alexey_kirzhaev.j03_04_05_Exceptions_IOStreams_DataHandling.components.CompElements;
import uc.epam.alexey_kirzhaev.j03_04_05_Exceptions_IOStreams_DataHandling.components.Component;
import uc.epam.alexey_kirzhaev.j03_04_05_Exceptions_IOStreams_DataHandling.components.Part;
import uc.epam.alexey_kirzhaev.j03_04_05_Exceptions_IOStreams_DataHandling.components.Word;
import uc.epam.alexey_kirzhaev.j03_04_05_Exceptions_IOStreams_DataHandling.resource_bundle.PropertyManager;

public class Parser {
		private PropertyManager bundle;
		private StringBuilder sb = new StringBuilder();
		
		public Parser() {
			File f = new File("/Users/Franky_rus/Documents/Eclipse/lab3/resource/original/book.txt");
			bundle = new PropertyManager();
			try {
				BufferedReader br = new BufferedReader(new FileReader(f));
				String line = br.readLine();
				while (line != null) {
					sb.append(line);
					sb.append(System.lineSeparator());
					line = br.readLine();
				}
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		public String getText() {
			return sb.toString();
		}
		
		public Component textParsing(String text) {
			Part textPart = new Part();
			String paragraphPattern = bundle.getValue("paragraph_pattern");
			String[] paragraph = (text.toString().split(paragraphPattern));
			if (paragraph.length > 0) {
				for (int i = 0; i < paragraph.length; i++) {
					Part paragraphPart = (Part) paragraphParsing(paragraph[i]);
					paragraphPart.setAttachment(CompElements.PARAGRAPH);
					textPart.add(paragraphPart);
		
				}
			}
			return textPart;
		}
		
		private Component paragraphParsing(String text) {
			String sentencePattern = bundle.getValue("sentence_pattern");
			String[] sentences = text.split(sentencePattern);
			Part sentencePart = new Part();
			sentencePart.setAttachment(CompElements.SENTENCE);
			if (sentences.length > 0) {
				for (int i = 0; i < sentences.length; i++) {
					Part wordPart = (Part) wordParsing(sentences[i]);
					wordPart.setAttachment(CompElements.SENTENCE);
					sentencePart.add(wordPart);
				}
			}
			return sentencePart;
		}
		
		private Component wordParsing(String text) {
			Part wordPart = new Part();
			String wordPattern = bundle.getValue("word_pattern");
			String punctPattern = bundle.getValue("punct_pattern");
			Pattern pWord = Pattern.compile(wordPattern);
			Pattern pPunct = Pattern.compile(punctPattern);
			Matcher mWord = pWord.matcher(text);
			while (mWord.find()) {
				Word word = new Word(mWord.group());
				Matcher mPunct = pPunct.matcher(mWord.group());
				if (mPunct.find()) {
					word.setPunctBool(true);
				} else {
					word.setPunctBool(false);
				}
				wordPart.add(word);
			}
			return wordPart;
		}
		
	}
