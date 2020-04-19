package che.vlvl.booksShell;

import che.vlvl.booksShell.Dao.AuthorDao;
import che.vlvl.booksShell.Dao.GenreDao;
import che.vlvl.booksShell.domain.Author;
import che.vlvl.booksShell.domain.Genre;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class BooksShellApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(BooksShellApplication.class, args);
		AuthorDao authorDao = context.getBean(AuthorDao.class);

		authorDao.insert(new Author(1,"Pushkin"));
		authorDao.insert(new Author(2,"Sukin sin"));

		List<Author> authors = authorDao.getAll();
		authors.stream().
				forEach((x)-> System.out.println(x.getId()+" "+x.getAuthorName()));

		GenreDao genreDao = context.getBean(GenreDao.class);

		genreDao.insert(new Genre(1,"Fantastic"));
		genreDao.insert(new Genre(2,"Romantic"));

		List<Genre> genres = genreDao.getAll();
		genres.stream().forEach((x)-> System.out.println(x.getId()+" "+x.getGenreName()));

	}

}
