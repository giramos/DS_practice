package game;

import adapters.AdapterAndroid;
import adapters.AdapterPlay;
import adapters.AdapterWin;

public class Main {
	public static void main(String[] args) {
		BallGame game = new BallGame();
		game.play(new AdapterAndroid());
		game.play(new AdapterPlay());
		game.play(new AdapterWin());
	}
}
