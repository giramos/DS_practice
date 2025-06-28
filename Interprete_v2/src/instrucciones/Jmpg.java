package instrucciones;

import interprete.Contexto;

public class Jmpg implements Instruccion {

	private int valor;

	public Jmpg(int valor) {
		this.valor = valor;
	}

	@Override
	public void ejecutar(Contexto ct) {
		int b = ct.pop();
		int a = ct.pop();
		if (a > b)
			new Jmp(valor).ejecutar(ct);
		else
			ct.incrementarIp();

	}

}
