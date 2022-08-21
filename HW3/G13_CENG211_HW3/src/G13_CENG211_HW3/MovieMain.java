package G13_CENG211_HW3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//it is a kind of main class for movies
public class MovieMain {
	
	public static Queue<MovieCritic> movieCriticQueue = new LinkedList<> ();
    public static ArrayList<Movie> movieCriticFinished = new  ArrayList<Movie>();
	public static ArrayList<Movie> sortRateMovieArr = new ArrayList<Movie> ();


	//critic get movie from stack to rate
	public static void criticGetContentFromStack() {

		int size =movieCriticQueue.size();
		for(int i=0;i<size;i++)
		{
			if(StackClass.getMovieStack().size()>0)
			{
				Movie movie = StackClass.getMovieStack().pop();
				MovieCritic critic =  movieCriticQueue.poll();
				movie.setDurationForCritic();
				movie.setCritic(critic);
				if(critic.canCriticRate(movie))
				{
					movieCriticFinished.add(movie);//when critic finished movie, movie is added to movieCriticFinished ArrayList
					sortRateMovieArr.add(movie);//and it is also added to sortRateMovieArr to be sorted
					
				}
			}
			
		}
		
	}
	
	 
    public  static ArrayList<Movie>  getCopySortArr()
    {
		ArrayList<Movie> temp = new ArrayList<Movie>();
        for(Movie movie: sortRateMovieArr) 
        {
        	temp.add(movie);
        }
        return temp;
    }

	//finished movies sorted by their name and printed to screen
	public static void iterateContentSortArr() {
		sortRateMovieArr.sort(new NameSorter());
		for(Movie m: getCopySortArr())
		{
			System.out.println("#"+m.getName()+", "+String.format("%.2f",m.getRating()));
		}
		
	}
	
	//when critics finished rating movie ,critic goes to queue's end, movies are printed sort by name
	public static void iterateFinishedContents() {
		movieCriticFinished.sort(new DurationSorter());
    	for(Movie movie: movieCriticFinished)
    	{
    		System.out.println(movie.getCritic().getCriticName()+" evaluated "+"(#"+ movie.getName()+")");
    		movieCriticQueue.add(movie.getCritic());
    	}
    	movieCriticFinished.clear();
		
	}
}
