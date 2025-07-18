package main;

import java.util.*;

import adapter.AdapterBook;
import adapter.AdapterCD;
import model.*;
import server.*;
import view.Table;

public class AppVersion3 
{
	public static void main(String[] args) 
	{
		AppVersion3 store = new AppVersion3();
		store.openWindow();
	}

	public void openWindow() 
	{
		Server server = new Server();

		List<CompactDisc> discs = server.downloadCompactDiscs();
		List<Book> books = server.downloadBooks();

		// Mostrar en una misma tabla los discos y los libros
		// (que ponga "Título" y "Autor" en la cabecera)
		
		Table table = new Table();
		for (Book bo : books) {
			table.insertRow(new AdapterBook(bo));
		}
		for (CompactDisc bo : discs) {
			table.insertRow(new AdapterCD(bo));
		}
		table.drawTable();
		
		/*
			+--------------------+----------------+
			| Título             | Autor          |
			+--------------------+----------------+
			| Despacito          | Luis Fonsi     |
			| Dragon's Kiss      | Marty Friedman |
			| El Código Da Vinci | Dan Brown      |
			| Design Patterns    | Erich Gamma    |
			+--------------------+----------------+
		 */

		server.uploadCompactDiscs(discs);
		server.uploadBooks(books);
	}
}
