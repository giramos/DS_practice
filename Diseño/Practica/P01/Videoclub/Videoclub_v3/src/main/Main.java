package main;

import factory.MovieFactory;
import model.Customer;
import model.Movie;
import model.Rental;

public class Main {
	 public enum TipoPeliculas{
		 NewRelease, Children, Documental, Regular
	 }

	public static void main(String[] args) {

		Customer raul = new Customer("Raúl");
		MovieFactory mf = new MovieFactory();

		Movie hotFuzz1 = mf.create("Hot Fuzz", TipoPeliculas.NewRelease);
		Movie toyStory = mf.create("Toy Story", TipoPeliculas.Children);
		Movie zombiesParty = mf.create("Zombies Party", TipoPeliculas.Regular);
		Movie documental = mf.create("Documental", TipoPeliculas.Documental);

		raul.addRental(new Rental(hotFuzz1, 2));
		raul.addRental(new Rental(toyStory, 6));
		raul.addRental(new Rental(zombiesParty, 8));
		raul.addRental(new Rental(documental,2));

		System.out.println(raul.status());

	}
}
