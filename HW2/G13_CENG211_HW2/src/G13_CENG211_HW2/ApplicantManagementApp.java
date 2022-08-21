package G13_CENG211_HW2;
import java.util.*;
/**ApplicantManagementApp; which handles the applicant data collection, getting and setting 
 data for specific applicant*/
public class ApplicantManagementApp {
	private ArrayList<Applicant> applicants;
	private ArrayList<ArrayList<String>> allData;
	private ArrayList<ArrayList<String>> freshData;
	
	public ApplicantManagementApp(ArrayList<ArrayList<String>> allData) {
		this.allData = allData;
		applicants = new ArrayList<Applicant>();
		freshData = new ArrayList<ArrayList<String>>();
		// First get each applicant vital informations.
		setApplicants();
		// Then we can advance in other information.
		setApplicantData();
	}
	
	public void sortApplicant() {
		SelectionSort ss = new SelectionSort();
		Applicant[] array = new Applicant[applicants.size()];
		for(int i = 0; i < array.length; i++) {
			array[i] = (Applicant) applicants.toArray()[i];
		}
		ss.sort(array);
		ArrayList<Applicant> tempApplicant = new ArrayList<Applicant>();
		for(int i = 0; i < array.length; i++) {
			tempApplicant.add(array[i]);
		}
		applicants = tempApplicant;
	}
	
	public void seeApplicant() { 
		sortApplicant();
		for(Applicant a : applicants) {
			String rejectedReason = rejectionReason(a);
			if(rejectedReason == null) {
				System.out.println("Applicant ID:" + a.getId() +", Name: " + a.getName() + 
						", Visa Type: " + a +
						", Status: Accepted, Visa Duration: " + a.getDurationOfVisa());
			} else {
				System.out.println("Applicant ID:" + a.getId() +", Name: " + a.getName() + 
						", Visa Type: " + a +
						", Status: Rejected, Reason: " + rejectedReason);
			}
			System.out.println();
		}
	}
	// Implementation details.
	private final void setApplicants() {
		for(ArrayList<String> array : allData) {
			if(array.get(0).equals("A")) {
				if(array.get(1).startsWith("11")) {
					applicants.add(new Tourist(Integer.parseInt(array.get(1)), array.get(2)));
				} 
				else if(array.get(1).startsWith("23")) {
					applicants.add(new Worker(Integer.parseInt(array.get(1)), array.get(2)));
				}
				else if(array.get(1).startsWith("25")) {
					applicants.add(new Educational(Integer.parseInt(array.get(1)), array.get(2)));
				}
				else if(array.get(1).startsWith("30")) {
					applicants.add(new Immigrant(Integer.parseInt(array.get(1)), array.get(2)));
				}
			} else {
				freshData.add(array);
			}
		}
	}
	private final void setApplicantData() {
		for(ArrayList<String> array : freshData) {
			Applicant currentApplicant = getApplicantWith(Integer.parseInt(array.get(1)));
			currentApplicant.setData(array);
		}
	}
	private Applicant getApplicantWith(int givenId) {
		Applicant result = null;
		for(Applicant current : applicants) {
			if(current.getId() == givenId) {
				result = current;
				break;
			}
		}
		return result;
	}
	private String rejectionReason(Applicant a) {
		String rejectedReason = null;
		if(a.getData().getPassport() == null) {
			rejectedReason = "Applicant does not have a passport";
		}
		else if(!a.getData().getPassport().isPassportValid())
			rejectedReason = "Passport is not valid";
		else if(!a.getData().getPassport().checkExpirationDate())
			rejectedReason = "Passport expiration date is not valid"; 
		else {
			if(a.getData().getPhoto() == null)
				rejectedReason = "Applicant does not have a photo";
			else if(!a.getData().getPhoto().isResolutionValid())
				rejectedReason = "Resolution of photo is not valid";
			else if(!a.getData().getPhoto().isPositionValid())
				rejectedReason = "Position in the photo is not valid";
			else {
				if(a.getData().getFinancialStatus() == null)
					rejectedReason = "Applicant does not have a financial status report";
				else if(!a.isFinancialStatuSatisfied())
					rejectedReason = "Applicant does not have a stable financial status";
				else {
					if((a.toString().toLowerCase().equals("worker")||
							a.toString().toLowerCase().equals("educational"))) {
						if(!a.hasLetterAccept()) {
							rejectedReason = "Applicant does not have a letter of acceptance";
						} else {
							if(a.getDurationOfVisa()==null)
								rejectedReason = "Expiration date is not suitable";
						}
					}
				}
			}
		}
		return rejectedReason;
	}
}
