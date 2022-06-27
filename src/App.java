import java.util.LinkedList;
public class App {

    static final String inputPath = "dataset1.csv";
    static final String outputPath = "result1.csv";

    public static void main(String[] args) throws Exception {
        stage1();
        //stage2();
    }

    public static void stage1() {
        LinkedList<Genre> genresList = CSVReader.readCSV(inputPath);
        Genre selectedGenre = null;
        for (Genre genre : genresList) {
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

    }
}