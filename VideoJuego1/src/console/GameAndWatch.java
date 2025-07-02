package console;

import java.util.*;

import state.*;

public class GameAndWatch {

//    String screen;
	boolean exit;
	private List<Juego> games;
	private int selectedGame;
	Juego juego;

	public GameAndWatch() {

		// $ Inicialización del menu -----------------------------
//		this.games = List.of("Mortal Maze", "F1 Grand Prix", "Space Invaders");
		this.games = List.of(new MortalMaze(this), new F1(this), new SpaceInvaders(this));
		selectedGame = 0;

		this.juego = new Menu(this);
	}

	// # ------------------------------------------------------------------
	// # Otros métodos de la consola

	public boolean exit() {
		return exit;
	}

	public void gameFinished() {
		juego.draw(); // Necesario para dibujar el último frame
		setScreen(new Menu(this));
	}

	public void setScreen(Juego screen) {
		this.juego = screen;
		juego.restart();
	}

	public boolean isExit() {
		return exit;
	}

	public void setExit(boolean exit) {
		this.exit = exit;
	}

	public int getSelectedGame() {
		return selectedGame;
	}

	public void setSelectedGame(int selectedGame) {
		this.selectedGame = selectedGame;
	}

	public Juego getJuego() {
		return juego;
	}

	public void setJuego(Juego juego) {
		this.juego = juego;
	}

	public List<Juego> getGames() {
		return games;
	}

	public void setGames(List<Juego> games) {
		this.games = games;
	}

	

}
