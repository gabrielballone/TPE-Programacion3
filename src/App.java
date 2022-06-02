import java.util.LinkedList;
public class App {
    public static void main(String[] args) throws Exception {
        LinkedList<Genre> genresList = CSVReader.readCSV("C:\\Users\\Gabriel\\Google Drive\\TUDAI\\3er Año\\Programacion3\\TPE\\TPE-Programacion3\\dataset1.csv");
        LinkedList<Book> booksList = new LinkedList<Book>();
        Genre selectedGenre = null;
        for (Genre genre : genresList) {
            if(genre.getName().equals("thriller")){
                selectedGenre = genre;
                break;
            }
        }
        if (selectedGenre != null) {
            CSVWritter.writeCSV(selectedGenre.getBooks(),"C:\\Users\\Gabriel\\Google Drive\\TUDAI\\3er Año\\Programacion3\\TPE\\TPE-Programacion3\\result1.csv");
        }
    }
}
