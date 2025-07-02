package adapter;

import google.maps.BookMark;
import google.maps.Coordinates;
import google.maps.Navigator;
import model.Restaurant;

public class AdapterBar implements BookMark {

	private Restaurant bar;
	Navigator n;

	public AdapterBar(Restaurant restaurant) {
		this.bar = restaurant;
		this.n = new Navigator();
	}

	@Override
	public Coordinates getCoordinates() {
		// TODO Auto-generated method stub
		return n.getCoordinates(bar.getAddress());
	}

	@Override
	public String getTooltipInfo() {
		// TODO Auto-generated method stub
		return bar.getName() + " . Tel: " + bar.getPhone();
	}

	@Override
	public void open() {
		System.out.println("Pulsado en Restaurante: Llamar al restaurante");

	}

}
