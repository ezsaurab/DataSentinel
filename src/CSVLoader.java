import java.io.*;
import java.util.ArrayList;

public class CSVLoader {

    public static ArrayList<String[]> loadCSV(
            String filePath)
            throws IOException {

        File file = new File(filePath);

        FileReader fr =
            new FileReader(file);

        BufferedReader br =
            new BufferedReader(fr);

        ArrayList<String[]> rows =
            new ArrayList<>();

        String line;

        while((line = br.readLine()) != null) {

            String[] parts =
                line.split(",");

            rows.add(parts);

        }

        br.close();

        return rows;

    }

}