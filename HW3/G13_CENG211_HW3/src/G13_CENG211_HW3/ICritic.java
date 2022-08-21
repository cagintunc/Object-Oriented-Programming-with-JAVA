package G13_CENG211_HW3;

//critic interface has methods to be used for movie critic and game critic
public interface ICritic {
	
	public boolean canCriticRate(Content content);//check for critic has valid conditions for rating
	public void rate(Content content);           //rate movie or game while adding critic opinion
	public Double checkRating(double rating);   //check for is rate bigger or smaller than its conditions so setting rate
	
}
