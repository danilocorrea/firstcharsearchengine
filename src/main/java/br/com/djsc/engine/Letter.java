package br.com.djsc.engine;

public interface Letter {

	Letter getPrevious();
	
	boolean isVowel();

	boolean isConsonant();

	void addRecorrence();

	int getRecurrences();

	char getChar();

}
