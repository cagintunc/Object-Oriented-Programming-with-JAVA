package G13_CENG211_HW2;

public class Worker extends Applicant {
	
	public Worker(int id, String name) {
		super(id, name);
	}

	public boolean isFinancialStatuSatisfied() {
		Data data = super.getData();
		FinancialStatus financialStatu = data.getFinancialStatus();
		int savings = financialStatu.getSavings();
		return (savings >= 2000);
	}
	public String toString() {
		return "Worker";
	}
}
