package game;

import platform.android.AndroidAPI;
import platform.playstation.Playstation5API;
import platform.windows.WindowsAPI;

public class Main {
	public static void main(String[] args) {
//		BallGame game = new BallGame();
		BallGame game = new AndroidAPI();
		
		game.play();
		
		game = new Playstation5API();

		game.play();
		
		game = new WindowsAPI();

		game.play();
	}
}
