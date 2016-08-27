package br.com.djsc;

import java.util.Scanner;

import br.com.djsc.engine.CharSearchEngine;
import br.com.djsc.stream.Stream;
import br.com.djsc.stream.StreamImpl;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String str = null;

		do {
			System.out.print("Informe o stream de entrada: ");
			str = scanner.nextLine();

			try {
				Stream stream = new StreamImpl(str);
				char firstChar = CharSearchEngine.firstChar(stream);
				System.out.println(String.format("Character = %c", firstChar));
			} catch (Exception e) {
				System.out.println(String.format("Ops: %s", e.getMessage()));
			}
		} while (!str.equals(""));
	}
}
