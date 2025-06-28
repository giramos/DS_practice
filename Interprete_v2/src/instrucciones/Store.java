package instrucciones;

import interprete.Contexto;

public class Store implements Instruccion {

	@Override
	public void ejecutar(Contexto ct) {
		int valor = ct.pop();
		int direccion = ct.pop();
		ct.memoria[direccion] = valor;
		ct.incrementarIp();

	}
}
