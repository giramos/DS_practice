package interprete;

public class Programa {

	public static void ejecutaPrograma(Contexto context, Interprete inter) {
		while (context.getIp() < inter.instrucciones.size()) {
			inter.instrucciones.get(context.getIp()).ejecutar(context);
		}
	}

}
