package cs.bigdata.Tutorial2;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;

import java.io.*;

import org.apache.hadoop.fs.*;
import org.apache.hadoop.fs.FileSystem;

public class DisplayTrees {

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
	    
	    // UNCOMMENT IF WE WANT TO WRITE THE OUTPUT ON A FILE
	    // Check if the output file specified exists
//	    String output_file_name = args[1];
//	    Path path_output = new Path(output_file_name);
//	    if (fs.exists(path_output)) {
//		      System.out.println("File " + output_file_name + " exists, it is deleted!");
//		      fs.delete(path_output, true);
//		    } 
//	    FSDataOutputStream out = fs.create(path_output);
		
		try{
			InputStreamReader isr = new InputStreamReader(in);
			BufferedReader br = new BufferedReader(isr);
			
			// Read line by line, don't process the first line (header)
			String line = br.readLine();
			// Jump to the second line
			line = br.readLine();
			
			while (line !=null){
				// Process of the current line
				String year = line.split(";")[5];
				String height = line.split(";")[6];
				// Display the year and height of each tree
				System.out.println(new Tree(year,height).toString());
			    // UNCOMMENT IF WE WANT TO WRITE THE OUTPUT ON A FILE
				// Tree tree = new Tree(year, height);
				// String tree_string = tree.toString();
				// (new Tree(year, height)).printTree();
				// out.writeBytes(tree_string);
				// out.writeBytes("\n");
				
				// Go to the next line
				line = br.readLine();

			}
		}
		finally{
			// Close the file
			in.close();
		    // UNCOMMENT IF WE WANT TO WRITE THE OUTPUT ON A FILE
			// out.close();
			fs.close();
		}
 
		
		
	}

}
