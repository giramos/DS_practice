package util;

public class Instruccion {

	public static void cargaInstruccion(String linea) {
		if (linea.trim().length() == 0)
			return;
	
		String[] palabras = linea.split(" ");
		Program.instrucciones.add(palabras);
	}

}
