package payments;

import machine.Machine;

public class Card implements PaymentMode {

	@Override
	public boolean pay(double amount, Machine machine) {
		String cardNumber = machine.getCardReader().readCardNumber();
		boolean isValid = machine.getBankGateway().pay(cardNumber, amount);
		if (!isValid) {
			machine.getDisplay().show("Tarjeta rechazada\n");
			return false;
		}
		// pago correcto
		machine.getDisplay().show("Tarjeta aceptada: pago realizado con éxito\n");
		return true;
	}

	@Override
	public String getTipo() {
		// TODO Auto-generated method stub
		return "card";
	}

}
