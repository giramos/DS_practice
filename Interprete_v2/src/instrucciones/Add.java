package instrucciones;

import interprete.Contexto;

public class Add implements Instruccion {

	@Override
	public void ejecutar(Contexto ct) {
		ct.push(ct.pop() + ct.pop());
		ct.incrementarIp();
		
	}


}
