package util;

import java.util.Scanner;

public class StateContext {

	int ip;
	int[] memoria;
	int[] pila;
	int sp;
	Scanner console;

	public StateContext() {
		this.ip = 0;
		this.memoria = new int[1024];
		this.pila = new int[32];
		this.sp = 0;
		this.console = new Scanner(System.in);
	}

	public void push(int valor) {
		pila[sp] = valor;
		sp++;
	}

	public int pop() {
		sp--;
		return pila[sp];
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
