package che.vlvl.booksShell.Dao;

import che.vlvl.booksShell.domain.Author;
import che.vlvl.booksShell.domain.Book;
import che.vlvl.booksShell.domain.Genre;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings({"SqlNoDataSourceInspection", "ConstantConditions", "SqlDialectInspection"})
@Repository
public class BookDaoJdbc implements BookDao {

    private final NamedParameterJdbcOperations jdbcOperations;
    private final AuthorDao authorDao;
    private final GenreDao genreDao;

    public BookDaoJdbc(NamedParameterJdbcOperations jdbcOperations, AuthorDao authorDao, GenreDao genreDao) {
        this.jdbcOperations = jdbcOperations;
        this.authorDao = authorDao;
        this.genreDao = genreDao;
    }

    @Override
    public int count() {
        return jdbcOperations.queryForObject("SELECT COUNT(*) FROM books",
                Collections.emptyMap(),
                Integer.class);
    }

    @Override
    public void insert(Book book) {
        Map<String, Object> param = new HashMap<>(1);
        param.put("id",book.getId());
        param.put("name", book.getBookName());
        param.put("idAuthor",book.getAuthor().getId());
        param.put("idGenre",book.getGenre().getId());

        jdbcOperations.update("insert into books (id,name,idAuthor,idGenre) values(:id,:name,:idAuthor,:idGenre)",
                param);
    }

    @Override
    public Book getById(int id) {
        Map<String,Integer> param=Collections.singletonMap("id",id);
        return jdbcOperations.queryForObject("select * from books where id=:id",
                param,
                (rs, i) -> {
                    int id1 =rs.getInt("id");
                    String name=rs.getString("name");
                    Author author=authorDao.getById(rs.getInt("idAuthor"));
                    Genre genre=genreDao.getById(rs.getInt("idGenre"));
                    return new Book(id1,name,author,genre);
                });

    }

    @Override
    public List<Book> getAll() {
        return jdbcOperations.query("select * from books",
                (rs, i) -> {
                    int id1 =rs.getInt("id");
                    String name=rs.getString("name");
                    Author author=authorDao.getById(rs.getInt("idAuthor"));
                    Genre genre=genreDao.getById(rs.getInt("idGenre"));
                    return new Book(id1,name,author,genre);
                });
    }

    @Override
    public void delete(int id) {

    }
}
