package G13_CENG211_HW4;

public class Model {
	private int year;
	private double basePrice;
	private String name;
	private double yearRatio;
	
	public Model(String name, int year, double baseP) {
		this.name = name;
		this.year = year;
		basePrice = baseP;
		initializeYearRatio();
	}

	public double getBasePrice() {
		return basePrice;
	}

	public int getYear() {
		return year;
	}
	
	public double getYearRatio() {
		return yearRatio;
	}

	public String getName() {
		return name;
	}

	private final void initializeYearRatio() {
		if(year == 2022) {
			yearRatio = 1;
		} else if((year == 2020)||(year == 2021)) {
			yearRatio = 0.95;
		} else if((year <= 2019)&&(year >= 2017)) {
			yearRatio = 0.9;
		}
	}
}
