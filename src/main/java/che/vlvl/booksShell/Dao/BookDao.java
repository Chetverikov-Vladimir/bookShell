package che.vlvl.booksShell.Dao;

import che.vlvl.booksShell.domain.Book;

import java.util.List;

public interface BookDao {
    int count();

    void insert(Book book);

    Book getById(int id);

    List<Book> getAll();

    void delete(int id);
}
