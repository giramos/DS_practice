package instrucciones;

import interprete.Contexto;

public class Jmp implements Instruccion {

	private int valor;

	public Jmp(int valor) {
		this.valor = valor;
	}

	@Override
	public void ejecutar(Contexto ct) {
		ct.setIp(valor);
	}

}
