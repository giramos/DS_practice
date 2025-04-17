package model;

import categories.Category;

public class Movie // Pel�cula
{
	private String title;
	private Category category;

	public Movie(String title, Category category) {
		this.title = title;
		this.category = category;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getTitle() {
		return title;
	}

	double getImporte(int days) {
		return category.getImporte(days);
	}

	int getPuntos(int days) {
		return category.getPuntos(days);
	}
}
