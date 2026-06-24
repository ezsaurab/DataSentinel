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

            while ((line = br.readLine()) != null) {

                String[] parts = line.split(",");

                rows.add(parts);

            }

            br.close();

            System.out.println("========== DATASET PROFILE ==========");

            System.out.println(
                "Rows: " +
                DataProfiler.countRows(rows)
            );

            System.out.println(
                "Columns: " +
                DataProfiler.countColumns(rows)
            );

            System.out.println(
                "Missing Values: " +
                DataProfiler.countMissingValues(rows)
            );

            System.out.println(
                "Duplicates: " +
                DataProfiler.countDuplicates(rows)
            );

            System.out.println();

            System.out.println("===== COLUMN COMPLETENESS REPORT =====");

            DataProfiler.columnCompleteness(rows);

            System.out.println();

            System.out.println("===== DATA TYPE DETECTION =====");

            DataProfiler.detectColumnTypes(rows);

            System.out.println();

            System.out.println("========= PROFILE COMPLETE =========");

        }
        catch(IOException e) {

            System.out.println(
                "Error reading file: " +
                e.getMessage()
            );

        }

    }

}