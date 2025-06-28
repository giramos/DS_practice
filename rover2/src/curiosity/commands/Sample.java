package curiosity.commands;

import curiosity.rover.Rover;

public class Sample implements Command {

	@Override
	public boolean execute(Rover rover) {
		rover.takeSample();
		return true;
	}

}
