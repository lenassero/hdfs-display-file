package cs.bigdata.Tutorial2;

import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;

import java.io.*;
import java.util.Arrays;

import org.apache.hadoop.fs.*;
import org.apache.hadoop.fs.FileSystem;

public class DisplayISDHistory {

	public static void main(String[] args) throws IOException {
		
		// New Configuration
		Configuration conf = new Configuration();
		FileSystem fs = FileSystem.get(conf);
		
		// Check if the input file specified exists
		String input_file_name = args[0];
		Path path_input = new Path(input_file_name);
		System.out.println("Displaying output of "+ path_input);
	    if (!fs.exists(path_input)) {
	      System.out.println("File " + input_file_name + " does not exist");
	      return;
	    }   
	    FSDataInputStream in = fs.open(path_input);
		
		try{
			InputStreamReader isr = new InputStreamReader(in);
			BufferedReader br = new BufferedReader(isr);

			// Read line by line, don't process the 22 first lines (header)
			for (int i=1; i<23; i++){
				String line = br.readLine();
			}
			// Jump to the next line
			String line = br.readLine();
			
			while (line !=null){
				// Process of the current line
				String[] splitted_line = line.split("");
				String usafCode = StringUtils.join(Arrays.copyOfRange(splitted_line, 1, 7), "");
				String name = StringUtils.join(Arrays.copyOfRange(splitted_line, 14, 43), "").trim();
				String countryID = StringUtils.join(Arrays.copyOfRange(splitted_line, 44, 46), "");
				String elevation = StringUtils.join(Arrays.copyOfRange(splitted_line, 75, 82), "");
				
				// Display information about the station
				System.out.println(new Station(usafCode, name, countryID, elevation).toString());
				
				// Go to the next line
				line = br.readLine();
			}
		}
		
		finally{
			// Close the file
			in.close();
			fs.close();
		}
 
		
		
	}

}
