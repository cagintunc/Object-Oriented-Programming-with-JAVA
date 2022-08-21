package G13_CENG211_HW3;

import java.util.*; 

public class StackClass {

	private static Stack<Movie> movies = new Stack<>();
	private static Stack<Game> games = new Stack<>();
	
	//add movies to movie stack according to their arrival day
	public static void constructMovieStack(ArrayList<Movie> movieArr,int whichDay)
	{
	   for(Movie element: movieArr)
	   {
		   if(whichDay==1)
		   {

			 if(element.getArrivalDay()==1)
					 movies.push(element);   
		   }
		   else if(whichDay==2)
		   {
			   if(element.getArrivalDay()==2)
				     movies.push(element); 
		   }
		   else if(whichDay==3)
		   {
			   if(element.getArrivalDay()==3)
				     movies.push(element); 
		   }
		   else if(whichDay==4)
		   {
			   if(element.getArrivalDay()==4)
				     movies.push(element); 
		   }
		   else if(whichDay==5)
		   {
			   if(element.getArrivalDay()==5)
				     movies.push(element); 
		   }
	   }
	}
	//add games to game stack according to their arrival day
	public static void constructGameStack(ArrayList<Game> gameArr,int whichDay)
	{
		for(Game element: gameArr)
		   {
			 if(whichDay==1)
			 {
				 if(element.getArrivalDay()==1)
					    games.push(element);    
			 }
			  else if(whichDay==2) 
			  {
				  if(element.getArrivalDay()==2)
						games.push(element); 
			  }
			  else if(whichDay==3)
			  {
				  if(element.getArrivalDay()==3)
						games.push(element);
			  }
			  else if(whichDay==4)
			  {
				  if(element.getArrivalDay()==4)
						games.push(element);
			  }
			  else if(whichDay==5)
			  {
				  if(element.getArrivalDay()==5)
						games.push(element);
			  }
		   }	
	}
	
	public static Stack<Movie> getMovieStack()
	{
		
		return movies;
	}
	
	public static Stack<Game> getGameStack()
	{
		return games;
	}

}
