package adapter;

import model.Book;

public class AdapterBook implements Multimedia {

	private Book book;

	public AdapterBook(Book book) {
		this.book = book;
	}
	@Override
	public String getCampo1() {
		// TODO Auto-generated method stub
		return book.getTitle();
	}

	@Override
	public String getCampo2() {
		// TODO Auto-generated method stub
		return book.getAuthor();
	}

}
