package che.vlvl.booksShell.Dao;

import che.vlvl.booksShell.domain.Author;
import che.vlvl.booksShell.domain.Genre;

import java.util.List;

public interface GenreDao {
    int count();

    void insert(Genre genre);

    Genre getById(int id);

    List<Genre> getAll();

    void delete(int id);
}
