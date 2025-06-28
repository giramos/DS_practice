package interprete;

import java.util.ArrayList;
import java.util.List;

import instrucciones.Add;
import instrucciones.Input;
import instrucciones.Instruccion;
import instrucciones.Jmp;
import instrucciones.Jmpg;
import instrucciones.Load;
import instrucciones.Mul;
import instrucciones.Output;
import instrucciones.Push;
import instrucciones.Store;
import instrucciones.Sub;

public class Interprete {

	public void cargaInstruccion(String linea) {
		if (linea.trim().length() == 0)
			return;

		String[] palabras = linea.split(" ");
		// instrucciones.add(palabras);

		String op = palabras[0];

		switch (op) {
		case "push":
			// addPush(instruccion);
			instrucciones.add(new Push(Integer.parseInt(palabras[1])));
			break;

		case "add":
			// Add.addAdd();
			instrucciones.add(new Add());
			break;
		case "sub":
			// addSub();
			instrucciones.add(new Sub());
			break;
		case "mul":
			// addMull();
			instrucciones.add(new Mul());
			break;
		case "jmp":
			// addJmp(instruccion);
			instrucciones.add(new Jmp(Integer.parseInt(palabras[1])));
			break;
		case "jmpg":
			// Jmp.addJmpg(instruccion);
			instrucciones.add(new Jmpg(Integer.parseInt(palabras[1])));
			break;
		case "load":
			// addLoad();
			instrucciones.add(new Load());
			break;
		case "store":
			// addStore();
			instrucciones.add(new Store());
			break;
		case "input":
			// addInput();
			instrucciones.add(new Input());
			break;
		case "output":
			// addOutput();
			instrucciones.add(new Output());
			break;
		default:
			break;
		}
	}

	// private static List<String[]> instrucciones = new ArrayList<String[]>();
	public static List<Instruccion> instrucciones = new ArrayList<>();

}
