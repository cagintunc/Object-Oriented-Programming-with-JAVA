package G13_CENG211_HW3;

public abstract class Game extends Content  {
	
	private GameCritic critic;
	
	
	public Game()
	{
	  super();
	}
	
	
	public Game(int arrivalDay,String name,int duration,Double avarageRating)
	{
		super(arrivalDay,name,duration,avarageRating);
		
	}
	
	
	public GameCritic getCritic()
	{
		return new GameCritic(critic.getCriticName(),critic.getCriticsOpinion(),critic.getWorkHours());
	}
	
	public void setCritic(GameCritic newCritic)
	{
		critic=new GameCritic(newCritic.getCriticName(),newCritic.getCriticsOpinion(),newCritic.getWorkHours());
	}
	
}
