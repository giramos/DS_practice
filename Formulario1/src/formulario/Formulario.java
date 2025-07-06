package formulario;

import java.util.*;

public class Formulario {
	public void addCampo(Campo campo) {
		campos.add(campo);
	}

	public void PideDatos() {
		for (Campo campo : campos) {
			campo.pideDato();
			System.out.println(campo.getDato());
		}
	}

	public void escribeFormulario () {
		System.out.println("\nFORM:");
		for (Campo f : campos)
			System.out.println(f.getEtiqueta() + ": " +f.getDato());
	}
	
	private List<Campo> campos = new ArrayList<Campo>();
}
