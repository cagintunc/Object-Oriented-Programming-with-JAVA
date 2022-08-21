package G13_CENG211_HW2;

public class Educational extends Applicant {
	
	public Educational(int id, String name) {
		super(id, name);
	}
	
	public boolean isFinancialStatuSatisfied() {
		Data data = super.getData();
		FinancialStatus financialStatu = data.getFinancialStatus();
		int constant = 1;
		if(super.hasInvitationLetter())
			constant = 2;
		int income = financialStatu.getIncome();
		int savings = financialStatu.getSavings();
		if(income < 1000/constant)
			return false;
		else if((income >= 1000/constant)&&(income < 2000/constant)) {
			return (savings >= 6000/constant);
		}
		else if((income >= 2000/constant)&&(income <= 3000/constant)) {
			return (savings >= 3000/constant);
		}
		assert income > 3000/constant: "income does not checked correctly";
		return true;
	}
	
	public String toString() {
		return "Educational";
	}

}
