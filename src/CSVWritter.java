import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

public class CSVWritter {

    public static void writeCSV(String filePathRelative, LinkedList<String> lines) {
        BufferedWriter bw = null;
        try {
            File file = new File(filePathRelative);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            bw = new BufferedWriter(fw);
            for (String line : lines) {
                bw.write(line);
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