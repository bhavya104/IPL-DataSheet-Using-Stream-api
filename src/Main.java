import java.io.*;
import com.opencsv.*;
import java.io.FileNotFoundException;
import java.util.*;
public class Main {

	
	public static void main(String[] args) throws FileNotFoundException {
		
		String fileName = "matches.csv";
		FileReader file = new FileReader("/home/kashish/Desktop/IPL/" + fileName);
		try { 
	        // Create an object of file reader 
	        // class with CSV file as a parameter. 
			String fileN = "matches.csv";
			FileReader filereader = new FileReader("/home/kashish/Desktop/IPL/" + fileN);
	  
	        // create csvReader object and skip first Line 
			CSVParser parser = new CSVParserBuilder().withSeparator(';').build(); 
			  
	        // create csvReader object with parameter 
	        // filereader and parser 
	        CSVReader csvReader = new CSVReaderBuilder(filereader) 
	                                  .withCSVParser(parser) 
	                                  .build(); 
	  
	        // Read all data at once 
	        List<String[]> allData = csvReader.readAll(); 
	  
	        // Print Data. 
	        for (String[] row : allData) { 
	            for (String cell : row) { 
	                System.out.print(cell + "\t"); 
	            } 
	            System.out.println(); 
	        } 
	    } 
	    catch (Exception e) { 
	        e.printStackTrace(); 
	    } 
		
		
	}
	
}
