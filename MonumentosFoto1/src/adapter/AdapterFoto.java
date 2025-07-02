package adapter;

import google.maps.BookMark;
import google.maps.Coordinates;
import google.maps.Navigator;
import model.Photo;

public class AdapterFoto implements BookMark {

	Navigator n;
	private Photo f;

	public AdapterFoto(Photo photo) {
		this.f = photo;
		this.n = new Navigator();
	}

	@Override
	public Coordinates getCoordinates() {
		// TODO Auto-generated method stub
		return f.getCoordinates();
	}

	@Override
	public String getTooltipInfo() {
		// TODO Auto-generated method stub
		return f.getUser() + " - " + f.getDescription();
	}

	@Override
	public void open() {
		System.out.println("Pulsado en Foto [" + f.getDescription() + "]: Bajarse foto");

	}

}
