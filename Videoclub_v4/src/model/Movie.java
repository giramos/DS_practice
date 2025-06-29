package model;

import strategies.MovieType;

public class Movie // Pel�cula
{
	private String title;

	public Movie(String title, MovieType category) {
		this.title = title;
		this.type = category;
	}

	public String getTitle() {
		return title;
	}

	double calcularImporte(Rental rental) {
		return type.calcularImporte(rental.getDays());
	}

	MovieType type;

	int calcularPuntos(Rental rental) {
		return type.calcularPuntos(rental.getDays());
	}

	public MovieType getType() {
		return type;
	}

	public void setType(MovieType type) {
		this.type = type;
	}
}
