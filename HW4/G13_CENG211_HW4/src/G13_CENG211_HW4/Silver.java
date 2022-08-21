package G13_CENG211_HW4;

public class Silver implements ICustomer {
	private static int totalNumber;
	
	public Silver() {
		super();
		totalNumber++;
	}
	
	public double getDiscountCoef() {
		return 0.2;
	}
	
	public String toString() {
		return "Silver";
	}
	
	public static int getTotalNumber() {
		return totalNumber;
	}
	
}
