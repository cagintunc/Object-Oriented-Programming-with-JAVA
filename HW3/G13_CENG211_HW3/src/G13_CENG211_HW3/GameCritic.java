package G13_CENG211_HW3;

public class GameCritic extends Critic {
	
	private int workHours;
	private double rate;
	public GameCritic(String criticName,double criticsOpinion,int workHours)
	{
		super(criticName,criticsOpinion);
		this.setWorkHours(workHours);
	}
	
	public int getWorkHours() {
		return workHours;
	}

	public void setWorkHours(int workHours) {
		this.workHours = workHours;
	}
	
	public double getRate() {
		return rate;
	}

    
	public void setRate(double rate) {
		this.rate = rate;
	}

	public void rate(Content content) {
		
		Game game = (Game) content;
		rate=game.rated(getCriticsOpinion());
		game.setRating(checkRating(rate));

	}

	@Override
	public Double checkRating(double rating) { 
		
		if(rating>100)
		{
			return  100.0;
		}
		else if(rating<0)
		{
			return  0.0;
		}
		else
		{
			return rating;

		}
	}
	
	public boolean didCriticPlayEnoughHour(Game game) 
	{
	  if(game.getRemainDuration()<=getWorkHours())
		{
		    setWorkHours(getWorkHours()-game.getRemainDuration());
			return true;
		}
		else
		{
	        game.setRemainDuration(game.getRemainDuration()-getWorkHours());
			setWorkHours(0);
			return false;

		}
	}
	
	public boolean canCriticRate(Content content)
	{
		Game newContent = (Game) content;
		if(workHours>=0 && workHours<=8)
		{
	     if(didCriticPlayEnoughHour(newContent))
		  {
			 rate(newContent);
			 
				  return true;
		  }
		  
	    }
		return false;
	}	
}
