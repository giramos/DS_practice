package main;

import categories.ChildrenCategory;
import categories.DocumentalCategory;
import categories.NewReleaseCategory;
import categories.RegularCategory;
import model.Customer;
import model.Movie;
import model.Rental;

public class Main {

	public static void main(String[] args) {

		Customer raul = new Customer("Raúl");

		Movie hotFuzz = new Movie("Hot Fuzz", new NewReleaseCategory());
		Movie toyStory = new Movie("Toy Story", new ChildrenCategory());
		Movie zombiesParty = new Movie("Zombies Party", new RegularCategory());
		Movie documental = new Movie("Documental", new DocumentalCategory());

		raul.addRental(new Rental(hotFuzz, 2));
		raul.addRental(new Rental(toyStory, 6));
		raul.addRental(new Rental(zombiesParty, 8));
		raul.addRental(new Rental(documental,2));

		System.out.println(raul.status());

	}
}
