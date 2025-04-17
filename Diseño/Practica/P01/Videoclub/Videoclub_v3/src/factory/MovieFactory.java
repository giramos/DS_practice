package factory;

import categories.Category;
import categories.ChildrenCategory;
import categories.DocumentalCategory;
import categories.NewReleaseCategory;
import categories.RegularCategory;
import main.Main.TipoPeliculas;
import model.Movie;

public class MovieFactory {

	public Movie create(String titulo, TipoPeliculas tipo) {
		Category category = null;
		
		switch (tipo) {
		case NewRelease:
			category = new NewReleaseCategory();
			break;
		case Children:
			category = new ChildrenCategory();
			break;
		case Documental:
			category = new DocumentalCategory();
			break;
		case Regular:
			category = new RegularCategory();
			break;
		default:
			break;
		}
		
		return new Movie(titulo, category);
	}

}
