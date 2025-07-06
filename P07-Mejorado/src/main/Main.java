package main;
import java.io.*;

import fileSystem.FileSystem;
import outputs.*;

public class Main {

	public static void main(String[] args) throws IOException {

		FileSystem fs = new FileSystem();

		fs.copy("privado.txt", new FileOutput("copia.txt"));
		fs.copy("privado.txt", new InternetOutput("1.1.1.1"));
		fs.copy("privado.txt", new BluetoothOutput("iPhone"));
	}

}
