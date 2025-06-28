package instrucciones;

import interprete.Contexto;

public class Load implements Instruccion {

	@Override
	public void ejecutar(Contexto ct) {
		int direccion = ct.pop();
		ct.push(ct.memoria[direccion]);
		ct.incrementarIp();// TODO Auto-generated method stub

	}
}
