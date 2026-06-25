import java.io.*;

import model.Dataset;

public class main {

    public static void main(String[] args) {

        try {

            Dataset dataset = CSVLoader.loadCSV("sample.csv");

            System.out.println("========== DATASET PROFILE ==========");

            System.out.println(
                "Rows: " +
                DataProfiler.countRows(dataset.getData())
            );

            System.out.println(
                "Columns: " +
                DataProfiler.countColumns(dataset.getData())
            );

            System.out.println(
                "Missing Values: " +
                DataProfiler.countMissingValues(dataset.getData())
            );

            System.out.println(
                "Duplicates: " +
                DataProfiler.countDuplicates(dataset.getData())
            );

            System.out.println();

            System.out.println("===== COLUMN COMPLETENESS REPORT =====");

            DataProfiler.columnCompleteness(dataset.getData());

            System.out.println();

            System.out.println("===== DATA TYPE DETECTION =====");

            DataProfiler.detectColumnTypes(dataset.getData());

            System.out.println();

            System.out.println("===== DATA QUALITY SCORES =====");

            System.out.printf(
                "Completeness Score: %.2f%%\n",
                DataProfiler.completenessScore(dataset.getData())
            );

            System.out.printf(
                "Uniqueness Score: %.2f%%\n",
                DataProfiler.uniquenessScore(dataset.getData())
            );

            System.out.printf(
                "Overall Quality Score: %.2f%%\n",
                DataProfiler.overallQualityScore(dataset.getData())
            );

            System.out.println();

            System.out.println("========= PROFILE COMPLETE =========");

        }
        catch (IOException e) {

            System.out.println(
                "Error reading file: " + e.getMessage()
            );

        }

    }

}