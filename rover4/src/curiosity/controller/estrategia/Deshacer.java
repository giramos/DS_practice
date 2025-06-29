package curiosity.controller.estrategia;

import curiosity.controller.RoverController;

public class Deshacer implements Estrategia {

	@Override
	public boolean algoritmo(RoverController roverController) {
		// TODO Auto-generated method stub
		 roverController.getUndos().forEach(c -> c.execute(roverController.getRover()));
		return true;
	}

}
