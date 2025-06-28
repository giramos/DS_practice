package instrucciones;

import interprete.Contexto;

public class Input implements Instruccion {

	@Override
	public void ejecutar(Contexto ct) {
		System.out.println("Escriba un entero:");
		ct.push(ct.getConsole().nextInt());
		ct.incrementarIp();

	}

}
