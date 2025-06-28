package util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import interprete.Interprete;

public class FileUtil {

	public static void cargarFichero(Interprete inter) throws FileNotFoundException, IOException {
		BufferedReader fichero = new BufferedReader(new FileReader("programa.txt"));
	
		String linea;
		while ((linea = fichero.readLine()) != null)
			inter.cargaInstruccion(linea);
		fichero.close();
	}

}
