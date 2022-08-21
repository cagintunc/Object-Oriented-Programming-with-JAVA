package G13_CENG211_HW3;


//Content class is a base class of Game and Movie class and implement contentInterface
public abstract class Content implements IContent {
	
	private int arrivalDay;
	private String name;
	private Double avarageRating;
	private int duration;
	private Double rating;
	private int remainDuration;

	
	public Content()
	{
		this.arrivalDay=-1;
		this.name=null;
		this.avarageRating=-0.1;
		this.duration=0;
	}
	
	public Content(int arrivalDay, String name,int duration,Double avarageRating)
	{
		this.arrivalDay=arrivalDay;
		this.name = name;
		this.avarageRating=avarageRating;
		this.setDuration(duration);
	}
	
	public int getArrivalDay()
	{
		return arrivalDay;
	}
	public void setArrivalDay(int newArrivalDay)
	{
		this.arrivalDay=newArrivalDay;
	}
	
	public String getName()
	{
		return name;
	}
	public void setName(String newName)
	{
		this.name=newName;
	}
	
	public Double getAvarageRating()
	{
		return avarageRating;
	}
	
	public void setAvarageRating(Double newAvarageRating)
	{
		this.avarageRating= newAvarageRating;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public int getRemainDuration() {
		return remainDuration;
	}

	public void setRemainDuration(int remainDuration) {
		this.remainDuration = remainDuration;
	}
	
}
