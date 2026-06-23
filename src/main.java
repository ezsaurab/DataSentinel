import java.io.*;
import java.util.ArrayList;

public class Main {

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

            System.out.println(
                "Rows: " +
                DataProfiler.countRows(rows)
            );

            System.out.println(
                "Columns: " +
                DataProfiler.countColumns(rows)
            );

            System.out.println(
         