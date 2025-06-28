package curiosity.controller;

import curiosity.rover.Rover;

public class CommandBakWard implements Comand {

	private Rover rover;

	public CommandBakWard(Rover rover) {
		this.rover = rover;
	}

	@Override
	public boolean undo() {
		// TODO Auto-generated method stub
		return rover.moveForward();
	}

}
