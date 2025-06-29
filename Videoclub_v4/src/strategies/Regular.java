package strategies;

public class Regular implements MovieType {

	double price;
	
	@Override
	public double calcularImporte(int days) {
		price += 2;
		if (days > 2)
			price += (days - 2) * 1.5;
		return price;
	}

	@Override
	public int calcularPuntos(int dias) {
		return 1;
	}

}
