package instrucciones;

import interprete.Contexto;

public class Sub implements Instruccion {

	@Override
	public void ejecutar(Contexto ct) {
		int b = ct.pop();
		int a = ct.pop();
		ct.push(a - b);
		ct.incrementarIp();

	}

}
