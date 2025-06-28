package curiosity.controller;

import curiosity.rover.Rover;

public class CommandForward implements Comand {

	private Rover rover;

	public CommandForward(Rover rover) {
		this.rover = rover;
	}

	@Override
	public boolean undo() {
		// TODO Auto-generated method stub
		return rover.moveBackward();
	}

}
