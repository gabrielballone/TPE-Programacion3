import java.util.List;

public class Book {
    private String title;
    private String author;
    private int pageCount;
    private List<String> genres;
    
    public Book(String title, String author, int pageCount, List<String> genres) {
        this.title = title;
        this.author = author;
        this.pageCount = pageCount;
        this.genres = genres;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public List<String> getGenres() {
        return genres;
    }

    // public void setGenre(String genre) {
    //     this.genres.add(genre);
    // }
    
    @Override
    public String toString() {
        return getTitle() + " , " + getAuthor() + " , " + getPageCount();
    }

    
    
}
