package curiosity.controller.command;

import curiosity.rover.Rover;

public interface Command {

	boolean execute(Rover rover);
}
