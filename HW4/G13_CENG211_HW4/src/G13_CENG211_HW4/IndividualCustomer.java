package G13_CENG211_HW4;

public class IndividualCustomer extends Customer {
	private boolean member;
	
	public IndividualCustomer(Id<String> id, int rentedNum) {
		super(id, rentedNum);
		checkMembership(id);
	}
	
	public boolean isMember() {
		return member;
	}
	
	private final void checkMembership(Id<String> id) {
		String indicator = id.getFirst();
		if(indicator == null) {
			member = false;
		} else if(indicator.equals("M")){
			member = true;
		}
	}
	
}
