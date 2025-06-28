package curiosity.controller;

public class Ampliacion implements Estrategia {

	@Override
	public boolean ejecutar(RoverController rover) {
		rover.listaCommand.forEach(c -> c.undo());
		return true;
	}

}
