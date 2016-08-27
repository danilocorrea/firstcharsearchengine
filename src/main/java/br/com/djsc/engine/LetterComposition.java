package br.com.djsc.engine;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LetterComposition {

	private List<Letter> letters = new ArrayList<Letter>();

	public void addOrUpdateRecorrence(Letter letter) {
		if (letters.contains(letter))
			letters.get(letters.indexOf(letter)).addRecorrence();
		else
			letters.add(letter);
	}

	public char findFirstCharBeforeConsonantWithoutRecorrences() throws CharNotFoundException {
		Optional<Letter> first = letters.stream()
				.filter(d -> d.getPrevious() != null && d.getPrevious().isConsonant() && d.getRecurrences() == 1)
				.findFirst();
		if (first.isPresent())
			return first.get().getChar();
		else
			throw new CharNotFoundException("Nenhuma vogal foi encontrada sem repetição após consoante.");
	}
}
