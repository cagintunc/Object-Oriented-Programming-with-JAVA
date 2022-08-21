package G13_CENG211_HW2;

public class FinancialStatus implements Cloneable {
	 private int applicantID;
	 private int income;
	 private int savings;
	 
	 public FinancialStatus(int applicantID, int income, int savings) {
		 this.applicantID = applicantID;
		 this.income = income;
		 this.savings = savings;
	 }
	 
	 public int getApplicantID() {
		 return applicantID;
	 }
	 
	 public int getIncome() {
		 return income;
	 }
	 
	 public int getSavings() {
		 return savings;
	 }
	 
	 public FinancialStatus clone() {
		 try {
			 return (FinancialStatus) super.clone();
		 } catch(CloneNotSupportedException e) {
			 System.out.println("Error was occured.");
			 e.printStackTrace();
			 return null;
		 }
	 }
	 
}
