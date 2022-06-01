import java.util.LinkedList;

public class Genre {
    private String name;
    private LinkedList<Book> books;

    public Genre(String name) {
        this.name = name;
        this.books = new LinkedList<Book>();
    }

    public LinkedList<Book> getBooks() {
        return books;
    }

    public void addBook(Book book) {
        this.books.add(book);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public String toString() {
        return getName();
    }
}
