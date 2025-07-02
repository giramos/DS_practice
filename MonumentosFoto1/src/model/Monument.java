package model;

public class Monument {

	private String name;
	private String author;
	private String address;

	public Monument(String name, String author, String address) {
		setName(name);
		setAuthor(author);
		setAddress(address);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
