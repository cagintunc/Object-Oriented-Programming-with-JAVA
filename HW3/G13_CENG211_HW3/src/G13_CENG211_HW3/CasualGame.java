package G13_CENG211_HW3;

public class CasualGame extends Game {
	
	
	public CasualGame()
	{
		super();
	}
	
	public CasualGame(int arrivalDay,String name, int duration,Double avarageRating)
	{
		super(arrivalDay,name,duration,avarageRating);
	}
	
	@Override
	public Double rated(double criticsOpinion) {
		
		double rate= this.getAvarageRating()+((getDuration()-3)*3)+(criticsOpinion);
		setRating(rate);

		return getRating();
	}

	@Override
	public void setDurationForCritic() {
		
		this.setRemainDuration(3*getDuration());
		
	}	
	
}
