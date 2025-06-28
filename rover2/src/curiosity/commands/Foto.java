package curiosity.commands;

import curiosity.rover.Rover;

public class Foto implements Command {

	@Override
	public boolean execute(Rover rover) {
		rover.takePhoto();
		return true;
	}

}
