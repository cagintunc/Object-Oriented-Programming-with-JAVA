package G13_CENG211_HW4;

public class Gold implements ICustomer {
	private static int totalNumber;

	public Gold() {
		super();
		totalNumber++;
	}
	
	public double getDiscountCoef() {
		return 0.25;
	}
	
	public String toString() {
		return "Gold";
	}
	
	public static int getTotalNumber() {
		return totalNumber;
	}

}
