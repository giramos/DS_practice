package formulario;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import strategy.Validar;

public class Campo {

	Validar validar;
	private String texto;
	private String etiqueta;

	public Campo(String etiqueta, Validar validar) {
		this.validar = validar;
		this.etiqueta = etiqueta;
	}

	public void pideDato() {
		BufferedReader consola = new BufferedReader(new InputStreamReader(System.in));

		boolean valido;
		do {
			valido = true;
			try {
				System.out.print(etiqueta + ": ");
				texto = consola.readLine();

				valido = validar.validar(texto);
			} catch (IOException ex) {
				System.out.println(ex);
			}
		} while (!valido);
	}

	public String getDato() {
		return texto;
	}

	public String getEtiqueta() {
		return etiqueta;
	}
}
