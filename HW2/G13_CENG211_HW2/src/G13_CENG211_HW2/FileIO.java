package G13_CENG211_HW2;

import java.io.*;
import java.util.*;

public final class FileIO {
	private String fileName;
	private BufferedReader bufferedReader;
	private ArrayList<ArrayList<String>> allData;
	
	public FileIO(String name) {
		fileName = name;
		allData = new ArrayList<ArrayList<String>>(); 
		setUp();
	}
	
	private final void setUp() {
		String allLines = "";
		try {
			bufferedReader = new BufferedReader(new FileReader(fileName));
			String line = null;
			
			while((line = bufferedReader.readLine()) != null) {
				allLines = allLines + line + ";";
			}
			fillTheArray(allLines);
			
		} catch(FileNotFoundException ex) {
			System.out.println("File does not found.");
			System.exit(0);
		} catch(IOException ex) {
			System.out.println("IO exception.");
			System.exit(0);
		}
	}
	private void fillTheArray(String allLines) {
		String[] tempRow = allLines.split(";");
		for(int row = 0; row < tempRow.length; row++) {
			String[] tempCol = tempRow[row].split(",");
			ArrayList<String> tempAL = new ArrayList<String>();
			for(int index = 0; index < tempCol.length; index++) {
				tempAL.add(tempCol[index]);
			}
			allData.add(tempAL);
		}
	}
	
	public ArrayList<ArrayList<String>> getAllData() {
		ArrayList<ArrayList<String>> temp1 = new ArrayList<ArrayList<String>>();
		for(ArrayList<String> list : allData) {
			ArrayList<String> temp2 = new ArrayList<String>();
			for(String data : list) {
				temp2.add(data);
			}
			temp1.add(temp2);
		}
		return temp1;
	}
}
