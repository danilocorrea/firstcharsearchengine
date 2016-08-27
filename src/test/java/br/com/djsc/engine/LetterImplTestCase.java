package br.com.djsc.engine;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class LetterImplTestCase {

	@Test
	public void testGetChar() {
		Letter l = new LetterImpl('a');
		assertEquals('a', l.getChar());
	}

	@Test
	public void testGetChar_2() {
		Letter l = new LetterImpl('Ú');
		assertEquals('Ú', l.getChar());
	}

	@Test
	public void testIsVowel() {
		Letter l = new LetterImpl('a');
		assertEquals(true, l.isVowel());
	}

	@Test
	public void testIsVowel_2() {
		Letter l = new LetterImpl('Í');
		assertEquals(true, l.isVowel());
	}

	@Test
	public void testIsConsonat() {
		Letter l = new LetterImpl('b');
		assertEquals(true, l.isConsonant());
	}

	@Test
	public void testIsConsonat_2() {
		Letter l = new LetterImpl('Ÿ');
		assertEquals(true, l.isConsonant());
	}

	@Test
	public void testGetRecorreces() {
		Letter l = new LetterImpl('j');
		assertEquals(1, l.getRecurrences());
	}

	@Test
	public void testGetRecorreces_2() {
		Letter l = new LetterImpl('j');
		l.addRecorrence();
		assertEquals(2, l.getRecurrences());
	}

	@Test
	public void testEquals() {
		Letter l1 = new LetterImpl('K');
		Letter l2 = new LetterImpl('k');
		assertEquals(l1, l2);
	}

	@Test
	public void testEquals_2() {
		Letter l1 = new LetterImpl('á');
		Letter l2 = new LetterImpl('A');
		assertEquals(l1, l2);
	}

	@Test
	public void testEquals_3() {
		Letter l1 = new LetterImpl('ú');
		Letter l2 = new LetterImpl('Ü');
		assertEquals(l1, l2);
	}

	@Test
	public void testNotEquals() {
		Letter l1 = new LetterImpl('o');
		Letter l2 = new LetterImpl('P');
		assertNotEquals(l1, l2);
	}

	@Test
	public void testNotEquals_2() {
		Letter l1 = new LetterImpl('a');
		Letter l2 = new LetterImpl('e');
		assertNotEquals(l1, l2);
	}

	@Test
	public void testNotEquals_3() {
		Letter l1 = new LetterImpl('L');
		Letter l2 = new LetterImpl('d');
		assertNotEquals(l1, l2);
	}

	@Test
	public void testGetPrevious() {
		Letter l = new LetterImpl('o');
		assertNull(l.getPrevious());
	}

	@Test
	public void testGetPrevious_2() {
		Letter l = new LetterImpl(null, 'o');
		assertNull(l.getPrevious());
	}

	@Test
	public void testGetPrevious_3() {
		Letter l = new LetterImpl(new LetterImpl('r'), 'o');
		assertNotNull(l.getPrevious());
	}
}
