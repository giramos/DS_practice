package instrucciones;

import interprete.Contexto;

public class Output implements Instruccion {


	@Override
	public void ejecutar(Contexto ct) {
		System.out.println(ct.pop());
		ct.incrementarIp();
		
	}

}
