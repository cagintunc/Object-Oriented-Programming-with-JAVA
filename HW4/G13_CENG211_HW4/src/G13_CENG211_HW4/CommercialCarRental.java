package G13_CENG211_HW4;

import java.util.Map;
import java.util.Set;

public class CommercialCarRental extends CarRental {
	private static int total;
	private static int totalMonth;
	
	static {
		total = 0;
	}
	
	public CommercialCarRental() {
		super();
		total++;
	}
	
	public double getPrice(Model model, Customer customer) {
		int month = customer.getRentedInterval();
		double result = 30 * month * model.getBasePrice() * model.getYearRatio();
		
		if(customer instanceof IndividualCustomer) {
			IndividualCustomer current = (IndividualCustomer) customer;
			if(current.isMember())
				result -= result * 0.1;
		} else {
			assert customer instanceof CommercialCustomer;
			CommercialCustomer current = (CommercialCustomer) customer;
			ICustomer type = current.getType();
			result -= result * type.getDiscountCoef();
		}
		return result;
	}
	
	public void addCustomer(Customer customer, Car car) {
		super.addCustomer(customer, car);
		totalMonth += customer.getRentedInterval();
	}

	public void displayRental() {
		Map<Customer, Car> rental = super.getCars();
		Set<Customer> customers = rental.keySet();
		for(Customer current : customers) {
			CommercialCustomer currentCustom = ((CommercialCustomer)current);
			Car car = rental.get(current);
			Model model = car.getModel();
			Id<String> id = current.getId();
			String fullId;
			if(id.getFirst() == null)
				fullId = id.getSecond();
			else
				fullId = id.getFirst() + id.getSecond();
			System.out.printf("    %-10d  %-12s   %-15s     %-9d        %-20s    %-9d %15f %n",
								super.getRentalCode(),  
								fullId, currentCustom.getType().toString(), 
								currentCustom.getRentedInterval(), model.getName(),  
								model.getYear(), 
								getPrice(model, currentCustom));
		}
		
	}
	
	public static int getTotal() {
		return total;
	}
	
	public static int getTotalMonth() {
		return totalMonth;
	}
	
}
