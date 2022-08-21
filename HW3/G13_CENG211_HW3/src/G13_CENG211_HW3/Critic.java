package G13_CENG211_HW3;

public abstract class Critic implements ICritic {
   
	
	private double criticsOpinion;
    private String criticName;
	
	
	public Critic(String criticName,double criticsOpinion)
	{
		this.criticsOpinion= criticsOpinion;
		this.setCriticName(criticName);
		
	}
	
	public double getCriticsOpinion()
	{
		return criticsOpinion;
	}
	
	public void setCriticOpinion(double newCriticOpinion)
	{
		this.criticsOpinion=newCriticOpinion;
	}

	public String getCriticName() {
		return criticName;
	}

	public void setCriticName(String criticName) {
		this.criticName = criticName;
	}

}
