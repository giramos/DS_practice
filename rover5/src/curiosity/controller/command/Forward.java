package curiosity.controller.command;

import curiosity.rover.Rover;

public class Forward extends InstuccionUndo {

	private Rover rover;

	public Forward(Rover rover) {
		this.rover = rover;
	}

	@Override
	public boolean execute() {
		return rover.moveForward();
	}

	@Override
	boolean undo() {
		return rover.moveBackward();
	}

}
