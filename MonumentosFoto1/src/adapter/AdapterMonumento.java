package adapter;

import google.maps.BookMark;
import google.maps.Coordinates;
import google.maps.Navigator;
import model.Monument;

public class AdapterMonumento implements BookMark {

	Monument m;
	Navigator n;

	public AdapterMonumento(Monument monument) {
		this.m = monument;
		this.n = new Navigator();
	}

	@Override
	public Coordinates getCoordinates() {
		return n.getCoordinates(m.getAddress());
	}

	@Override
	public String getTooltipInfo() {
		return m.getName() + " " + m.getAuthor();
	}

	@Override
	public void open() {
		System.out.print("Pulsado en Monumento: Navegar hasta el coliseo con el ");
		n.navigateTo(m.getAddress());
		

	}

}
