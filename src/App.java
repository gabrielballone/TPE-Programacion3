import java.util.LinkedList;
public class App {

    public static void main(String[] args) throws Exception {
        //stage1();
        stage2();
    }

    public static void stage1() {
        final String inputPath = "tpe1\\dataset1.csv";
        final String outputPath = "tpe1\\result1.csv";
        LinkedList<String> booksLines = CSVReader.readCSV(inputPath);
        LinkedList<Genre> genreList = Stage1.generateGenreList(booksLines);
        LinkedList<String> booksToWrite = Stage1.getBooksToWriteFromGenre(genreList, "thriller");
        CSVWritter.writeCSV(outputPath, booksToWrite);
    }

    public static void stage2() {
        final String inputPath = "tpe2\\dataset2.csv";
        final String outputPath = "tpe2\\result2.csv";
        LinkedList<String> genresLines = CSVReader.readCSV(inputPath);
        DirectedGraph<Integer> graph = Stage2.generateGraph(genresLines);
        LinkedList<String> mostSearchedGenres = Stage2.getMostSearchesGenresAfterAGenre(graph, "infantil", 3);
        CSVWritter.writeCSV(outputPath, mostSearchedGenres);
    }
}