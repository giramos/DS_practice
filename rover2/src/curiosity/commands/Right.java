package curiosity.commands;

import curiosity.rover.Rover;

public class Right extends UndoCommand {

	@Override
	public boolean execute(Rover rover) {
		rover.turnRight();
		return true;
	}

	@Override
	public Command undo() {
		// TODO Auto-generated method stub
		return new Left();
	}

	
}
