import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

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
                
        }    // its for counting missing values 
             int missingCount = 0;

            for(String[] row : rows) {

             for(String value : row) {

             if(value.isEmpty()) {

                 missingCount++;


    }

}

                

            }
            System.out.println("Missing Values: " + missingCount);
                System.out.println("Rows: " + rows.size());

                System.out.println("Columns: " + rows.get(0).length);


            int duplicateCount = 0;

         for(int i = 1; i < rows.size(); i++) {

         for(int j = i + 1; j < rows.size(); j++) {

          if(Arrays.equals(rows.get(i), rows.get(j))) {

            duplicateCount++;

         }

    }

}

System.out.println("Duplicates: " + duplicateCount);

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