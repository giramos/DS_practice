package formulario;

import java.io.*;

public class CampoNumero implements Campo {

	private String etiqueta;

	public CampoNumero(String etiqueta) {
		this.etiqueta = etiqueta;
	}

	@Override
	public void pideDato() {
		BufferedReader consola = new BufferedReader(new InputStreamReader(System.in));

		boolean valido;
		do {
			valido = true;
			try {
				System.out.print(etiqueta + ": ");
				texto = consola.readLine();

				for (char ch : texto.toCharArray()) {
					if (!Character.isDigit(ch)) {
						valido = false;
						break;
					}
				}
			} catch (IOException ex) {
				System.out.println(ex);
			}
		} while (!valido);
	}

	@Override
	public String getDato() {
		return texto;
	}

	@Override
	public String getEtiqueta() {
		return etiqueta;
	}
	
	private String texto;

}
