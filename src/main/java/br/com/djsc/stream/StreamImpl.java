package br.com.djsc.stream;

public class StreamImpl implements Stream {

	private String data;
	private int pos;

	public StreamImpl(String data) {
		if (data == null || data.length() == 0)
			throw new IllegalArgumentException("Argumento inválido.");
		this.data = data;
	}

	public char getNext() {
		return data.charAt(pos++);
	}

	public boolean hasNext() {
		return pos < data.length();
	}

}
