package lab3b;


import java.nio.file.Paths;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Arrays;

public class Lab3B {


    public static void main(String[] args) {
       
          
        /* Row Objects */
        
        ArrayList<String> keys;             // Holds key names from header row
        ArrayList<String> values;           // Holds the values read from subsequent rows
        
        HashMap<String, String> row;        // Holds the key/value pairs for each data row

        String line, header;

        /* Container for File Data */
        
        ArrayList data = new ArrayList<>(); // Create ArrayList to hold HashMaps for all rows
        
        try {
            
            /* Attempt to open input file */

            Scanner in = new Scanner(Paths.get("lab03b_input.csv"), "UTF-8");
            
            /* Get list of keys from the header row; split into an ArrayList */
            
            header = in.nextLine();
            keys = new ArrayList(Arrays.asList(header.split(",")));
            
            /* Read and process every subsequent row (record) in CSV file */
            
            while ( in.hasNextLine() ) {
                
                /* Get next line */
                
                line = in.nextLine();
                
                /* Create new map for current row */
                
                row = new HashMap<>();
                
                /* Split comma-separated values into ArrayList */
                
                values = new ArrayList(Arrays.asList(line.split(",")));
                
                /* Populate map, using key names from the header row */
                
                for (int i = 0; i < keys.size(); i++) {
                    
                    row.put(keys.get(i), values.get(i));
                    
                }
                
                /* Add map to data container */
                
                data.add(row);

            }
            
            /* Print number of records read from file (should be 500, not including header) */
            
            System.out.println("Number of records read: " + data.size());
            
            /* Close input file */
            
            in.close();

            /* Parse data from records; print as formatted address blocks */


            
            for (int i = 0; i < data.size(); ++i) {
                row = (HashMap)data.get(i);
                 
                 String firstname = row.get("FirstName");
                 String middleI = row.get("MiddleInitial");
                 String lastname = row.get("LastName");
                 String streetAd = row.get("StreetAddress");
                 String city = row.get("City");
                 String state = row.get("State");
                 String zipCode = row.get("ZipCode");
                 
                 
                 System.out.println( "\n" + firstname + " " + middleI + " " + lastname + " ");
                 System.out.println(streetAd + " ");
                 System.out.println(city + ", " + state + " " + zipCode);
                 
                }
            
        }
        
        catch (Exception e) {
            
            System.err.println(e.toString());
            
        }
        
    }

}

