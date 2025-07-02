package main;

import java.io.IOException;

import console.GameAndWatch;

public class Main {

	public static void main(String[] args) throws IOException {
		test(new GameAndWatch());
	}

	public static void test(GameAndWatch console) throws IOException {

		do {
			console.getJuego().draw();

			char key = getKey();

			if (key == 'W')
				console.getJuego().upPressed();
			else if (key == 'S')
				console.getJuego().downPressed();
			else if (key == 'A')
				console.getJuego().leftPressed();
			else if (key == 'D')
				console.getJuego().rightPressed();
			else if (key == 'C')
				console.getJuego().backPressed();

		} while (!console.exit());

	}

	private static char getKey() throws IOException {
		var validKeys = "WASDC";
		char nextChar;
		do {
			nextChar = Character.toUpperCase((char) System.in.read());
		} while (validKeys.indexOf(nextChar) == -1);

		return nextChar;
	}
}
