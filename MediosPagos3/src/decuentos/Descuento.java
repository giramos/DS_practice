package decuentos;

import machine.model.Event;

public interface Descuento {

	double calcularDecuento(Event selectedEvent, double amountToPay);
	String getTipo();
}
