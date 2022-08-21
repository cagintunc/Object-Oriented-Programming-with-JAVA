package G13_CENG211_HW4;

import java.util.*;
import java.io.*;

public class FileIO {
	private String name;
	private ArrayList<ArrayList<String>> info;
	
	public FileIO(String name) {
		this.name = name;
		info = new ArrayList<ArrayList<String>>();
	}
	
	public ArrayList<ArrayList<String>> getFileInfo() {
		
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(name));
			String line = null;
			while((line = bufferedReader.readLine()) != null) {
				info.add(parseInfo(line));
			}
			bufferedReader.close();
		} catch(FileNotFoundException ex) {
			ex.printStackTrace();
		} catch(IOException ex) {
			ex.printStackTrace();
		}
		return info;
	}
	private ArrayList<String> parseInfo(String line) {
		ArrayList<String> result = new ArrayList<String>();
		String[] tokens = line.split(",");
		for(String row : tokens) {
			result.add(row);
		}
		return result;
	}
}
