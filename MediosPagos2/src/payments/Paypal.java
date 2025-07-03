package payments;

import machine.Machine;
import paypal.PayPalAPI;

public class Paypal implements PaymentMode {

	PayPalAPI paypal = new PayPalAPI();

	@Override
	public boolean pay(double amountToPay, Machine machine) {
		// mostrar en pantalla "Iniciando sesión en PayPal..."
		machine.getDisplay().show("Iniciando sesión en PayPal...\n");
		// pedir nombre de usuario y contraseña por pantalla
		machine.getDisplay().show("Nombre: ");
		String username = machine.getKeyboard().readString();
		machine.getDisplay().show("\nContraseña: ");
		String password = machine.getKeyboard().readString();
		String token = paypal.logIn(username, password);
		if (!paypal.isLogged(token)) {
			// mostrar "Nombre de usuario o contraseña incorrectas" y finalizar
			machine.getDisplay().show("Nombre de usuario o contraseña incorrectas\n");
		}
		// si el nombre de usuario y contraseña son correctos, PayPal nos
		// habrá devuelto un token válido, que usaremos para realizar el pago
		boolean isValid = paypal.checkout(token, amountToPay);
		return isValid;
	}

}
