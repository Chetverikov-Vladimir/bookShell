package che.vlvl.booksShell.Dao;

import java.util.List;

public interface GenresDao {
    void insert(List<String> genres, int id);

    List<String> getById(int id);
}
