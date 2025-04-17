package categories;

public class RegularCategory implements Category {

	@Override
	public double getImporte(int daysRental) {
		double price = 2;
		return (daysRental > 2) ? (price += (daysRental - 2) * 1.5) : (price += 2);
	}

	@Override
	public int getPuntos(int daysRental) {
		return 1;
	}

}
