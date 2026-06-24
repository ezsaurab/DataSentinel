import java.util.ArrayList;
import java.util.Arrays;

public class DataProfiler {

    public static int countRows(ArrayList<String[]> rows) {

        return rows.size();

    }

    public static int countColumns(ArrayList<String[]> rows) {

        return rows.get(0).length;

    }

    public static int countMissingValues(ArrayList<String[]> rows) {

        int missingCount = 0;

        int expectedColumns = rows.get(0).length;

        for (String[] row : rows) {

            for (String value : row) {

                if (value.isEmpty()) {

                    missingCount++;

                }

            }

            if (row.length < expectedColumns) {

                missingCount += (expectedColumns - row.length);

            }

        }

        return missingCount;

    }

    public static int countDuplicates(ArrayList<String[]> rows) {

        int duplicateCount = 0;

        for (int i = 1; i < rows.size(); i++) {

            for (int j = i + 1; j < rows.size(); j++) {

                if (Arrays.equals(rows.get(i), rows.get(j))) {

                    duplicateCount++;

                }

            }

        }

        return duplicateCount;

    }

    public static void columnCompleteness(ArrayList<String[]> rows) {

        String[] header = rows.get(0);

        for (int col = 0; col < header.length; col++) {

            int missingCount = 0;

            for (int row = 1; row < rows.size(); row++) {

                String[] currentRow = rows.get(row);

                if (col >= currentRow.length) {

                    missingCount++;

                }
                else if (currentRow[col].isEmpty()) {

                    missingCount++;

                }

            }

            System.out.println(
                header[col] + " -> Missing: " + missingCount
            );

        }

    }

    public static boolean isInteger(String value) {

        try {

            Integer.parseInt(value);

            return true;

        }
        catch (NumberFormatException e) {

            return false;

        }

    }

    public static void detectColumnTypes(ArrayList<String[]> rows) {

        String[] header = rows.get(0);

        for (int col = 0; col < header.length; col++) {

            boolean allIntegers = true;

            for (int row = 1; row < rows.size(); row++) {

                String[] currentRow = rows.get(row);

                if (col >= currentRow.length) {

                    continue;

                }

                String value = currentRow[col];

                if (value.isEmpty()) {

                    continue;

                }

                if (!isInteger(value)) {

                    allIntegers = false;

                    break;

                }

            }

            if (allIntegers) {

                System.out.println(
                    header[col] + " -> Integer"
                );

            }
            else {

                System.out.println(
                    header[col] + " -> String"
                );

            }

        }

    }

}