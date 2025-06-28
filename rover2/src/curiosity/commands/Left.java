package curiosity.commands;

import curiosity.rover.Rover;

public class Left extends UndoCommand {

	@Override
	public boolean execute(Rover rover) {
		rover.turnLeft();
		return true;
	}

	@Override
	public Command undo() {
		// TODO Auto-generated method stub
		return new Right();
	}

}
