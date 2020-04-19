package che.vlvl.booksShell.RowMappers;

import che.vlvl.booksShell.domain.Genre;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class GenreRowMapper implements RowMapper<Genre> {
    @Override
    public Genre mapRow(ResultSet resultSet, int i) throws SQLException {
        int id=resultSet.getInt("id");
        String name=resultSet.getString("name");
        return new Genre(id,name);
    }
}
