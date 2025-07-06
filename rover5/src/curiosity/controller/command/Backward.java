package curiosity.controller.command;

import curiosity.rover.Rover;

public class Backward extends InstuccionUndo {

	private Rover rover;

	public Backward(Rover rover) {
		this.rover = rover;
	}

	@Override
	public boolean execute() {
		// TODO Auto-generated method stub
		return rover.moveBackward();
	}

	@Override
	boolean undo() {
		// TODO Auto-generated method stub
		return rover.moveForward();
	}

	
}
