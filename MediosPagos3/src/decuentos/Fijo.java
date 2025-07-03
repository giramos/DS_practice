package decuentos;

import machine.model.Event;

public class Fijo implements Descuento {

	private int importe;

	public Fijo(int importe) {
		this.importe = importe;
	}

	@Override
	public double calcularDecuento(Event selectedEvent, double amountToPay) {
		amountToPay -= importe;
		return amountToPay;
	}

	@Override
	public String getTipo() {
		// TODO Auto-generated method stub
		return "fijo";
	}

}
