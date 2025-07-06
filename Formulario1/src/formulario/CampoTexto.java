package formulario;

import strategy.Validar;

public class CampoTexto implements Validar {



	@Override
	public boolean validar(String texto) {
		for (char ch : texto.toCharArray()) {
			if (!Character.isLetter(ch)) {
				return false;

			} else {
				return true;
			}
		}
		return false;
	}

}
