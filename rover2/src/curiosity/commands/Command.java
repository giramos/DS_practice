package curiosity.commands;

import curiosity.rover.Rover;

public interface Command {

	boolean execute(Rover rover);
}
