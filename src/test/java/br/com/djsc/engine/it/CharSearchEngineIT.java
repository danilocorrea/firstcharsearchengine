package br.com.djsc.engine.it;

import br.com.djsc.engine.CharSearchEngine;
import br.com.djsc.stream.StreamImpl;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class CharSearchEngineIT extends TestCase {

	public CharSearchEngineIT(String testName) {
		super(testName);
	}

	public static Test suite() {
		return new TestSuite(CharSearchEngineIT.class);
	}

	public void testApp() {
		assertTrue(true);
	}

	public void testFirstChar_1() {
		String data = "abcdef";
		StreamImpl stream = new StreamImpl(data);
		try {
			char a = CharSearchEngine.firstChar(stream);
			assertEquals('e', a);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void testFirstChar_2() {
		String data = "aABABacfe";
		StreamImpl stream = new StreamImpl(data);
		try {
			char a = CharSearchEngine.firstChar(stream);
			assertEquals('e', a);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void testFirstChar_3() {
		String data = " aAB 	A Bacf e876jsYtIpol768";
		StreamImpl stream = new StreamImpl(data);
		try {
			char c = CharSearchEngine.firstChar(stream);
			assertEquals('I', c);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void testFirstChar_4() {
		String data = "está certo?";
		StreamImpl stream = new StreamImpl(data);
		try {
			char c = CharSearchEngine.firstChar(stream);
			assertEquals('á', c);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void testFirstChar_5() {
		String data = "construção do exercício número 1";
		StreamImpl stream = new StreamImpl(data);
		try {
			char c = CharSearchEngine.firstChar(stream);
			assertEquals('ã', c);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
	public void testFirstChar_6() {
		String data = "teste";
		StreamImpl stream = new StreamImpl(data);
		try {
			char c = CharSearchEngine.firstChar(stream);
			assertNull(c);
		} catch (Exception e) {
			assertEquals("Nenhuma vogal foi encontrada sem repetição após consoante.", e.getMessage());
		}
	}
}
