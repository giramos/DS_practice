package model;

import google.maps.Coordinates;

public class Photo {

	private String user; // Usuario que ha subido la foto
	private String description;
	private Coordinates coordinates; // Coordenadas GPS de la foto

	public Photo(String user, String description, Coordinates coordinates) {
		setUser(user);
		setDescription(description);
		setCoordinates(coordinates);
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Coordinates getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(Coordinates coordinates) {
		this.coordinates = coordinates;
	}

	// Baja la foto
	public void download() {
		System.out.println("Bajando foto: " + description);
	}

}
