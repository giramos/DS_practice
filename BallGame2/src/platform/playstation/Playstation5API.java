package platform.playstation;

import java.awt.Point;

import game.BallGame;
import platform.*;


public class Playstation5API extends BallGame{


	private Point point = new Point(0, 0);

	@Override
	protected Image2D loadImage(String file) {
		System.out.println("(PS5) Cargada imagen '" + file + "' del DVD.");
		return new Image2D(file, 10, 10);
	}

	@Override
	protected void drawBall(Image2D image, Point point) {
		System.out.println("(PS5) Dibujando '" + image.getName() + "' en [" + point.x + "," + point.y + "]");

		
	}

	@Override
	protected Point getPosition() {
		// TODO Auto-generated method stub
		 point.translate(10, 10);
		return new Point(point);
	}

}
