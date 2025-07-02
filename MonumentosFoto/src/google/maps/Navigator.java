package google.maps;

public class Navigator {

	// Dada una dirección, devuelve sus coordenadas
	public Coordinates getCoordinates(String address) {
		// Implementación de relleno
		double number = (address.toLowerCase().charAt(10) - 'a') * 10.0 + 10.0;
		return new Coordinates(number, number);
	}

	// Dadas unas coordenadas, devuelve la dirección a la que le corresponde
	public String gatAddress(Coordinates coordinates) {
		// Implementación de relleno
		return coordinates.toString();
	}

	// Método que, dada una dirección, inicia el proceso de navegar hasta ella
	public void navigateTo(String address) {
		// Implementación de relleno
		System.out.println("GPS: Gire a la derecha. Ha llegado a '" + address + "'");
	}
}
