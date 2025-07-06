package model;

import java.util.ArrayList;
import java.util.List;

import view.Table;

public class Mobile extends Table {
	public Mobile(String brand, String model) {
		setBrand(brand);
		setModel(model);
	}

	public Mobile() {
		rows.clear();
		setBrand(null);
		setModel(null);
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getBrand() {
		return brand;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getModel() {
		return model;
	}

	private String brand;
	private String model;
	private int longestTitle = 0, longestArtist = 0;
	private List<Mobile> rows = new ArrayList<Mobile>();

	@Override
	protected void computeRowWidths() {
//		{
		longestTitle = longestArtist = 0;
		for (Mobile disco : rows) {
			if (disco.getModel().length() > longestTitle)
				longestTitle = disco.getModel().length();

			if (disco.getBrand().length() > longestArtist)
				longestArtist = disco.getBrand().length();
		}
//	}

	}

	@Override
	protected void printHeader() {
		printSeparator();
		printRow("Modelo", "Marca");
		printSeparator();

	}

	@Override
	protected void printRow(String string, String string2) {
		System.out.print("| ");
		System.out.print(fillWithBlanks(string, longestTitle));
		System.out.print(" | ");
		System.out.print(fillWithBlanks(string2, longestArtist));
		System.out.println(" |");

	}

	@Override
	protected void printSeparator() {
		System.out.print("+");
		System.out.print(createDashedLine(longestTitle + 2));
		System.out.print("+");
		System.out.print(createDashedLine(longestArtist + 2));
		System.out.println("+");

	}

	@Override
	protected void dibujar() {
		for (Mobile m : rows)
			printRow(m.getModel(), m.getBrand());

	}
}
