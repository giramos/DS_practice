package curiosity.controller;

public class Seguir implements Estrategia {

	@Override
	public boolean ejecutar(RoverController rover) {
		rover.setIp(rover.getIp() + 1);
		return true;
	}

}
