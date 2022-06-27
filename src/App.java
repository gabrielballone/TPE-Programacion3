import java.util.Arrays;
import java.util.LinkedList;
public class App {

    static final String cvsSplitBy = ",";

    public static void main(String[] args) throws Exception {
        stage1();
        //stage2();
    }

    public static void stage1() {
        final String inputPath = "tpe1\\dataset1.csv";
        final String outputPath = "tpe1\\result1.csv";
        LinkedList<String> genresLines = CSVReader.readCSV(inputPath);
        LinkedList<Genre> genreList = new LinkedList<Genre>();
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
        Genre selectedGenre = null;
        for (Genre genre : genreList) {
            if(genre.getName().equals("thriller")){
                selectedGenre = genre;
                break;
            }
        }
        if (selectedGenre != null) {
            CSVWritter.writeCSV(selectedGenre.getBooks(), outputPath);
        }
    }

    public static void stage2() {
        final String inputPath = "tpe2\\dataset1.csv";
        final String outputPath = "tpe2\\result1.csv";
        DirectedGraph<Integer> graph = new DirectedGraph<Integer>();

    }
}