package G13_CENG211_HW2;


public class Tourist extends Applicant {
	
	private Visa visa;
	
	public Tourist(int id, String name) {
		super(id, name);
		visa = null;
	}
	
	public boolean isFinancialStatuSatisfied() {
		Data data = super.getData();
		FinancialStatus financialStatu = data.getFinancialStatus();
		int constant = 1;
		if(super.hasInvitationLetter())
			constant = 2;
		int income = financialStatu.getIncome();
		int savings = financialStatu.getSavings();
		if(income < 2000/constant)
			return false;
		else if((income >= 2000/constant)&&(income < 3000/constant)) {
			if(savings < 12000/constant)
				return false;
		}
		else if((income >= 3000/constant)&&(income <= 4000/constant)) {
			if(savings < 6000/constant)
				return false;
		}
		assert income > 4000/constant: "income does not checked correctly";
		return true;
	}

	public String getDurationOfVisa() {
		visa = new Visa(super.clone());
		return visa.getDurationOfVisa();
	}
	
	public String toString() {
		return "Tourist";
	}
	
}
