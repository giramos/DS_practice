package main;

import interprete.*;
import util.FileUtil;

public class Main {

	public static Contexto context = new Contexto();
	public static Interprete inter = new Interprete();

	public static void main(String[] args) throws Exception {
		FileUtil.cargarFichero(inter);
		Programa.ejecutaPrograma(context, inter);
	}

}
