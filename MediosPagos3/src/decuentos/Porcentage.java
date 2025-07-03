package decuentos;

import machine.model.Event;

public class Porcentage implements Descuento {

	private double por;

	public Porcentage(int porce) {
		this.por = porce;
	}

	public Porcentage(double d) {
		this.por = d;
	}

	@Override
	public double calcularDecuento(Event selectedEvent, double amountToPay) {
	
		return amountToPay * por;
	}

	@Override
	public String getTipo() {
		// TODO Auto-generated method stub
		return "porcentage";
	}

}
