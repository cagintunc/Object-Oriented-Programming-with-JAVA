package G13_CENG211_HW2;

import java.util.*;

public abstract class Applicant implements Cloneable, Comparable {
	private int id;
	private String name;
	private Data data;
	private Visa visa;
	
	public Applicant(int id, String name) {
		this.id = id;
		this.name = name;
		data = new Data();
		visa = new Visa(this);
	}
	
	public Applicant clone() {
		try {
			Applicant temp = (Applicant) super.clone();
			temp.setVisa(visa.clone());
			return temp;
		} catch(CloneNotSupportedException e) {
			System.out.println("Error was occured.");
			e.printStackTrace();
			return null;
		}
	}
	
	public int compareTo(Object other) {
		if(other == null) {
			System.out.println("Other applicant is null.");
			System.exit(0);
			return 0; // to compiler happy
		} else if(!(other instanceof Applicant)) {
			throw new ClassCastException();
		} else {
			Applicant otherApplicant = (Applicant) other;
			if(id < otherApplicant.getId())
				return -1;
			else if(id == otherApplicant.getId())
				return 0;
			else
				return 1;
		}
	}
	
	// Abstract method isFinancialStatuSatisfied; which will be implemented in the concrete classes.
	public abstract boolean isFinancialStatuSatisfied();
	
	// Inspectors
	public boolean hasInvitationLetter() {
		ArrayList<Document> documents = data.getDocuments();
		boolean hasIL = false;
		for(Document doc : documents) {
			if(doc.getDocType().equals("IL"))
				hasIL = true;
		}
		return hasIL;
	}
	public boolean hasLetterAccept() {
		ArrayList<Document> documents = data.getDocuments();
		boolean hasLA = false;
		for(Document doc : documents) {
			if(doc.getDocType().equals("LA")) {
				hasLA = true;
			}
		}
		return hasLA;
	}
	
	public boolean hasGreenCard() {
		ArrayList<Document> documents = data.getDocuments();
		boolean hasGC = false;
		for(Document doc : documents) {
			if(doc.getDocType().equals("GC")) {
				hasGC = true;
			}
		}
		return hasGC;
	}
	// Getters and setters
	public LA getLA() {
		LA la = null;
		ArrayList<Document> documents = data.getDocuments();
		for(Document doc : documents) {
			if(doc.getDocType().equals("LA")) {
				la = (LA)doc;
			}
		}
		return la;
	}
	
	public String getDurationOfVisa() {
		return visa.getDurationOfVisa();
	}
	// Overloaded setData method.
	public void setData(Data data) {
		this.data = data;
	}
	
	public Data getData() {
		return data.clone();
	}
	public void setVisa(Visa visa) {
		this.visa = visa;
	}

	public Visa getVisa() {
		return visa.clone();
	}
	
	public String getName() {
		return name;
	}
	public int getId() {
		return id;
	}
	
	public void setData(ArrayList<String> info) {
		String flag = info.get(0);
		if(flag.equals("S")) {
			data.setPassport(new Passport(Integer.parseInt(info.get(1)), info.get(2), info.get(3)));
		} 
		else if(flag.equals("P")) {
			data.setPhoto(new Photo(Integer.parseInt(info.get(1)), info.get(2), info.get(3)));
		} 
		else if(flag.equals("F")) {
			data.setFinancialStatus(new FinancialStatus(Integer.parseInt(info.get(1)),
					Integer.parseInt(info.get(2)), Integer.parseInt(info.get(3))));
		} 
		else if(flag.equals("D")) {
			if(info.get(2).equals("GC")) {
				if(info.size() == 4) {
					data.addDocuments(new GC(Integer.parseInt(info.get(1)),
							info.get(2), Integer.parseInt(info.get(3))));
				} else {
					data.addDocuments(new GC(Integer.parseInt(info.get(1)),
							info.get(2)));
				}
			} else if(info.get(2).equals("IL")) {
				if(info.size() == 4) {
					data.addDocuments(new IL(Integer.parseInt(info.get(1)),
							info.get(2), Integer.parseInt(info.get(3))));
				} else {
					data.addDocuments(new IL(Integer.parseInt(info.get(1)),
							info.get(2)));
				}
			} else if(info.get(2).equals("LA")) {
				if(info.size() == 4) {
					data.addDocuments(new LA(Integer.parseInt(info.get(1)),
							info.get(2), Integer.parseInt(info.get(3))));
				} else {
					data.addDocuments(new LA(Integer.parseInt(info.get(1)),
							info.get(2)));
				}
			}
		}
	}
}
