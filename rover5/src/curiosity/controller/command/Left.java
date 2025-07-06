package curiosity.controller.command;

import curiosity.rover.Rover;

public class Left extends InstuccionUndo {

	private Rover rover;

	public Left(Rover rover) {
		this.rover = rover;
	}

	@Override
	public boolean execute() {
		rover.turnLeft();
		return true;
	}

	@Override
	boolean undo() {
		rover.turnRight();
		return true;
	}

}
