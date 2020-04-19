package che.vlvl.booksShell.RowMappers;

import che.vlvl.booksShell.domain.Author;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class AuthorRowMapper implements RowMapper<Author> {
    @Override
    public Author mapRow(ResultSet resultSet, int i) throws SQLException {
        int id=resultSet.getInt("id");
        String name=resultSet.getString("name");
        return new Author(id,name);
    }
}
