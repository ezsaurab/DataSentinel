import java.io.*;
import java.util.ArrayList;

public class main {

    public static void main(String[] args) {

        try {

            File file = new File("sample.csv");

            FileReader fr = new FileReader(file);

            BufferedReader br = new BufferedReader(fr);

            ArrayList<String[]> rows = new ArrayList<>();

            String line;

            while((line = br.readLine()) != null) {

                String[] parts = line.split(",");

                rows.add(parts);
                System.out.println("Rows: " + rows.size());

               System.out.println("Columns: " + rows.get(0).length);

            }

            br.close();

            System.out.println(rows.get(0)[0]);
            System.out.println(rows.get(0)[1]);

            System.out.println(rows.get(1)[0]);
            System.out.println(rows.get(1)[1]);

        }
        catch(IOException e) {

            System.out.println("Error reading file");

        }

    }

}