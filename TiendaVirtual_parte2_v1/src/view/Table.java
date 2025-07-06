package view;

import java.util.*;

import model.*;

public abstract class Table 
{
	//-- Métodos públicos
	//-------------------------------------------------------------

	public void insertRow(Table cd) 
	{
		rows.add(cd);
	}

	public void drawTable() 
	{
		computeRowWidths();

		printHeader();
		dibujar();
		printSeparator();
		System.out.println();

	}

	protected abstract void dibujar() ;
//		for (Table cd : rows)
//			printRow();
	

	//-- Métodos privados
	//-------------------------------------------------------------

	protected abstract void computeRowWidths() ;
//	{
//		longestTitle = longestArtist = 0;
//		for (CompactDisc disco : rows) {
//			if (disco.getTitle().length() > longestTitle)
//				longestTitle = disco.getTitle().length();
//
//			if (disco.getArtist().length() > longestArtist)
//				longestArtist = disco.getArtist().length();
//		}
//	}

	protected abstract void printHeader() ;
//	{	
//		printSeparator();
//		printRow("Título", "Artista");
//		printSeparator();
//	}

	protected abstract void printRow(String str, String str1) ;
//	{
//		System.out.print("| ");
//		System.out.print(fillWithBlanks(title, longestTitle));
//		System.out.print(" | ");
//		System.out.print(fillWithBlanks(artist, longestArtist));
//		System.out.println(" |");
//	}

	protected abstract void printSeparator() ;
//	{
//		System.out.print("+");
//		System.out.print(createDashedLine(longestTitle + 2));
//		System.out.print("+");
//		System.out.print(createDashedLine(longestArtist + 2));
//		System.out.println("+");
//	}

	/** 
	 * Si el ancho del texto recibido como parámetro es menor que el deseado
	 * añade espacios hasta que el texto tenga el número de caracteres deseado.
	 * 
	 * Ejemplo:
	 * 		fillWithBlanks("abc", 5)  ->   "abc  " (añade dos espacios)
	 */
	protected String fillWithBlanks(String text, int width) 
	{
		return String.format("%1$-" + width + "s", text);
	}

	/**
	 * Devuelve una raya de tantos caracteres como indique el parámetro.
	 * 
	 * Ejemplo:
	 * 		createDashedLine(5)  ->   "-----"
	 */
	protected String createDashedLine(int ancho) 
	{
		return String.format("%0" + ancho + "d", 0).replace('0', '-');
	}

	private List<Table> rows = new ArrayList<Table>();
	private int longestTitle = 0, longestArtist = 0;
}
