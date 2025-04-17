package model;

public class Movie // Pel�cula
{
	private String title;
	private int category;

	public static final int CHILDRENS = 2;
	public static final int NEW_RELEASE = 1;
	public static final int REGULAR = 0;

	public Movie(String title, int category) {
		this.title = title;
		this.category = category;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public String getTitle() {
		return title;
	}

	double getImporte(Rental rental) {
		double price = 0;
		switch (rental.getMovie().getCategory()) {
			case Movie.NEW_RELEASE:
				price += rental.getDays() * 3;
				break;
			case Movie.REGULAR:
				price += 2;
				if (rental.getDays() > 2)
					price += (rental.getDays() - 2) * 1.5;
				break;
			case Movie.CHILDRENS:
				price += 1.5;
				if (rental.getDays() > 3)
					price += (rental.getDays() - 3) * 1.5;
				break;
		}
		return price;
	}

	int getPuntos(Rental rental) {
		int points = 1;
		if ((rental.getMovie().getCategory() == Movie.NEW_RELEASE) && rental.getDays() > 1)
			points = 2;
		return points;
	}
}
