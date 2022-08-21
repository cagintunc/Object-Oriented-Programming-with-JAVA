package G13_CENG211_HW4;

public class Platinum implements ICustomer {
	private static int totalNumber;
	
	public Platinum() {
		super();
		totalNumber++;
	}
	
	public double getDiscountCoef() {
		return 0.3;
	}
	
	public String toString() {
		return "Platinum";
	}
	
	public static int getTotalNumber() {
		return totalNumber;
	}

}
