package G13_CENG211_HW3;

public class Movie extends Content{
	
	private int year;
	private MovieCritic critic;
	
	public Movie(int arrivalDay, String name,int year,int duration,Double avarageRating)
	{
		super(arrivalDay,name,duration,avarageRating);
		this.year=year;
	}
	
	public int  getYear()
	{
		return year;
	}
	
	public void setYear(int newYear)
	{
		this.year=newYear;
	}	
	
	public String toString()
	{
	  return(getName()+"("+year+")"+","+String.format("%.2f", getRating()));	
	}
	
	
    //rate movie's rating
	@Override
	public Double rated(double criticsOpinion) { 
		setRating(getAvarageRating()+((getDuration()-150)*0.01)-((2021-year)*0.01)+(criticsOpinion));
		return getRating();
	}
 
	//get critic who rates the movie
	public MovieCritic getCritic() {
		return new MovieCritic(critic.getCriticName(),critic.getCriticsOpinion());
	}
    //set critic who rates the movie
	public void setCritic(MovieCritic critic) {
		this.critic = new MovieCritic(critic.getCriticName(),critic.getCriticsOpinion());
	}

	@Override
	public void setDurationForCritic() {
		this.setRemainDuration(getDuration());
		
	}
}
