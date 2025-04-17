package Main;

public class Temperatura {

	double celsius;
	double faren;

	public Temperatura(double temp) {
		setCelsius(temp);
	}

	public void setCelsius(double temp) {
		this.celsius = temp;
		this.faren = temp * 1.8 + 32;
	}

	public double getFaren() {
		return faren;
	}

	public double getCelsius() {
		return celsius;
	}
}
