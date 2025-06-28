package instrucciones;

import interprete.Contexto;

public class Push implements Instruccion {
	int valor;

	public Push(int valor) {
//		this.instruccion = instruccion;
		this.valor = valor;}

	@Override
	public void ejecutar(Contexto ct) {
		ct.push(valor);
		ct.incrementarIp();
		
	}

}
