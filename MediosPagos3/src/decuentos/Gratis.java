package decuentos;

import machine.model.Event;

public class Gratis implements Descuento {

	@Override
	public double calcularDecuento(Event selectedEvent, double amountToPay) {
		amountToPay -= selectedEvent.getPrice();
		return amountToPay;
	}

	@Override
	public String getTipo() {
		// TODO Auto-generated method stub
		return "gratis";
	}

}
