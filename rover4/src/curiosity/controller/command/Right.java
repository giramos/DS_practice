package curiosity.controller.command;

import curiosity.rover.Rover;

public class Right implements Command {

	@Override
	public boolean execute(Rover rover) {
		rover.turnLeft();
		return true;
	}

}
