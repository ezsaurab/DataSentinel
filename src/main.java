import model.Dataset;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;


public class main {

    public static void main(String[] args) {

    // Dataset ds = new Dataset(100,20);
    // System.out.println(ds.getrows());
    // System.out.println(ds.getcolumns());

try {
      File file = new File("sample.csv");
      FileReader fr= new FileReader(file);
      BufferedReader br =new BufferedReader(fr);
      System.out.println("file opened");

     String line  = br.readLine() ;
     System.out.println(
       line
     );

      fr.close();



       
    //  System.out.println(file.getAbsolutePath());
    //  System.out.println(file.exists());


    }
    catch(IOException e){


        System.out.println("Error in opening file:");
    }
    
    
    
    
    }

}