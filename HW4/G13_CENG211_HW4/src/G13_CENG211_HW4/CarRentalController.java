package G13_CENG211_HW4;

import java.util.*;

public class CarRentalController {
	private ArrayList<ArrayList<String>> info;
	private ArrayList<CarRental> rentals; //
	
	public CarRentalController() {
		info = new ArrayList<ArrayList<String>>();
		rentals = new ArrayList<CarRental>(); //
	}
	
	public void setUp() {
		FileIO file = new FileIO("HW4_Rentals.csv");
		info = file.getFileInfo();
		createObjects();
	}
	
	private void createObjects() {
		for(ArrayList<String> row : info) {
			
			CarRental currentRental = null;;
			Customer currentCustomer;
			Id<String> id;
			Car currentCar;
			String idLine;
			int numberOf;
			String indicator = row.get(0);
			
			if(indicator.equals("Individual")) {
				currentRental = new IndividualCarRental();
				rentals.add(currentRental);
			} else if(indicator.equals("Commercial")) {
				currentRental = new CommercialCarRental();
				rentals.add(currentRental);
			}
			
			if((row.size() > 5)&&(currentRental != null)) {
				idLine = row.get(1);
				id = getId(idLine);
				numberOf = Integer.parseInt(row.get(2));
				currentCustomer = getCurrentCustomer(id, numberOf, idLine);
				currentCar = getCurrentCar(row.get(3), row.get(4), row.get(5));
				currentRental.addCustomer(currentCustomer, currentCar);
			}
		}
	}
	
	private Id<String> getId(String line) {
		Id<String> id;;
		String[] idLine = new String[2];
		idLine[0] = line.substring(0, 1);
		idLine[1] = line.substring(1, line.length());
		
		if(Character.isDigit((Character)idLine[0].charAt(0))) {
			id = new Id<String>(null, line);
		}
		else
			id = new Id<String>(idLine[0], idLine[1]);
		return id;
	}
	
	public void showRentals() {
		System.out.println("\nIndividual Rentals:\n");
		System.out.println("No  Rental Code  Customer ID  isMember  Number of Days       Car Model         Model Year     Rental Price");
		int number = 1;
		for(CarRental current : rentals) {
			if(current instanceof IndividualCarRental) {
				System.out.print(number);
				current.displayRental();
				number++;
			}
		}
		number = 1;
		System.out.println("\nCommercial Rentals:\n");
		System.out.println("No  Rental Code  Customer ID  Customer Type  Number of Months        Car Model            Model Year     Rental Price");
		for(CarRental current : rentals) {
			if(current instanceof CommercialCarRental) {
				System.out.print(number);
				current.displayRental();
				number++;
			}
		}
	}
	
	public void showQueries() {
		System.out.println();
		System.out.println("Welcome!");
		System.out.println();
		System.out.println("Total number of cars rented: " + Car.getTotalCarRented());
		System.out.println();
		System.out.println("Total number of commercial rentals: " + CommercialCarRental.getTotal());
		System.out.println();
		System.out.println("Total number of commercial rental-month: " + CommercialCarRental.getTotalMonth());
		System.out.println();
		System.out.println("Total number of individual rentals: " + IndividualCarRental.getTotal());
		System.out.println();
		System.out.println("Total number of individual rental-day: " + IndividualCarRental.getTotalDay());
		System.out.println();
		System.out.println("Total number of rentals of individual non-member customers: " + IndividualCarRental.getNonMembersNumber());
		System.out.println();
		System.out.println("Total number of rentals of individual member customers: " + IndividualCarRental.getMemberNumber());
		System.out.println();
		System.out.println("Total number of rentals of silver commercial customer: " + Silver.getTotalNumber());
		System.out.println();
		System.out.println("Total number of rentals of gold commercial customer: " + Gold.getTotalNumber());
		System.out.println();
		System.out.println("Total number of rentals of platinum commercial customer: " + Platinum.getTotalNumber());
		System.out.println();
	}
	
	private Car getCurrentCar(String modelName, String year, String basePrice) {
		int modelYear = Integer.parseInt(year);
		double price = Double.parseDouble(basePrice);
		Model model = new Model(modelName, modelYear, price);
		return new Car(model);
	}
	
	private Customer getCurrentCustomer(Id<String> id, 
			int numberOf, String idLine) {
		
		try {
			if(idLine.length() == 8) {
				return new CommercialCustomer(id, numberOf);
			} else if((idLine.length() == 12)||(idLine.length() == 11)) {
				return new IndividualCustomer(id, numberOf);
			} else {
				throw new IdFormatNotProperException();
			}
		} catch(IdFormatNotProperException ex) {
			System.out.println("Id format is not appropriate!!");
			return null;
		}
	}
}
