package G13_CENG211_HW3;


public class ContentRatingCompanyApp {
	
    public static void main(String[] args) 
    {
			
      FileIO fileIO = new FileIO("contents.csv");
	  FileIO.setUp(fileIO);
	  
	  MovieMain.movieCriticQueue.add(new MovieCritic("1. movie critic",0.1));
	  MovieMain.movieCriticQueue.add(new MovieCritic("2. movie critic",-0.2));
	  MovieMain.movieCriticQueue.add(new MovieCritic("3. movie critic",0.3));
		
	  GameMain.gameCriticQueue.add(new GameCritic("1. game critic",5,8));
	  GameMain.gameCriticQueue.add(new GameCritic("2. game critic",9,8));
	  GameMain.gameCriticQueue.add(new GameCritic("3. game critic",-3,8));
	  GameMain.gameCriticQueue.add(new GameCritic("4. game critic",2,8));
	  GameMain.gameCriticQueue.add(new GameCritic("5. game critic",-7,8));
	  
	  for(int i=1;i<6;i++) {
		 
		  System.out.println(i+"."+"Day:");
		  StackClass.constructMovieStack(FileIO.getMoviesArrFromFile(), i);
		  StackClass.constructGameStack(FileIO.getGamesArrFromFile(), i);
		  
		  MovieMain.criticGetContentFromStack();
		  MovieMain.iterateFinishedContents();
		  
		  GameMain.checkUnfinishedGameFinished();
          GameMain.criticGetContentFromStack();
		  GameMain.iterateFinishedContents();
		  System.out.println();
		  GameMain.setForNewDay(GameMain.criticFinished);
		  GameMain.setForNewDay(GameMain.criticUnfinished);
		}
	    System.out.println();
	    System.out.println("Ratings:");
	    System.out.println();
	    MovieMain.iterateContentSortArr();
	    System.out.println();
	    GameMain.iterateContentSortArr();
    }
}
