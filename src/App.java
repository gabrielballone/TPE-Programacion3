import java.util.LinkedList;
public class App {

    public static void main(String[] args) throws Exception {
        stage1();
        //stage2();
    }

    public static void stage1() {
        final String inputPath = "tpe1\\dataset1.csv";
        final String outputPath = "tpe1\\result1.csv";
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
        final String inputPath = "tpe2\\dataset1.csv";
        final String outputPath = "tpe2\\result1.csv";
    }
}