package interprete;

import java.util.Scanner;

public class Contexto {

	private int ip = 0;
	public int[] memoria = new int[1024];
	private int[] pila = new int[32];
	private int sp = 0;
	private Scanner console = new Scanner(System.in);

	public void push(int valor) {
		pila[sp] = valor;
		sp++;
	}

	public int pop() {
		sp--;
		return pila[sp];
	}

	public int incrementarIp() {
		return ip++;
	}

	public int getIp() {
		return ip;
	}

	public void setIp(int ip) {
		this.ip = ip;
	}

	public int[] getMemoria() {
		return memoria;
	}

	public void setMemoria(int[] memoria) {
		this.memoria = memoria;
	}

	public int[] getPila() {
		return pila;
	}

	public void setPila(int[] pila) {
		this.pila = pila;
	}

	public int getSp() {
		return sp;
	}

	public void setSp(int sp) {
		this.sp = sp;
	}

	public Scanner getConsole() {
		return console;
	}

	public void setConsole(Scanner console) {
		this.console = console;
	}

}
