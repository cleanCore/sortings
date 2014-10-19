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
package project1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* @author maohua zheng made a change in 10-16
 * 
 * thanks fro dr dyer
 *
 */
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


public class GenerateIntegerDataset {
	/** The maximum value to use when generating random numbers. */
	public static int MAX_VALUE = 1000000;
	/** If set, the output data will be sorted in increasing order. */
	public static boolean SORTED = false;
	/** If set, the output data will be sorted in decreasing order. */
	public static boolean REVERSE_SORTED = false;

	public static List<Integer> Generate(final String flag, final int[] args) {
		if (args.length == 0 || args.length > 2) {
			System.err.println("Usage: java GenerateDataset <size> [<value>]");
			System.exit(-1);
		}

		// check for -D flags on the command line
		//if (Boolean.parseBoolean(System.getProperty("sorted")))
		if(flag.equals("sorted"))
			SORTED = true;
		else 
			SORTED=false;
		
		if (flag.equals("reversed"))//Boolean.parseBoolean(System.getProperty("reversed")))
			REVERSE_SORTED = true;
		else 
			REVERSE_SORTED=false;
		
		final List<Integer> values;
		final int size = //Integer.parseInt(
				args[0];
						//);

		// generate the list of data
		if (args.length == 1)
			values = randomData(size);
		else
			values = sameData(size, //Integer.parseInt(
					args[1]);
					//);

		// optionally (reverse) sort the data
		if (SORTED || REVERSE_SORTED)
			Collections.sort(values);

		if (REVERSE_SORTED)
			Collections.reverse(values);

		// display the data, one per line
		for (final int i : values)
			System.out.println(i);
		return values;
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
