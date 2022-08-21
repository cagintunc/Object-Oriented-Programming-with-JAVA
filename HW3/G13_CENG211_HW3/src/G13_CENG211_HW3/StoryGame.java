package G13_CENG211_HW3;

public class StoryGame extends Game{
	
	
	public StoryGame()
	{
		super();
	}
	
	public StoryGame(int arrivalDay,String name,int duration,Double avarageRating)
	{
		super(arrivalDay,name,duration,avarageRating);
	}

	@Override
	public Double rated(double criticsOpinion) {
		
		double rate =this.getAvarageRating()+(this.getDuration()*0.25)+(criticsOpinion);
		setRating(rate);
        return getRating();	
	}

	@Override
	public void setDurationForCritic() {
         this.setRemainDuration(getDuration());		
	}	

}
