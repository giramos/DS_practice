package adapters;

import java.awt.Point;

import platform.Image2D;
import platform.windows.WindowsAPI;

public class AdapterWin implements Adapter {

	WindowsAPI api = new WindowsAPI();

	@Override
	public Image2D loadImage(String file) {
		// TODO Auto-generated method stub
		return api.loadFile(file);
	}

	@Override
	public void drawBall(Image2D image, Point point) {
		// TODO Auto-generated method stub
		api.paint(point.x, point.y, image);
	}

	@Override
	public Point getPosition() {
		// TODO Auto-generated method stub
		return api.getMouseClick();
	}

}
