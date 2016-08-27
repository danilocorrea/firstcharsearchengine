package br.com.djsc.engine;

import java.text.Normalizer;
import java.util.regex.Pattern;

public class LetterImpl implements Letter {

	private static final Pattern PATTERN = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");

	private Letter previous;
	private char current;
	private String parsed = "";
	private int recurrence;

	private String removeAccentuation(char c) {
		String nfdNormalizedString = Normalizer.normalize(String.valueOf(c), Normalizer.Form.NFD);
		return PATTERN.matcher(nfdNormalizedString).replaceAll("");
	}

	public char getChar() {
		return current;
	}

	public boolean isVowel() {
		return parsed.matches("[aeiou]");
	}

	public boolean isConsonant() {
		return parsed.matches("[bcdfghjklmnpqrstvxwyz]");
	}

	public void addRecorrence() {
		recurrence++;
	}

	public int getRecurrences() {
		return recurrence;
	}

	@Override
	public Letter getPrevious() {
		return previous;
	}

	@Override
	public boolean equals(Object obj) {
		return obj instanceof LetterImpl && ((LetterImpl) obj).parsed.equals(parsed);
	}

	public LetterImpl(char current) {
		this(null, current);
	}

	public LetterImpl(Letter previous, char current) {
		this.current = current;
		this.previous = previous;
		this.parsed = removeAccentuation(current).toLowerCase();
		this.recurrence++;
	}

}
