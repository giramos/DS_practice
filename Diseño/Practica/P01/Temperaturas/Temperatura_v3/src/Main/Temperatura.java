package Main;

public class Temperatura {

	final double celsius;

	public Temperatura(double celsius) {
		this.celsius = celsius;
	}

	public double getCelsius() {
		return celsius;
	}

	public double getFaren() {
		return celsius * 1.8 + 32;
	}
}
