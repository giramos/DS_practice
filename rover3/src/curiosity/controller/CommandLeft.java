package curiosity.controller;

import curiosity.rover.Rover;

public class CommandLeft implements Comand {

	private Rover rover;

	public CommandLeft(Rover rover) {
		this.rover = rover;
	}

	@Override
	public boolean undo() {
		rover.turnRight();
		return true;
	}

}
