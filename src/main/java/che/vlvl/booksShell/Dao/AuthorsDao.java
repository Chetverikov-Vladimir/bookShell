package che.vlvl.booksShell.Dao;

import che.vlvl.booksShell.domain.Book;

import java.util.List;

public interface AuthorsDao {
    void insert(List<String> authors, int id);

    List<String> getById(int id);
}
