package curiosity.controller.estrategia;

import curiosity.controller.RoverController;

public class Saltar implements Estrategia {

	@Override
	public boolean algoritmo(RoverController roverController) {
		roverController.incrementar();
		return true;
	}

}
