package G13_CENG211_HW3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileIO {
	private String fileName;
	private BufferedReader bufferedReader;
	private static ArrayList<ArrayList<String>> allData;
	static ArrayList<Game> gamesArr = new ArrayList<Game>();
	static ArrayList<Movie> moviesArr = new ArrayList<Movie>();
	
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
	
	public static void setUp(FileIO fileIO) 
	{
		 fileIO.getAllData();
		
		for(ArrayList<String> element: allData)
		{

			if(element.get(1).equals("0"))
			{
				moviesArr.add(new Movie( Integer.parseInt(element.get(0)),element.get(2), Integer.parseInt(element.get(3)) , Integer.parseInt(element.get(4)),  Double.parseDouble(element.get(5)) ));
			}
			else
			{
				if(element.get(1).equals("1"))
				{
					gamesArr.add(new IndefiniteGame(Integer.parseInt(element.get(0)),  element.get(2),Integer.parseInt(element.get(3)) , Double.parseDouble(element.get(4)))) ;
				}
				else if(element.get(1).equals("2"))
				{
					
					gamesArr.add(new StoryGame(Integer.parseInt(element.get(0)),  element.get(2), Integer.parseInt(element.get(3)), Double.parseDouble(element.get(4)))) ;
					
				}
				else
				{
					gamesArr.add(new CasualGame(Integer.parseInt(element.get(0)),  element.get(2), Integer.parseInt(element.get(3)) , Double.parseDouble(element.get(4)))) ;
				}
						
			   
			}
		}
      }
	
	@SuppressWarnings("unchecked")
	public static ArrayList<Game> getGamesArrFromFile()
    {
    	   ArrayList<Game> copyGameArr = (ArrayList<Game>) gamesArr.clone();
    	   return copyGameArr;   
    }
	
	@SuppressWarnings("unchecked")
	public static ArrayList<Movie> getMoviesArrFromFile()
	{
		ArrayList<Movie> copyMovieArr =(ArrayList<Movie>) moviesArr.clone();
		return copyMovieArr;
	}
}



