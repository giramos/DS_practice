package strategies;

public class New_Release implements MovieType {
	
	double price;

	@Override
	public double calcularImporte(int days) {
		return price += days * 3;
	}

	@Override
	public int calcularPuntos(int dias) {
		return dias > 1 ? 2 : 1;
	}

}
