package G13_CENG211_HW2;

public class Immigrant extends Applicant {
	
	public Immigrant(int id, String name) {
		super(id, name);
	}

	public boolean isFinancialStatuSatisfied() {
		Data data = super.getData();
		int savings = data.getFinancialStatus().getSavings();
		int constant = 1;
		if(super.hasInvitationLetter())
			constant = 2;
		if(super.hasGreenCard()) {
			return (savings >= 4000/constant);
		}
		else {
			return (savings >= 50000/constant);
		}
	}
	
	public String toString() {
		return "Immigrant";
	}
	
}
