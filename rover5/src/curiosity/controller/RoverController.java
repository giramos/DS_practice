package curiosity.controller;

import java.util.List;

import curiosity.controller.command.Backward;
import curiosity.controller.command.Forward;
import curiosity.controller.command.Instruccion;
import curiosity.controller.command.InstuccionUndo;
import curiosity.controller.command.Invoker;
import curiosity.controller.command.Left;
import curiosity.controller.command.Right;
import curiosity.rover.Rover;

public class RoverController {
	
	public RoverController(Rover rover) {
		this.rover = rover;
		this.invoker = new Invoker();
	}
		
	public boolean executeTask(List<String> task) {
		
		boolean success = true;
		
		while (ip < task.size() && success) {
		    String instruction = task.get(ip);
		    Instruccion cmd = null;

		    switch (instruction) {
		        case "forward":
		            cmd = new Forward(rover);
		            break;
		        case "backward":
		            cmd = new Backward(rover);
		            break;
		        case "left":
		            cmd = new Left(rover);
		            break;
		        case "right":
		            cmd = new Right(rover);
		            break;
		        case "sample":
		            rover.takeSample();
		            ip++;
		            continue;
		        case "photo":
		            rover.takePhoto();
		            ip++;
		            continue;
		        default:
		            rover.trace("Unknown instruction!");
		            ip++;
		            continue;
		    }

		    if (cmd != null) {
		        success = cmd.execute();
		        if (success) {
		            invoker.getListaUndo().add((InstuccionUndo) cmd);
		            ip++;
		        }
		    }
		}

		if (!success) {
		    rover.trace("Obstacle found. Undoing all commands...");
		    invoker.undoAll();
		}
		
		if (success)
			rover.trace("Task finished");
		else
			rover.trace("Task couldn't have been completed");

		return success;
	}
	
	private Rover rover;
	private int ip;		
	private Invoker invoker;
}
