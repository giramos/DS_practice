package util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileUtil {

	public static void cargarFichero() throws FileNotFoundException, IOException {
		BufferedReader fichero = new BufferedReader(new FileReader("programa.txt"));
	
		String linea;
		while ((linea = fichero.readLine()) != null)
			Instruccion.cargaInstruccion(linea);
		fichero.close();
	}

}
