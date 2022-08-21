package G13_CENG211_HW4;

public class CommercialCustomer extends Customer {
	private ICustomer customerType;

	public CommercialCustomer(Id<String> id, int rentedDay) {
		super(id, rentedDay);
		setUp();
	}
	
	public ICustomer getType() {
		assert customerType != null;
		return customerType;
	}
	
	private final void setUp() {
		try {
			setCustomerType(super.getId());
		} catch(IdFormatNotProperException ex) {
			System.out.println("ID format is not valid!!");
		}
	}

	private final void setCustomerType(Id<String> id) throws IdFormatNotProperException {
		String indicator = id.getFirst();
		if(indicator.equals("S")) {
			customerType = new Silver();
		} else if(indicator.equals("G")) {
			customerType = new Gold();
		} else if(indicator.equals("P")) {
			customerType = new Platinum();
		} else {
			throw new IdFormatNotProperException();
		}
	}
}
