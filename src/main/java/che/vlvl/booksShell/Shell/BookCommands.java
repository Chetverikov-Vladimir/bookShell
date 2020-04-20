package che.vlvl.booksShell.Shell;

import che.vlvl.booksShell.Dao.BookDao;
import che.vlvl.booksShell.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.util.Collections;

@ShellComponent
public class BookCommands {
    private final BookDao bookDao;

    @Autowired
    public BookCommands(BookDao bookDao) {
        this.bookDao = bookDao;
    }
    @ShellMethod("Allow get book by ID.")
    public String getBook(int id){

        return bookDao.getById(id).toString();
    }

    @ShellMethod("Allow add new book.")
    public String addBook(String name, String[] authors, String[] genres){
        Book book = new Book(name, authors,genres);
        bookDao.insert(book);
        return "Book added";
    }

}
