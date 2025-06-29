package curiosity.controller.command;

import curiosity.rover.Rover;

public class Left implements Command {

	@Override
	public boolean execute(Rover rover) {
		rover.turnRight();
		return true;
	}

}
