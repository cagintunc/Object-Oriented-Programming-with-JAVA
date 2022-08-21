package G13_CENG211_HW3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class GameMain 
{

	static Queue<GameCritic> gameCriticQueue = new LinkedList<> ();
	static ArrayList<Game> criticFinished = new ArrayList<Game>();
	static ArrayList<Game> criticUnfinished = new ArrayList<Game>();
    static ArrayList<Game> sortRateGameArr= new ArrayList<Game>();
	
    //critic get game from game stack,check for critic can rate game and then according to its return,game is added to finished or unfinished ArrayList
	public static void criticGetContentFromStack() 
    {
     int size= gameCriticQueue.size();
		
		for(int i=0;i<size;i++)
		{
			if(StackClass.getGameStack().size()>0)
			{
				Game game= StackClass.getGameStack().pop();
				GameCritic critic= gameCriticQueue.poll();
				game.setDurationForCritic();
				game.setCritic(critic);
				
				if(critic.canCriticRate(game))
				{
					
					criticFinished.add(game);
					System.out.println(game.getCritic().getCriticName()+" works on "+"(#"+game.getName()+")");
				}
				else {
				
					criticUnfinished.add(game);
				    System.out.println(game.getCritic().getCriticName()+" works on "+"(#"+game.getName()+")");
				}
			}
			
			
			   
		}
		
	}
    
    public  static ArrayList<Game>  getCopySortArr()
    {
		ArrayList<Game> temp = new ArrayList<Game>();
        for(Game game: sortRateGameArr) 
        {
        	temp.add(game);
        }
        return temp;
    }


	// sort finished game ArrayList by their name and print to screen
	public static void iterateContentSortArr() {
		sortRateGameArr.sort(new NameSorter());
		for(Game g: getCopySortArr())
		{
			System.out.println("#"+g.getName()+", "+g.getRating());
			
		}
		
	}

	

	
	public static ArrayList<Game> getCopyCriticUnfinishedArr()
	{
		ArrayList<Game> temp = new ArrayList<Game>();
		for(Game game : criticUnfinished)
		{
			temp.add(game);
		}
		return temp;
	}
	
	public  static ArrayList<Game> getCopyCriticFinishedArr()
	{
		ArrayList<Game> temp = new ArrayList<Game>();
		for(Game game : criticFinished)
		{
			temp.add(game);
		}
		return temp;

	}

    //setting game critics work hours to beginning values 
	public static void setForNewDay(ArrayList<Game> arr) {
		
		for(Game game: arr)
		{
			game.getCritic().setWorkHours(8);
		}
		
	}
	
	/*if a game is not finished in one day ,it checks that is game finished this day. if it is finished ,added to criticFinished 
	 if it is not, it still remain in criticUnfinished ArrayList
	 */
	public static void checkUnfinishedGameFinished() 
	{
		
		for(Game g : getCopyCriticUnfinishedArr() )
		{
			if(g.getCritic().canCriticRate(g))
			{
				criticFinished.add(g);
				criticUnfinished.remove(g);
			}
		}
		getCopyCriticUnfinishedArr().clear();
		
	}

	/*finished games sorted and printed to screen 
	 * if a critic has still work hours to rate game in a day ,critic get game from stack and  if game is finished ,it is added to ArrayList to be sorted
	 */
	public static void iterateFinishedContents() {
        criticFinished.sort(new DurationSorter());
		
		for(Game gg: getCopyCriticFinishedArr())
		{
			System.out.println(gg.getCritic().getCriticName()+" evaluated "+ "(#"+gg.getName()+")");
			gameCriticQueue.add(gg.getCritic());
			sortRateGameArr.add(gg);
			criticFinished.clear();
			criticGetContentFromStack();
			if(criticFinished.size()>0)
			{
				iterateFinishedContents();
			}
			
		}
		
	}

	
}
