package br.com.djsc.engine;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.mockito.Mockito;

import br.com.djsc.stream.Stream;
import br.com.djsc.stream.StreamImpl;

public class StreamImplTestCase {

	@Test(expected = IllegalArgumentException.class)
	public void testConstructor() {
		Stream s = new StreamImpl(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testConstructor_2() {
		Stream s = new StreamImpl("");
	}

	@Test
	public void testGetNext() {
		String expected = "abc";

		Stream s = new StreamImpl("abc");
		for (int i = 0; i < expected.length(); i++) {
			assertEquals(expected.charAt(i), s.getNext());
		}
	}

	@Test
	public void testHasNext() {				
		Stream s = new StreamImpl("abc");
		Stream spy =Mockito.spy(s);
		
		while(spy.hasNext())
			spy.getNext();
		
		Mockito.verify(spy, Mockito.atLeast(3)).hasNext();
	}

}
