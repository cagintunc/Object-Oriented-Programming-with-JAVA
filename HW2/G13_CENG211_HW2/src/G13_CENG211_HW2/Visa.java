package G13_CENG211_HW2;

public class Visa implements Cloneable {
	
	private Applicant applicant;
	private String visaDuration;
	
	public Visa(Applicant applicant) {
		this.applicant = applicant;
		visaDuration = null;
	}
	
	public Visa clone() {
		try {
			Visa temp = (Visa) super.clone();
			return temp;
		} catch(CloneNotSupportedException e) {
			System.out.println("Error was occured.");
			e.printStackTrace();
			return null;
		}
	}
	
	public String getDurationOfVisa() {
		if(applicant.toString().toLowerCase().equals("tourist"))
			visaDuration = getForTourist();
		else if(applicant.toString().toLowerCase().equals("worker"))
			visaDuration = getForWorkerandEdu(5);
		else if(applicant.toString().toLowerCase().equals("educational"))
			visaDuration = getForWorkerandEdu(4);
		else
			visaDuration = "Permanent";
		return visaDuration;
	}
	
	private String getForTourist() {
		String result = null;
		int income = applicant.getData().getFinancialStatus().getIncome();
		int savings = applicant.getData().getFinancialStatus().getSavings();
		double dc = 0.0;
		long expirationDate = applicant.getData().getPassport().getExpirationDate();
		if(applicant.hasInvitationLetter())
			dc = ((income-2000) * 6 + savings)/6000;
		else
			dc = ((income-2000) * 6 + savings)/12000;
		if((dc >= 1)&&(dc < 2))
			result = "6 months";
		else if((dc >= 2) && (dc < 4)) {
			if(expirationDate < 12) {
				result = "6 months";
			} else {
				result = "1 years";
			}
		}
		else {
			assert dc >= 4: "dc does not checked correctly";
			if(expirationDate < 60) {
				result = "1 years";
			} else {
				result = "5 years";
			}
		}
		return result;
	}
	private String getForWorkerandEdu(int difference) {
		String result = null;
		Document doc = applicant.getLA();
		int laDuration = doc.getDurationInMonths();
		long expirationDate = applicant.getData().getPassport().getExpirationDate();
		if(expirationDate >= 12) {
			if(expirationDate < laDuration) {
				if(expirationDate < 24)
					result = "1 years";
				else if((expirationDate >= 24) && (expirationDate < 12*difference))
					result = "2 years";
				else {
					result = String.format("%d years", difference);
				}
			}
			else {
				if((laDuration <= 12)||(expirationDate < 24))
					result = "1 years";
				else if(((laDuration > 12)&&(laDuration <= 24))||
						((expirationDate >= 24)&&(expirationDate < 12*difference)))
					result = "2 years";
				else
					result = String.format("%d years", difference);
			}
		}
		return result;
	}
	public void setApplicant(Applicant applicant) {
		this.applicant = applicant;
	}
}
