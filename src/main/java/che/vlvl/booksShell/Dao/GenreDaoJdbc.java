package che.vlvl.booksShell.Dao;

import che.vlvl.booksShell.RowMappers.AuthorRowMapper;
import che.vlvl.booksShell.RowMappers.GenreRowMapper;
import che.vlvl.booksShell.domain.Genre;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings({"SqlNoDataSourceInspection", "ConstantConditions", "SqlDialectInspection"})
@Repository
public class GenreDaoJdbc implements GenreDao{

    private final NamedParameterJdbcOperations jdbcOperations;
    private final GenreRowMapper genreRowMapper;

    public GenreDaoJdbc(NamedParameterJdbcOperations jdbcOperations, GenreRowMapper genreRowMapper) {
        this.jdbcOperations = jdbcOperations;
        this.genreRowMapper = genreRowMapper;
    }

    @Override
    public int count() {
        return jdbcOperations.queryForObject("SELECT COUNT(*) FROM genres",
                Collections.emptyMap(),
                Integer.class);
    }

    @Override
    public void insert(Genre genre) {
        Map<String, Object> param = new HashMap<>(1);
        param.put("id",genre.getId());
        param.put("name", genre.getGenreName());

        jdbcOperations.update("insert into genres (id,name) values(:id,:name)",
                param);

    }

    @Override
    public Genre getById(int id) {
        Map<String,Integer> param=Collections.singletonMap("id",id);
        return jdbcOperations.queryForObject("select * from genres where id=:id",
                param,
                genreRowMapper);
    }

    @Override
    public List<Genre> getAll() {
        return jdbcOperations.query("select * from genres",
                genreRowMapper);
    }

    @Override
    public void delete(int id) {

        Map<String,Integer> param=Collections.singletonMap("id",id);
        jdbcOperations.update("delete from genres where id=:id",
                param);
    }
}
