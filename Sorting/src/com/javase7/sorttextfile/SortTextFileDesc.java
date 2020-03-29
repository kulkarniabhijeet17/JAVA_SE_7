package com.javase7.sorttextfile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class SortTextFileDesc {
	public static void main(String[] args) throws IOException {
		ArrayList<String> al = new ArrayList<String>();
		BufferedReader reader = new BufferedReader(new FileReader("Non_index.txt"));

		String line = "";
		while ((line = reader.readLine()) != null) {
			al.add(getField(line));
		}
		reader.close();

		Collections.sort(al, Collections.reverseOrder());
		FileWriter writer = new FileWriter("Non_indexSorted.txt");
		for (String val : al) {
			writer.write(val);
			writer.write('\n');
		}
		writer.close();
	}

	private static String getField(String line) {
		return line.split(" ")[0];
	}
}