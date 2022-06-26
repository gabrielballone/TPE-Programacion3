import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

public class CSVWritter {

    public static void writeCSV(LinkedList<Book> booksList, String filePath) {
        BufferedWriter bw = null;
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file);
            bw = new BufferedWriter(fw);
            for (Book book : booksList) {
                String title = book.getTitle();
                String author = book.getAuthor();
                int pages = book.getPageCount();
                String genres = String.join(" ", book.getGenres());                ;
                String lineToPrint = String.format("%s,%s,%s,%s", title, author, pages, genres);                
                bw.write(lineToPrint);
                bw.newLine();                
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            try {
                if (bw != null)
                    bw.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}