package G13_CENG211_HW2;

import java.util.*;

public class Main {
	private ApplicantManagementApp managementApp;
	
	// Default constructor
	public Main() {
		
	}
	
	public static void main(String[] args) {
		FileIO fileIO = new FileIO("HW2_ApplicantsInfo.csv");
		Main mainProgram = new Main();
		mainProgram.setUp(fileIO);
	}
	
	public void setUp(FileIO fileIO) {
		ArrayList<ArrayList<String>> allData = fileIO.getAllData();
		managementApp = new ApplicantManagementApp(allData); 
		managementApp.seeApplicant();
	}
}
