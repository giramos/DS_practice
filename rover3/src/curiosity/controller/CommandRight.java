package curiosity.controller;

import curiosity.rover.Rover;

public class CommandRight implements Comand {

	private Rover rover;

	public CommandRight(Rover rover) {
		this.rover = rover;
	}

	@Override
	public boolean undo() {
		rover.turnLeft();
		return true;
	}

}
