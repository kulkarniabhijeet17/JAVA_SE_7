package com.javase7.sorttextfile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Map;
import java.util.TreeMap;

public class SortTextFileAsc {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new FileReader("FOStocks"));
		Map<String, String> map = new TreeMap<String, String>();
		String line = "";
		while ((line = reader.readLine()) != null) {
			map.put(getField(line), line);
		}
		reader.close();
		FileWriter writer = new FileWriter("FOStocksSorted");
		for (String val : map.values()) {
			writer.write(val);
			writer.write('\n');
		}
		writer.close();
	}

	private static String getField(String line) {
		return line.split(" ")[0];
	}
}