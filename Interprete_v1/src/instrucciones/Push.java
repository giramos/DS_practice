package instrucciones;

public class Push {
	
	public void ejecutar(	) {
		state.push(Integer.parseInt(instruccion[1]));
		state.setIp(state.getIp() + 1);
	}

}
