package main;

import java.util.*;

import adapter.AdapterBook;
import model.*;
import server.*;
import view.Table;

public class AppVersion2 
{
	public static void main(String[] args) 
	{
		AppVersion2 store = new AppVersion2();
		store.openWindow();
	}

	public void openWindow() 
	{
		Server server = new Server();

		List<Book> books = server.downloadBooks();
		
		Table table = new Table();
		for (Book bo : books) {
			table.insertRow(new AdapterBook(bo));
		}
		table.drawTable();

		// Mostrar sólo los libros en una tabla (que ponga "Título" y "Autor" en la cabecera)
		
		/*		
			+--------------------+-------------+
			| Título             | Autor       |
			+--------------------+-------------+
			| El Código Da Vinci | Dan Brown   |
			| Design Patterns    | Erich Gamma |
			+--------------------+-------------+
		*/

		server.uploadBooks(books);
	}
}
