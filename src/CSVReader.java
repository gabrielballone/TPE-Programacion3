import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class CSVReader {

    public static LinkedList<Genre> readCSV(String filePath) {
        String csvFile = filePath;
        String line = "";
        String cvsSplitBy = ",";
        LinkedList<Genre> genreList = new LinkedList<Genre>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            boolean isFirstLine = true;
            while ((line = br.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }
                String[] items = line.split(cvsSplitBy);
                String title = items[0];
                String author = items[1];
                String pagesCount = items[2];
                String genresString = items[3];
                String[] genres = genresString.split(" ");
                Book book = new Book(title, author, pagesCount, genresString);
                boolean found = false;
                for (String genre : genres) {
                    for (Genre genreL : genreList) {
                        if (genreL.equals(genre)) {
                            genreL.addBook(book);
                            found = true;
                        }
                    }
                    if (!found) {
                        Genre genreToAdd = new Genre(genre);
                        genreToAdd.addBook(book);
                        genreList.add(genreToAdd);
                    }
                    found = false;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return genreList;
    }
    
}