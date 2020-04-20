package che.vlvl.booksShell.domain;

import java.util.List;

public class Book {
    private int id;
    private String bookName;
    private List<String> authors;
    private List<String> genres;

    public Book() {
    }

    public Book(int id, String bookName, List<String> authors, List<String> genres) {
        this.id = id;
        this.bookName = bookName;
        this.authors = authors;
        this.genres = genres;
    }

    public Book(int id, String bookName) {
        this.id = id;
        this.bookName = bookName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenre(List<String> genres) {
        this.genres = genres;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                ", authors=" + authors +
                ", genres=" + genres +
                '}';
    }
}
