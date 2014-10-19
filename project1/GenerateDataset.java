/*
 * Copyright 2014, Robert Dyer,
 *                 and Bowling Green State University
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
/**
 * Class to generate datasets for use as input in Project 1 in CS 4120/5120.
 *
 * The main method expects 1 or 2 arguments.  If 1 argument is given, it outputs
 * a list of N (the argument) random integers, one per line.  If 2 arguments are
 * given, instead of random integers the second argument is used.
 *
 * The output can also be sorted by passing '-Dsorted=true' to java.
 * The output can also be reverse sorted by passing '-Dreversed=true' to java.
 * These flags work with both the 1 and 2 argument programs.
 *
 * Finally, everything is accessible and controllable from other Java classes
 * so that this program can be directly called.
 *
 * @author rdyer
 */
public class GenerateDataset {
	/** The maximum value to use when generating random numbers. */
	public static int MAX_VALUE = 1000000;
	/** If set, the output data will be sorted in increasing order. */
	public static boolean SORTED = false;
	/** If set, the output data will be sorted in decreasing order. */
	public static boolean REVERSE_SORTED = false;

	public static void main(final String[] args) {
		if (args.length == 0 || args.length > 2) {
			System.err.println("Usage: java GenerateDataset <size> [<value>]");
			System.exit(-1);
		}

		// check for -D flags on the command line
		//need to check more with property like -Dsorted=ture,REVERSE_SORTED=true;
		//or java -Dsorted=ture generatedatset 1000 1234 are not legal
		if (Boolean.parseBoolean(System.getProperty("sorted")))
			SORTED = true;
		if (Boolean.parseBoolean(System.getProperty("reversed")))
			REVERSE_SORTED = true;

		final List<Integer> values;
		final int size = Integer.parseInt(args[0]);

		// generate the list of data
		if (args.length == 1)
			values = randomData(size);
		else
			values = sameData(size, Integer.parseInt(args[1]));

		// optionally (reverse) sort the data
		if (SORTED || REVERSE_SORTED)
			Collections.sort(values);

		if (REVERSE_SORTED)
			Collections.reverse(values);

		// display the data, one per line
		StringBuffer sb = new StringBuffer();
		sb.append("./files/project1_maohua_");
		if(args.length==1){
			sb.append("random_");
			if(SORTED)
				sb.append("sorted_");
			if(REVERSE_SORTED)
				sb.append("reversed_");
		}
		else{
			sb.append("identical_");
			sb.append(Integer.parseInt(args[1])+"_");
		}
		
		
		sb.append(Integer.toString(size)+".txt");
		final String path=sb.toString();
		System.out.println(path);
		try{	
			File writename = new File(path);   
			writename.createNewFile();  
			System.out.println("create file sucessfully");
			BufferedWriter out = new BufferedWriter(new FileWriter(writename));
			for(Integer i:values)
			{
				out.write(Integer.toString(i)+"\r\n");
			}
			out.flush();  
			out.close();  
		}catch (Exception e) {  
	 		e.printStackTrace();  
	 	}  
	}

	/**
	 * Generates a list of random numbers.
	 *
	 * @param size the number of entries in the returned list
	 * @return a list with 'size' randomly generated integers in it
	 */
	public static List<Integer> randomData(final int size) {
		final List<Integer> output = new ArrayList<Integer>();

		for (int i = 0; i < size; i++)
			output.add((int)(Math.random() * MAX_VALUE));

		return output;
	}

	/**
	 * Generates a list of numbers all the same value.
	 *
	 * @param size the number of entries in the returned list
	 * @param value the value to use when generating the list
	 * @return a list with 'size' copies of 'value' in it
	 */
	public static List<Integer> sameData(final int size, final int value) {
		final List<Integer> output = new ArrayList<Integer>();

		for (int i = 0; i < size; i++)
			output.add(value);

		return output;
	}
}
