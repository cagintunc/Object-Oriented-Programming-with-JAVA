package G13_CENG211_HW3;

public class IndefiniteGame extends Game{
	
	
	public IndefiniteGame()
	{
		super();

	}
	
	public IndefiniteGame(int arrivalDay,String name, int duration,Double avarageRating)
	{
		super(arrivalDay,name,duration,avarageRating);
	}
	
	@Override
	public Double rated(double criticsOpinion) {
		
		double rate=this.getAvarageRating() +((10-getDuration())*0.25)+(criticsOpinion);
		setRating(rate);

		return getRating();
	}

	@Override
	public void setDurationForCritic() {
		this.setRemainDuration(4);
		
	}
}
