package G13_CENG211_HW4;

public class Car {
	
	private Model model;
	private static int totalRented;
	
	static {
		totalRented = 0;
	}
	
	public Car(Model model) {
		this.model = model;
		totalRented++;
	}

	public Model getModel() {
		return model;
	}
	
	public static int getTotalCarRented() {
		return totalRented;
	}
}
