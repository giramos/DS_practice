package curiosity.commands;

import curiosity.rover.Rover;

public class Forward extends UndoCommand {

	@Override
	public boolean execute(Rover rover) {
		return rover.moveForward();
	}

	@Override
	public Command undo() {
		return new BackWard();
	}

}
