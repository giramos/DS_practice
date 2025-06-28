package curiosity.controller;

import java.util.List;
import java.util.Stack;

import curiosity.commands.BackWard;
import curiosity.commands.Command;
import curiosity.commands.Desconocido;
import curiosity.commands.Forward;
import curiosity.commands.Foto;
import curiosity.commands.Left;
import curiosity.commands.Right;
import curiosity.commands.Sample;
import curiosity.commands.UndoCommand;
import curiosity.rover.Rover;

public class RoverController {

	public RoverController(Rover rover) {
		this.rover = rover;
	}

	public boolean executeTask(List<String> task) {

		boolean success = true;

		while (ip < task.size() && success) {
			String instruction = task.get(ip);
			Command cmd = parseCommand(instruction);

			success = cmd.execute(rover);

			if (success) {
				if (cmd instanceof UndoCommand) {
					pila.push((UndoCommand) cmd);
				}
				ip++; // SOLO incrementas ip si la instrucción se completó con éxito
			} else {
				rover.trace("Obstacle found. Reverting path...");
				undoAll();
				return false;
			}
		}

		if (success)
			rover.trace("Task finished");
		else
			rover.trace("Task couldn't have been completed");

		return true;
	}

	private Command parseCommand(String instruction) {
		return switch (instruction) {
		case "forward" -> new Forward();
		case "backward" -> new BackWard();
		case "left" -> new Left();
		case "right" -> new Right();
		case "sample" -> new Sample();
		case "photo" -> new Foto();
		default -> new Desconocido();
		};

	}

	public void undoAll() {
		while (!pila.isEmpty()) {
			UndoCommand cmd = pila.pop();
			Command inverse = cmd.undo();

			boolean success = false;
			try {
				success = inverse.execute(rover);
			} catch (ArrayIndexOutOfBoundsException e) {
				rover.trace("Undo out of bounds: " + cmd.getClass().getSimpleName());
			}

			if (!success) {
				rover.trace("Cannot undo command: " + cmd.getClass().getSimpleName());
				// Puedes seguir o romper, tú decides
				break;
			}
		}
		ip = 0; // Reinicia el índice de instrucción
		rover.trace("Undone all previous actions due to obstacle.");
	}

	private Rover rover;
	private int ip;
	Stack<UndoCommand> pila = new Stack<>();
}
