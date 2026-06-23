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

    for(String[] row : rows) {

        for(String value : row) {

            if(value.isEmpty()) {

                missingCount++;

            }

        }

        if(row.length < expectedColumns) {

            missingCount += (expectedColumns - row.length);

        }

    }

    return missingCount;

}

    public static int countDuplicates(ArrayList<String[]> rows) {

        int duplicateCount = 0;

        for(int i = 1; i < rows.size(); i++) {

            for(int j = i + 1; j < rows.size(); j++) {

                if(Arrays.equals(rows.get(i), rows.get(j))) {

                    duplicateCount++;

                }

            }

        }

        return duplicateCount;

    }

}