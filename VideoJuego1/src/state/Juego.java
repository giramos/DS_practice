package state;

public interface Juego {

	// # Botones de la consola
	public void upPressed();

	public void downPressed();

	public void leftPressed();

	public void rightPressed();

	public void backPressed();

	// # Otros métodos de la consola
	public void draw();

	void restart();

}
