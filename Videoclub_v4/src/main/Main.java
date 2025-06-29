package main;

import model.Customer;
import model.Movie;
import model.Rental;
import strategies.Childrens;
import strategies.New_Release;
import strategies.Regular;

public class Main {

	public static void main(String[] args) {

		Customer raul = new Customer("Raúl");

		Movie hotFuzz = new Movie("Hot Fuzz", new New_Release());
		Movie toyStory = new Movie("Toy Story", new Childrens());
		Movie zombiesParty = new Movie("Zombies Party", new Regular());

		raul.addRental(new Rental(hotFuzz, 2));
		raul.addRental(new Rental(toyStory, 6));
		raul.addRental(new Rental(zombiesParty, 8));

		System.out.println(raul.status());

	}
}
