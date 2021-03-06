package che.vlvl.booksShell.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import static java.util.Optional.ofNullable;

@Service
public class GenresDaoJdbc implements GenresDao {

    private final NamedParameterJdbcOperations jdbcOperations;

    public GenresDaoJdbc(NamedParameterJdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    @Override
    public void insert(List<String> genres, int id) {
        ofNullable(genres).ifPresent(
                list -> list.
                        stream().
                        forEach(genre -> {
                            HashMap<String, Object> param = new HashMap<>(2);
                            param.put("name", genre);
                            param.put("id_book", id);
                            jdbcOperations.update("insert into genres (name,id_book) values (:name,:id_book)", param);
                        })
        );
    }

    @Override
    public List<String> getById(int id) {
        return jdbcOperations.query("select *from genres where id_book=:id",
                Collections.singletonMap("id", id),
                (rs, i) -> rs.getString("name"));
    }
}
