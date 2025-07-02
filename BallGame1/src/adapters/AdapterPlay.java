package adapters;

import java.awt.Point;

import platform.Image2D;
import platform.playstation.Playstation5API;

public class AdapterPlay implements Adapter {
	Playstation5API api = new Playstation5API();

	@Override
	public Image2D loadImage(String file) {
		// TODO Auto-generated method stub
		return api.loadGraphics(file);
	}

	@Override
	public void drawBall(Image2D image, Point point) {
		// TODO Auto-generated method stub
		api.render(point.x, point.y, image);

	}

	@Override
	public Point getPosition() {
		// TODO Auto-generated method stub
		return api.getJoystick();
	}

}
