package adapters;

import java.awt.Point;

import platform.Image2D;
import platform.android.AndroidAPI;

public class AdapterAndroid implements Adapter {

	AndroidAPI api = new AndroidAPI();

	@Override
	public Image2D loadImage(String file) {
		return api.loadResource(file);
	}

	@Override
	public void drawBall(Image2D image, Point point) {
		api.draw(point.x, point.y, image);
	}

	@Override
	public Point getPosition() {
		// TODO Auto-generated method stub
		return api.getTouch();
	}

}
