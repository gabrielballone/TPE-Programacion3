
public class Book {
    private String title;
    private String author;
    private String pageCount;
    
    public Book(String title, String author, String pages) {
        this.title = title;
        this.author = author;
        this.pageCount = pages;       
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

    @Override
    public String toString() {
        return getTitle() + " , " + getAuthor() + " , " + getPageCount();
    }

    
    
}
