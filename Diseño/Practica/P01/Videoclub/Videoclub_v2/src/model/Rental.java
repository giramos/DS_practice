package model;

public class Rental // Alquiler
{
	private Movie movie;
	private int days;

	public Rental(Movie movie, int days) {
		this.movie = movie;
		this.days = days;
	}

	public int getDays() {
		return days;
	}

	public Movie getMovie() {
		return movie;
	}

	int getPuntos() {
		return movie.getPuntos(days);
	}

	double getImporte() {
		return movie.getImporte(days);
	}
}
