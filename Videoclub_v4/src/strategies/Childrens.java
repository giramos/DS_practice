package strategies;

public class Childrens implements MovieType {
	double price;

	@Override
	public double calcularImporte(int days) {
		price += 1.5;
		if (days > 3)
			price += (days - 3) * 1.5;
		return price;
	}

	@Override
	public int calcularPuntos(int dias) {
		// TODO Auto-generated method stub
		return 1;
	}

}
