package G13_CENG211_HW4;

public abstract class Customer {
	
	private Id<String> id;
	private int rentedDay;
	
	public Customer(Id<String> id, int rentedDay) {
		this.id = id;
		this.rentedDay = rentedDay;
	}
	
	public Id<String> getId() {
		return id;
	}
	
	public int getRentedInterval() {
		return rentedDay;
	}
}
