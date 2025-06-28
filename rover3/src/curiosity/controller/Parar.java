package curiosity.controller;

public class Parar implements Estrategia {

	@Override
	public boolean ejecutar(RoverController rover) {
		return false;
	}

}
