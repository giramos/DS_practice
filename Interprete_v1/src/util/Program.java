package util;

import java.util.ArrayList;
import java.util.List;

public class Program {

	public static void ejecutaPrograma() {
		while (state.getIp() < instrucciones.size()) {
			String[] instruccion = instrucciones.get(state.getIp());

			if (instruccion[0].equals("push")) {
				state.push(Integer.parseInt(instruccion[1]));
				state.setIp(state.getIp() + 1);
				;
			} else if (instruccion[0].equals("add")) {
				state.push(state.pop() + state.pop());
				state.setIp(state.getIp() + 1);
				;
			} else if (instruccion[0].equals("sub")) {
				int b = state.pop();
				int a = state.pop();
				state.push(a - b);
				state.setIp(state.getIp() + 1);
				;
			} else if (instruccion[0].equals("mul")) {
				state.push(state.pop() * state.pop());
				state.setIp(state.getIp() + 1);
			} else if (instruccion[0].equals("jmp")) {
				state.setIp(Integer.parseInt(instruccion[1]));
			} else if (instruccion[0].equals("jmpg")) {
				int b = state.pop();
				int a = state.pop();
				if (a > b)
					state.setIp(Integer.parseInt(instruccion[1]));
				else
					state.setIp(state.getIp() + 1);
			} else if (instruccion[0].equals("load")) {
				int direccion = state.pop();
				state.push(state.memoria[direccion]);
				state.setIp(state.getIp() + 1);
			} else if (instruccion[0].equals("store")) {
				int valor = state.pop();
				int direccion = state.pop();
				state.memoria[direccion] = valor;
				state.setIp(state.getIp() + 1);
			} else if (instruccion[0].equals("input")) {
				System.out.println("Escriba un entero:");
				state.push(state.getConsole().nextInt());
				state.setIp(state.getIp() + 1);
			} else if (instruccion[0].equals("output")) {
				System.out.println(state.pop());
				state.setIp(state.getIp() + 1);
			}
		}
	}

	static List<String[]> instrucciones = new ArrayList<String[]>();
    static StateContext state = new StateContext();

}
