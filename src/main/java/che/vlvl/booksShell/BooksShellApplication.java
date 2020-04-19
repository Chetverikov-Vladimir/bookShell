package che.vlvl.booksShell;

import che.vlvl.booksShell.Dao.AuthorDao;
import che.vlvl.booksShell.Dao.BookDao;
import che.vlvl.booksShell.Dao.GenreDao;
import che.vlvl.booksShell.domain.Author;
import che.vlvl.booksShell.domain.Book;
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

		GenreDao genreDao = context.getBean(GenreDao.class);

		genreDao.insert(new Genre(1,"Fantastic"));
		genreDao.insert(new Genre(2,"Romantic"));

		BookDao bookDao=context.getBean(BookDao.class);

		bookDao.insert(new Book(1,"Onegin",authorDao.getById(1),genreDao.getById(2)));


		bookDao.getAll().stream().
				forEach(System.out::println);

		authorDao.getAll().stream().
				forEach(System.out::println);

		genreDao.getAll().stream().
				forEach(System.out::println);

	}

}
