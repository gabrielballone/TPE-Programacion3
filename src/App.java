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
        final String outputPathEx1 = "tpe2\\result2_1.csv";
        final String outputPathEx2 = "tpe2\\result2_2.csv";
        // final String outputPathEx3 = "tpe2\\result2_3.csv";
        LinkedList<String> genresLines = CSVReader.readCSV(inputPath);
        DirectedGraph<Integer> graph = Stage2.generateGraph(genresLines);
        LinkedList<String> mostSearchedGenres = Stage2.getMostSearchesGenresAfterAGenre(graph, "infantil", 3);
        CSVWritter.writeCSV(outputPathEx1, mostSearchedGenres);
        LinkedList<String> sequenceWithHigherSearchRatio = Stage2.getSequenceWithHigherSearchRatio(graph, "infantil");
        CSVWritter.writeCSV(outputPathEx2, sequenceWithHigherSearchRatio);
        DirectedGraph<Integer> graphWithAffinedGenres = Stage2.getGraphWithAffinedGenres(graph, "infantil");
        // CSVWritter.writeCSV(outputPathEx3, graphWithAffinedGenres);

    }
}