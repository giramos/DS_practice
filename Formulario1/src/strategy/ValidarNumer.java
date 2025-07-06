package strategy;

public class ValidarNumer implements Validar {

	@Override
	public boolean validar(String texto) {
		for (char ch : texto.toCharArray()) {
			if (!Character.isDigit(ch)) {
				return false;
			}
			else {
				return true;
			}
		}
		return false;
	}

}
