package che.vlvl.booksShell.Dao;

import che.vlvl.booksShell.RowMappers.AuthorRowMapper;
import che.vlvl.booksShell.domain.Author;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;


import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings({"SqlNoDataSourceInspection", "ConstantConditions", "SqlDialectInspection"})
@Repository
public class AuthorDaoJdbc implements AuthorDao {

    private final NamedParameterJdbcOperations jdbcOperations;
    private final AuthorRowMapper authorRowMapper;

    public AuthorDaoJdbc(NamedParameterJdbcOperations jdbcOperations, AuthorRowMapper authorRowMapper) {
        this.jdbcOperations = jdbcOperations;

        this.authorRowMapper = authorRowMapper;
    }

    @Override
    public int count() {
        return jdbcOperations.queryForObject("SELECT COUNT(*) FROM AUTHORS",
                Collections.emptyMap(),
                Integer.class);
    }

    @Override
    public void insert(Author author) {
        Map<String, Object> param = new HashMap<>(1);
        param.put("id",author.getId());
        param.put("name", author.getAuthorName());

        jdbcOperations.update("insert into authors (id,name) values(:id,:name)",
                param);

    }

    @Override
    public Author getById(int id) {
        Map<String,Integer> param=Collections.singletonMap("id",id);
        return jdbcOperations.queryForObject("select * from authors where id=:id",
                param,
                authorRowMapper);
    }

    @Override
    public List<Author> getAll() {

        return jdbcOperations.query("select * from authors",
                authorRowMapper);
    }

    @Override
    public void delete(int id) {
        Map<String,Integer> param=Collections.singletonMap("id",id);
        jdbcOperations.update("delete from authors where id=:id",
                param);
    }
}
