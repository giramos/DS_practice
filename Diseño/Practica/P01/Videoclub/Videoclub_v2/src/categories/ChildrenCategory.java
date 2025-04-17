package categories;

public class ChildrenCategory implements Category {

	@Override
	public double getImporte(int daysRental) {
		double price = 1.5;
		return (daysRental > 3) ? (price += (daysRental - 3) * 1.5) : (price += 1.5);
	}

	@Override
	public int getPuntos(int daysRental) {
		return 1;
	}

}
