import java.io.*;
import java.util.ArrayList;

public class main {

    public static void main(String[] args) {

        try {

            ArrayList<String[]> rows =
             CSVLoader.loadCSV(
                "sample.csv"
             );

            

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

            System.out.println();

             System.out.println("===== DATA QUALITY SCORES =====");

             System.out.printf(
                 "Completeness Score: %.2f%%\n",
                 DataProfiler.completenessScore(rows)
             );

             System.out.printf(
                 "Uniqueness Score: %.2f%%\n",
                             DataProfiler.uniquenessScore(rows)
             );

             System.out.printf(
                 "Overall Quality Score: %.2f%%\n",
                 DataProfiler.overallQualityScore(rows)
             );

        }
        catch(IOException e) {

            System.out.println(
                "Error reading file: " +
                e.getMessage()
            );

        }

    }

}