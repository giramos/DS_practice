package view;

import java.util.*;

import adapter.Multimedia;
import model.*;

public class Table 
{
	//-- Métodos públicos
	//-------------------------------------------------------------

	public void insertRow(Multimedia cd) 
	{
		rows.add(cd);
	}

	public void drawTable() 
	{
		computeRowWidths();

		printHeader();
		for (Multimedia cd : rows)
			printRow(cd.getCampo1(), cd.getCampo2());
		printSeparator();
		System.out.println();
	}

	//-- Métodos privados
	//-------------------------------------------------------------

	private void computeRowWidths() 
	{
		longestTitle = longestArtist = 0;
		for (Multimedia disco : rows) {
			if (disco.getCampo1().length() > longestTitle)
				longestTitle = disco.getCampo1().length();

			if (disco.getCampo2().length() > longestArtist)
				longestArtist = disco.getCampo2().length();
		}
	}

	private void printHeader() 
	{	
		printSeparator();
		printRow("Título", "Artista");
		printSeparator();
	}

	private void printRow(String title, String artist) 
	{
		System.out.print("| ");
		System.out.print(fillWithBlanks(title, longestTitle));
		System.out.print(" | ");
		System.out.print(fillWithBlanks(artist, longestArtist));
		System.out.println(" |");
	}

	private void printSeparator() 
	{
		System.out.print("+");
		System.out.print(createDashedLine(longestTitle + 2));
		System.out.print("+");
		System.out.print(createDashedLine(longestArtist + 2));
		System.out.println("+");
	}

	/** 
	 * Si el ancho del texto recibido como parámetro es menor que el deseado
	 * añade espacios hasta que el texto tenga el número de caracteres deseado.
	 * 
	 * Ejemplo:
	 * 		fillWithBlanks("abc", 5)  ->   "abc  " (añade dos espacios)
	 */
	public static String fillWithBlanks(String text, int width) 
	{
		return String.format("%1$-" + width + "s", text);
	}

	/**
	 * Devuelve una raya de tantos caracteres como indique el parámetro.
	 * 
	 * Ejemplo:
	 * 		createDashedLine(5)  ->   "-----"
	 */
	private String createDashedLine(int ancho) 
	{
		return String.format("%0" + ancho + "d", 0).replace('0', '-');
	}

	private List<Multimedia> rows = new ArrayList<Multimedia>();
	private int longestTitle = 0, longestArtist = 0;
}
