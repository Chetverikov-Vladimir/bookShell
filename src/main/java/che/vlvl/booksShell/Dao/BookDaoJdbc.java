package che.vlvl.booksShell.Dao;

import che.vlvl.booksShell.domain.Book;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@SuppressWarnings({"SqlNoDataSourceInspection", "ConstantConditions", "SqlDialectInspection"})
@Repository
public class BookDaoJdbc implements BookDao {

    private final NamedParameterJdbcOperations jdbcOperations;
    private final AuthorsDao authorsDao;
    private final GenresDao genresDao;

    public BookDaoJdbc(NamedParameterJdbcOperations jdbcOperations, AuthorsDao authorsDao, GenresDao genresDao) {
        this.jdbcOperations = jdbcOperations;
        this.authorsDao = authorsDao;
        this.genresDao = genresDao;
    }

    @Override
    public int count() {
        return jdbcOperations.queryForObject("SELECT COUNT(*) FROM books",
                Collections.emptyMap(),
                Integer.class);
    }

    @Override
    public void insert(Book book) {
        //Добавляем книгу
        jdbcOperations.update("insert into books (name) values(:name)",
                Collections.singletonMap("name",book.getBookName()));

        authorsDao.insert(book.getAuthors(),book.getId());
        genresDao.insert(book.getGenres(),book.getId());



    }

    @Override
    public Book getById(int id) {
        Map<String,Integer> param=Collections.singletonMap("id",id);
         Book book=jdbcOperations.queryForObject("select * from books where id=:id",
                param,(rs, i) -> {
                    int idBook =rs.getInt("id");
                    String name=rs.getString("name");
                    return new Book(idBook,name);
                });
         book.setAuthors(authorsDao.getById(id));
         book.setGenre(genresDao.getById(id));

         return book;

    }

    @Override
    public List<Book> getAll() {
        List<Book> books = jdbcOperations.query("select * from books",
                (rs, i) -> {
                    int id1 = rs.getInt("id");
                    String name = rs.getString("name");
                    return new Book(id1, name);
                });
        books.stream()
                .forEach(book -> {
                    book.setAuthors(authorsDao.getById(book.getId()));
                    book.setGenre(genresDao.getById(book.getId()));
                });
        return books;

    }

    @Override
    public void delete(int id) {

    }
}
