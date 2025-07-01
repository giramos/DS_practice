package curiosity.controller;

import java.util.List;
import java.util.Stack;

import curiosity.controller.command.BackWard;
import curiosity.controller.command.Command;
import curiosity.controller.command.Forward;
import curiosity.controller.command.Left;
import curiosity.controller.command.Right;
import curiosity.controller.estrategia.Estrategia;
import curiosity.rover.Rover;

public class RoverController {

	public RoverController(Rover rover) {
		this.rover = rover;
	}

	public RoverController(Rover rover2, Estrategia parar) {
		this.rover = rover2;
		this.estrategia = parar;
	}

	public boolean executeTask(List<String> task) {

		boolean success = true;

		while (ip < task.size() && success) {
			String instruction = task.get(ip);
			Command cmd = null;

			if (instruction.equals("forward")) {
				// se mueve una posición hacia delante salvo que se encuentre con un obstáculo
				success = rover.moveForward();
				cmd = new Forward();
			} else if (instruction.equals("backward")) {
				// se mueve una posición hacia atrás salvo que se encuentre con un obstáculo
				success = rover.moveBackward();
				cmd = new BackWard();
			} else if (instruction.equals("left")) {
				rover.turnLeft();
				cmd = new Left();
			} else if (instruction.equals("right")) {
				rover.turnRight();
				cmd = new Right();
			} else if (instruction.equals("sample")) {
				rover.takeSample();
			} else if (instruction.equals("photo")) {
				rover.takePhoto();
			} else {
				rover.trace("Unknown instruction!");
			}

			if (success) {
				ip++;
				if (cmd != null) {
					undos.add(0, cmd);
//					undos.push(cmd);
				}
			} else {
				undos.forEach(c -> c.execute(rover));
				success = true;
//				success = estrategia.algoritmo(this);
			}

		}

		if (success)
			rover.trace("Task finished");
		else
			rover.trace("Task couldn't have been completed");

		return success;
	}

	public void incrementar() {
		ip++;
	}

	public int getIp() {
		return ip;
	}

	public void setIp(int ip) {
		this.ip = ip;
	}

	public Rover getRover() {
		return rover;
	}

	public void setRover(Rover rover) {
		this.rover = rover;
	}

	public Stack<Command> getUndos() {
		return undos;
	}

	public void setUndos(Stack<Command> undos) {
		this.undos = undos;
	}

	private Rover rover;
	private int ip;
	Stack<Command> undos = new Stack<>();
	Estrategia estrategia;
}
