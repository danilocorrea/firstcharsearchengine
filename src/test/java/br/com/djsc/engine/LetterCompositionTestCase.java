package br.com.djsc.engine;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class LetterCompositionTestCase {

	@Test
	public void testAddOrUpdateRecorrence() {
		Letter current = Mockito.mock(Letter.class);

		LetterComposition lc = new LetterComposition();

		lc.addOrUpdateRecorrence(current);

		Mockito.verify(current, Mockito.never()).addRecorrence();
	}

	@Test
	public void testAddOrUpdateRecorrence_2() {
		Letter l1 = Mockito.mock(Letter.class);

		LetterComposition lc = new LetterComposition();

		lc.addOrUpdateRecorrence(l1);
		Mockito.verify(l1, Mockito.never()).addRecorrence();

		lc.addOrUpdateRecorrence(l1);
		Mockito.verify(l1, Mockito.atLeastOnce()).addRecorrence();

		lc.addOrUpdateRecorrence(l1);
		Mockito.verify(l1, Mockito.atLeast(2)).addRecorrence();
	}

	@Test
	public void testfindFirstCharBeforeConsonantWithoutRecorrences() throws CharNotFoundException {
		char expected = 'ó';

		Letter l1 = Mockito.mock(Letter.class);
		Letter l2 = Mockito.mock(Letter.class);

		Mockito.when(l1.getPrevious()).thenReturn(l2);
		Mockito.when(l2.isConsonant()).thenReturn(true);
		Mockito.when(l1.getRecurrences()).thenReturn(1);
		Mockito.when(l1.getChar()).thenReturn('ó');

		LetterComposition lc = new LetterComposition();
		lc.addOrUpdateRecorrence(l1);

		char ret = lc.findFirstCharBeforeConsonantWithoutRecorrences();

		Assert.assertEquals(expected, ret);
	}

	@Test(expected = CharNotFoundException.class)
	public void testfindFirstCharBeforeConsonantWithoutRecorrences_2() throws CharNotFoundException {		
		Letter l1 = Mockito.mock(Letter.class);
		Letter l2 = Mockito.mock(Letter.class);

		Mockito.when(l1.getPrevious()).thenReturn(l2);
		Mockito.when(l2.isConsonant()).thenReturn(true);
		Mockito.when(l1.getRecurrences()).thenReturn(2);
		Mockito.when(l1.getChar()).thenReturn('E');

		LetterComposition lc = new LetterComposition();
		lc.addOrUpdateRecorrence(l1);

		lc.findFirstCharBeforeConsonantWithoutRecorrences();
	}

}
