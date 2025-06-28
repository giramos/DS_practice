package curiosity.commands;

import curiosity.rover.Rover;

public class BackWard extends UndoCommand {

	@Override
	public boolean execute(Rover rover) {
		return rover.moveBackward();
	}

	@Override
	public Command undo() {
		return new Forward();
	}

}
