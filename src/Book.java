
public class Book {
    private String title;
    private String author;
    private String pageCount;
    private String genres;
    
    public Book(String title, String author, String pageCount, String genres) {
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

    public String getPageCount() {
        return pageCount;
    }

    public void setPageCount(String pageCount) {
        this.pageCount = pageCount;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }
    
    @Override
    public String toString() {
        return getTitle() + " , " + getAuthor() + " , " + getPageCount();
    }

    
    
}
