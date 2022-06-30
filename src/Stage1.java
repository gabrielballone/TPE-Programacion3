import java.util.Arrays;
import java.util.LinkedList;

public class Stage1 {
    
    static final String cvsSplitBy = ",";

    public static LinkedList<Genre> generateGenreList(LinkedList<String> genresLines) {
        LinkedList<Genre> genresToReturn = new LinkedList<Genre>();
        for (String line : genresLines) {
            String[] items = line.split(cvsSplitBy);
            String title = items[0];
            String author = items[1];
            int pagesCount = Integer.parseInt(items[2]);
            String genresString = items[3];
            String[] genres = genresString.split(" ");
            Book book = new Book(title, author, pagesCount, Arrays.asList(genres));
            boolean found = false;
            for (String genre : genres) {
                for (Genre genreL : genresToReturn) {
                    if (genreL.equals(genre)) {
                        genreL.addBook(book);
                        found = true;
                    }
                }
                if (!found) {
                    Genre genreToAdd = new Genre(genre);
                    genreToAdd.addBook(book);
                    genresToReturn.add(genreToAdd);
                }
                found = false;
            }
        }
        return genresToReturn;
    }

    public static LinkedList<String> getBooksToWriteFromGenre(LinkedList<Genre> genreList, String genreToFilter) {
        LinkedList<String> linesToWrite = new LinkedList<String>();
        Genre selectedGenre = null;
        for (Genre genre : genreList) {
            if(genre.getName().equals(genreToFilter)){
                selectedGenre = genre;
                break;
            }
        }
        if (selectedGenre != null) {
            LinkedList<Book> booksList = selectedGenre.getBooks();
            for (Book book : booksList) {
                String title = book.getTitle();
                String author = book.getAuthor();
                int pages = book.getPageCount();
                String genres = String.join(" ", book.getGenres());                ;
                String lineToWrite = String.format("%s,%s,%s,%s", title, author, pages, genres);                               
                linesToWrite.add(lineToWrite);
            }
        }
        return linesToWrite;
    }

}
