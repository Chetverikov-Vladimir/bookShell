package che.vlvl.booksShell;

import che.vlvl.booksShell.Dao.BookDao;
import che.vlvl.booksShell.domain.Book;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class BooksShellApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(BooksShellApplication.class, args);


		BookDao bookDao=context.getBean(BookDao.class);

		bookDao.insert(new Book(
				1,
				"skazka"));
		bookDao.insert(new Book(
				2,
				"lozh",
				Arrays.asList("Pushkin","Lermontov"),
				Arrays.asList("Romantic","Poem")));
		System.out.println(bookDao.getById(1));
		System.out.println(bookDao.getAll());




	}

}
