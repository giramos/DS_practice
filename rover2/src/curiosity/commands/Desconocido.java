package curiosity.commands;

import curiosity.rover.Rover;

public class Desconocido implements Command {

	@Override
	public boolean execute(Rover rover) {
		rover.trace("Unknown instruction!");
		return false;
	}

}
