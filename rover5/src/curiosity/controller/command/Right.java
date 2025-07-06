package curiosity.controller.command;

import curiosity.rover.Rover;

public class Right extends InstuccionUndo {

	private Rover rover;

	public Right(Rover rover) {
		this.rover = rover;
	}

	@Override
	public boolean execute() {
		rover.turnRight();
		return true;
	}

	@Override
	boolean undo() {
		rover.turnLeft();
		return true;
	}

}
