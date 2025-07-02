package main;

import database.Database;
import google.maps.*;
import model.*;

public class Main {

	public static void main(String[] args) {

		Database db = new Database();
		Map map = new Map();

		// 1. Meter elementos en el mapa
		System.out.println("\n 1. Metiendo marcadores en el mapa");

		for (Monument monument : db.selectMonuments()) {
//			 map.add(monument);
		}

		for (Photo photo : db.selectPhotos()) {
			// map.add(photo);
		}

		for (Restaurant restaurant : db.selectRestaurants()) {
			// map.add(restaurant);
		}

		// 2. En el mapa se dibujan los marcadores para los elementos añadidos al mapa
		System.out.println("\n 2. Dibujando el mapa con los marcadores");
		map.draw();

		// 3. El usuario presiona brevemente la pantalla para recibir información de
		// cada elemento
		System.out.println("\n 3. Pulsación breve sobre cada elemento: información en tooltip");
		map.shortClick(31, 31); // Pulsado en Monumento: Nombre y autor del monumento (coliseo)
		map.shortClick(21, 21); // Pulsado en Foto: Descripción de la foto y usuario que la ha subido
		map.shortClick(91, 91); // Pulsado en Restaurante: Nombre y teléfono del restaurante

		// 4. El usuario deja pulsado un marcador para abrir un elemento
		System.out.println("\n 4. Pulsación larga sobre cada elemento: abrir el elemento");
		map.longClick(31, 31); // Pulsado en Monumento: Navegar hasta el coliseo con el GPS
		map.longClick(21, 21); // Pulsado en Foto: Bajarse foto
		map.longClick(91, 91); // Pulsado en Restaurante: Llamar al restaurante
	}

}
