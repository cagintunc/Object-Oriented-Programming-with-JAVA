package G13_CENG211_HW4;

import java.util.*;

public abstract class CarRental {
	
	private Map<Customer, Car> rentals;
	private int rentalCode;
	
	public CarRental() {
		rentals = new HashMap<Customer, Car>();
		rentalCode = getCode();
	}

	public Map<Customer, Car> getCars() {
		return rentals;
	}
	
	public void addCustomer(Customer customer, Car car) {
		rentals.put(customer, car);
	}

	public int getRentalCode() {
		return rentalCode;
	}
	
	public abstract void displayRental();
	public abstract double getPrice(Model model, Customer customer);
	
	private final int getCode() {
		String temp = "";
		int result;
		for(int i = 1; i <= 7; i++) {
			int digit;
			if(i == 1)
				digit = (int)(Math.random() * 9) + 1;
			else
				digit = (int)(Math.random() * 10);
			String tempNum = "" + digit;
			temp = temp + tempNum;
		}
		result = Integer.parseInt(temp);
		return result;
	}
	
}
