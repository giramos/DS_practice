package google.maps;

import java.awt.Rectangle;
import java.util.*;

public class Map {
	private List<BookMark> bookMarks = new ArrayList<>();

	public void add(BookMark element) {
		bookMarks.add(element);
	}

	public void draw() {
		// 1. Aquí se dibujará el mapa
		// Ejercicio opcional para casa :)

		// 2. Y ahora se dibujarán los marcadores encima
		for (BookMark bookMark : bookMarks)
			System.out.println("Marcador rojo en " + bookMark.getCoordinates());
	}

	public void shortClick(int x, int y) {
		BookMark bookMark = buscaMarcador(x, y);
		if (bookMark != null)
			System.out.println("Ventana flotante: " + bookMark.getTooltipInfo());
	}

	public void longClick(int x, int y) {
		BookMark marcador = buscaMarcador(x, y);
		if (marcador != null)
			marcador.open();
	}

	// Método auxiliar privado ----------------------
	private BookMark buscaMarcador(int x, int y) {
		for (BookMark bookMark : bookMarks) {
			Coordinates coordinates = bookMark.getCoordinates();
			Rectangle elementArea = new Rectangle((int) coordinates.getLongitude(), (int) coordinates.getLatitude(), 9,
					9);
			if (elementArea.contains(x, y))
				return bookMark;
		}
		return null;
	}

}
