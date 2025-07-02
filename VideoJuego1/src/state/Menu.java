package state;

import java.util.List;

import console.GameAndWatch;

public class Menu implements Juego {

	GameAndWatch game;

	// # Variables del Menu

	public Menu(GameAndWatch gameAndWatch) {
		game = gameAndWatch;
	}

	@Override
	public void upPressed() {
		if (game.getSelectedGame() > 0)
			game.setSelectedGame(game.getSelectedGame() - 1);

	}

	@Override
	public void downPressed() {
		if (game.getSelectedGame() < game.getGames().size() - 1)
			game.setSelectedGame(game.getSelectedGame() + 1);

	}

	@Override
	public void leftPressed() {
		// TODO Auto-generated method stub

	}

	@Override
	public void rightPressed() {
		game.setScreen(game.getGames().get(game.getSelectedGame()));

	}

	@Override
	public void backPressed() {
		game.setExit(true);

	}

	@Override
	public void draw() {
		drawMenu();

	}

	@Override
	public void restart() {
		// TODO Auto-generated method stub

	}

	// # Métodos del Menú

	public void drawMenu() {
		System.out.println("\n--------------------");
		System.out.println("Select a game: (W/S -> up/down. D -> play game)");
		for (int i = 0; i < game.getGames().size(); i++) {
			System.out.print((i == game.getSelectedGame()) ? " >> " : "    ");
			System.out.println(game.getGames().get(i));
		}
		System.out.println("(C -> turn off)");
	}

}
