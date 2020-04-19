package che.vlvl.booksShell.Dao;

import che.vlvl.booksShell.domain.Author;

import java.util.List;

public interface AuthorDao {
    int count();

    void insert(Author author);

    Author getById(int id);

    List<Author> getAll();

    void delete(int id);
}
