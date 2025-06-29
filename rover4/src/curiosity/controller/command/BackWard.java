package curiosity.controller.command;

import curiosity.rover.Rover;

public class BackWard implements Command {

	@Override
	public boolean execute(Rover rover) {
		// TODO Auto-generated method stub
		return rover.moveForward();
	}

}
