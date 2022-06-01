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

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Genre)) {
            if (o instanceof String){
                String genre = (String) o;
                return this.name.equals(genre);
            }
            return false;
        }
        Genre genre = (Genre) o;
        return this.name.equals(genre.getName());
    }
}
