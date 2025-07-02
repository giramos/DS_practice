package platform.android;

import java.awt.Point;

import game.BallGame;
import platform.*;

public class AndroidAPI extends BallGame {

	public Image2D loadResource(String name) {
		System.out.println("(Android) Cargada imagen '" + name + "' de la memoria flash.");
		return new Image2D(name, 10, 10);
	}

	public void draw(int x, int y, Image2D image) {
		System.out.println("(Android) Dibujando '" + image.getName() + "' en [" + x + "," + y + "]");
	}

	// Posición en la que el usuario toca con el dedo en la pantalla
	public Point getTouch() {
		point.translate(10, 10);
		return new Point(point);
	}

	private Point point = new Point(0, 0);

	@Override
	protected Image2D loadImage(String file) {
		// TODO Auto-generated method stub
		return this.loadResource(file);
	}

	@Override
	protected void drawBall(Image2D image, Point point) {
		this.draw(point.x, point.y, image);
		
	}

	@Override
	protected Point getPosition() {
		// TODO Auto-generated method stub
		return this.getTouch();
	}
}
