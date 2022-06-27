import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class CSVReader {

    public static LinkedList<String> readCSV(String filePathRelative) {
        String filePathAbsolute = new File("").getAbsolutePath();
        String line = "";
        LinkedList<String> lines = new LinkedList<String>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePathAbsolute + "\\" + filePathRelative))) {
            boolean isFirstLine = true;
            while ((line = br.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }
}