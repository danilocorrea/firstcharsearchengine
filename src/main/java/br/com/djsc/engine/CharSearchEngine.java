package br.com.djsc.engine;

import br.com.djsc.stream.Stream;

public final class CharSearchEngine {

	public static char firstChar(Stream input) throws CharNotFoundException {
		LetterComposition lc = new LetterComposition();
		Letter previous = new LetterImpl((char) 0x00);
		while (input.hasNext()) {
			Letter current = new LetterImpl(previous, input.getNext());
			if (current.isVowel()) {
				lc.addOrUpdateRecorrence(current);
			}
			previous = current;
		}
		return lc.findFirstCharBeforeConsonantWithoutRecorrences();
	}
}
