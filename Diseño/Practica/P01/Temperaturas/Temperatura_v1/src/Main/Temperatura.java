package Main;

public class Temperatura {
	
	double temp;
	
	public Temperatura(double temperatura) {
		temp = temperatura;
	}

	public double getCelsius() {
		return temp;
	}
	
	public double getFaren() {
		temp = temp  * 1.8 + 32;
		return temp;
	}
}
