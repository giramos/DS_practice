package curiosity.controller;

import java.util.*;

import curiosity.rover.Rover;

public class RoverController {

	Stack<Comand> listaCommand = new Stack<>();
	Estrategia estrategia;

	public RoverController(Rover rover, Estrategia estrategia) {
		this.rover = rover;
		this.estrategia = estrategia;
	}

	public boolean executeTask(List<String> task) {

		boolean success = true;

		while (ip < task.size() && success) {
			String instruction = task.get(ip);
			Comand cm = null;

			if (instruction.equals("forward")) {
				// se mueve una posición hacia delante salvo que se encuentre con un obstáculo
				success = rover.moveForward();
				cm = new CommandForward(rover);
			} else if (instruction.equals("backward")) {
				// se mueve una posición hacia atrás salvo que se encuentre con un obstáculo
				success = rover.moveBackward();
				cm = new CommandBakWard(rover);
			} else if (instruction.equals("left")) {
				rover.turnLeft();
				cm = new CommandLeft(rover);
			} else if (instruction.equals("right")) {
				rover.turnRight();
				cm = new CommandRight(rover);
			} else if (instruction.equals("sample")) {
				rover.takeSample();
			} else if (instruction.equals("photo")) {
				rover.takePhoto();
			} else {
				rover.trace("Unknown instruction!");
			}

			if (success) {
				ip++;
				if (cm != null) {
					listaCommand.add(0, cm);
				}
			}
			else {
				success = estrategia.ejecutar(this);
			}
//			if (!success) {
//				rover.trace("Obstacle found. Returning to origin...");
//				ejecutar(listaCommand); // <- aquí se deshacen todos los comandos
//			}

		}

		if (success)
			rover.trace("Task finished");
		else
			rover.trace("Task couldn't have been completed");

		return success;
	}

	private void ejecutar(List<Comand> listaCommand2) {
		for (var c : listaCommand2) {
			c.undo();
		}

	}

	private Rover rover;
	private int ip;

	public int getIp() {
		return ip;
	}

	public void setIp(int ip) {
		this.ip = ip;
	}
	
	
}
