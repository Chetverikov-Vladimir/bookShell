package che.vlvl.booksShell.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

@Service
public class AuthorsDaoJdbc implements AuthorsDao{

    private final NamedParameterJdbcOperations jdbcOperations;

    public AuthorsDaoJdbc(NamedParameterJdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }


    @Override
    public void insert(List<String> authors, int id) {
        authors.stream()
                .forEach((s)-> {
                    HashMap<String, Object> param = new HashMap<>(2);
                    param.put("name",s);
                    param.put("id_book",id);
                    jdbcOperations.update("insert into authors (name,id_book) values (:name,:id_book)",
                            param);
                });
    }

    @Override
    public List<String> getById(int id) {
        return jdbcOperations.query("select *from authors where id_book=:id",
                Collections.singletonMap("id",id),
                (rs, i) -> rs.getString("name"));
    }
}
