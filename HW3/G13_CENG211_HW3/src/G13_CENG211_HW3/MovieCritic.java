package G13_CENG211_HW3;


public class MovieCritic extends Critic {
	
	private int movieInOneDay=0;
	private double rate;

	public MovieCritic(String criticName,double criticsOpinion) {
		super(criticName, criticsOpinion);
		
	}
	
	public int getMovieInOneDay() {
		return movieInOneDay;
	}

	public void setMovieInOneDay(int movieInOneDay) {
		this.movieInOneDay = movieInOneDay;
	}
	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}
	
	
	public boolean canCriticRate(Content content) 
	{
			if(movieInOneDay==0)
			{
				rate(content);
				return true;	
			}
			return false;
	}
	

	@Override
	public void rate(Content content) {
        Movie movie = (Movie) content;
		rate=movie.rated(getCriticsOpinion());
		movie.setRating(checkRating(rate));		
		movieInOneDay=1;  
	}

		
	@Override
	public Double checkRating(double rating) {
		
		if(rating>10)
		{
			return 10.0;
		}
		else if(rating<0)
		{
			return 0.0;
		}
		else
			return rating;
	}
}
