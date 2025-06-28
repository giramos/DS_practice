package curiosity.controller;

import java.util.List;

import curiosity.rover.Rover;

public class RoverController {
	
	public RoverController(Rover rover) {
		this.rover = rover;
	}
		
	public boolean executeTask(List<String> task) {
		
		boolean success = true;
		
		while (ip < task.size() && success) {
			String instruction = task.get(ip);
				
			if (instruction.equals("forward")) {
				// se mueve una posición hacia delante salvo que se encuentre con un obstáculo
				success = rover.moveForward();
			} else if (instruction.equals("backward")) {
				// se mueve una posición hacia atrás salvo que se encuentre con un obstáculo
				success = rover.moveBackward();
			} else if (instruction.equals("left")) {
				rover.turnLeft();
			} else if (instruction.equals("right")) {
				rover.turnRight();
			} else if (instruction.equals("sample")) {
				rover.takeSample();
			} else if (instruction.equals("photo")) {
				rover.takePhoto();
			} else {
				rover.trace("Unknown instruction!");				
			}
			
			if (success)
				ip++;
		}
		
		if (success)
			rover.trace("Task finished");
		else
			rover.trace("Task couldn't have been completed");

		return success;
	}
	
	private Rover rover;
	private int ip;		
}
