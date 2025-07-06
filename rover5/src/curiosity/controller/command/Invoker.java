package curiosity.controller.command;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Invoker {

	List<Instruccion> listaInstrucciones;
	Stack<InstuccionUndo> listaUndo;

	public Invoker() {
		listaInstrucciones = new ArrayList<>();
		listaUndo = new Stack<>();
	}

	public List<Instruccion> getListaInstrucciones() {
		return listaInstrucciones;
	}

	public void setListaInstrucciones(List<Instruccion> listaInstrucciones) {
		this.listaInstrucciones = listaInstrucciones;
	}

	public void ejecutar() {
		listaInstrucciones.forEach(c -> c.execute());
	}
	
	public void undoAll() {
		listaUndo.forEach(c -> c.undo());
	}

	public Stack<InstuccionUndo> getListaUndo() {
		return listaUndo;
	}

	public void setListaUndo(Stack<InstuccionUndo> listaUndo) {
		this.listaUndo = listaUndo;
	}

}
