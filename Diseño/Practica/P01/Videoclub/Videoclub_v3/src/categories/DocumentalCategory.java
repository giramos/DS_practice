package categories;

public class DocumentalCategory implements Category {

	@Override
	public double getImporte(int daysRental) {
		double price = 3;
		return (daysRental > 1) ? (price += (daysRental - 1) * 0.5) : (price += 3);
	}

	@Override
	public int getPuntos(int daysRental) {
		return 2;
	}

}
