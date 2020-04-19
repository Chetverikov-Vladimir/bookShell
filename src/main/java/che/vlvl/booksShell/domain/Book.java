package che.vlvl.booksShell.domain;

import java.util.List;

public class Book {
    private int id;
    private String bookName;
    private Author author;
    private Genre genre;

    public Book() {
    }

    public Book(int id, String bookName, Author author, Genre genre) {
        this.id = id;
        this.bookName = bookName;
        this.author = author;
        this.genre = genre;
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

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                ", author=" + author +
                ", genre=" + genre +
                '}';
    }
}
