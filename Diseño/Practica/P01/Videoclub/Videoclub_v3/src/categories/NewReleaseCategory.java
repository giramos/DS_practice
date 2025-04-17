package categories;

public class NewReleaseCategory implements Category {

	@Override
	public double getImporte(int daysRental) {
		double price = 0;
		return price += daysRental * 3;
	}

	@Override
	public int getPuntos(int daysRental) {
		return (daysRental > 1) ? 2 : 1;
	}

}
