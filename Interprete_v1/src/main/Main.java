package main;

import util.FileUtil;
import util.Program;

public class Main {

	public static void main(String[] args) throws Exception {
		FileUtil.cargarFichero();
		Program.ejecutaPrograma();
	}
}
