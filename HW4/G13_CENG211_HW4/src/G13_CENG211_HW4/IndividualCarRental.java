package G13_CENG211_HW4;

import java.util.*;

public class IndividualCarRental extends CarRental { 
	private static int total;
	private static int totalDay;
	private static int nonMemberNumber;
	private static int memberNumber;
	
	static {
		total = 0;
		totalDay = 0;
		nonMemberNumber = 0;
		memberNumber = 0;
	}
	
	public IndividualCarRental() {
		super();
		total++;
	}
	
	public void displayRental() {
		Map<Customer, Car> rental = super.getCars();
		Set<Customer> customers = rental.keySet();
		for(Customer current : customers) {
			IndividualCustomer currentCustom = ((IndividualCustomer)current);
			Car car = rental.get(current);
			Model model = car.getModel();
			Id<String> id = current.getId();
			String fullId;
			if(id.getFirst() == null)
				fullId = id.getSecond();
			else
				fullId = id.getFirst() + id.getSecond();
			System.out.printf("    %-10d  %-12s   %-6s        %-9d      %-18s  %-9d %15f %n",
								super.getRentalCode(),  
								fullId, currentCustom.isMember(), 
								currentCustom.getRentedInterval(), model.getName(),  
								model.getYear(), 
								getPrice(model, currentCustom));
		}
	}
	
	public double getPrice(Model model, Customer customer) {
		int day = customer.getRentedInterval();
		double result = day * model.getBasePrice() * model.getYearRatio();
		
		if(customer instanceof IndividualCustomer) {
			IndividualCustomer current = (IndividualCustomer) customer;
			if(current.isMember()) {
				result -= result * 0.1;
			}
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
		checkMembership(customer);
		totalDay += customer.getRentedInterval();
	}
	
	public static int getTotal() {
		return total;
	}
	
	public static int getTotalDay() {
		return totalDay;
	}

	public static int getNonMembersNumber() {
		return nonMemberNumber;
	}
	
	public static int getMemberNumber() {
		return memberNumber;
	}
	
	private void checkMembership(Customer customer) {
		if(customer instanceof IndividualCustomer) {
			IndividualCustomer current = (IndividualCustomer) customer;
			if(current.isMember()) {
				memberNumber++;
			} else {
				nonMemberNumber++;
			}
		}
	}

}
