package G13_CENG211_HW2;

import java.util.*;

public class Data implements Cloneable {
	private Passport passport;
	private Photo photo;
	private FinancialStatus financialStatus;
	private ArrayList<Document> documents;
	
	public Data() {
		passport = null;
		photo = null;
		financialStatus = null;
		documents = new ArrayList<Document>();
	}
	public Data(Data original) {
		if(original == null) {
			System.out.print("Original data is Null.");
			System.exit(0);
		}
		if(original.getPassport() != null)
			passport = original.getPassport().clone();
		else passport = null;
		if(original.getPhoto() != null)
			photo = original.getPhoto().clone();
		else photo = null;
		if(original.getFinancialStatus() != null)
			financialStatus = original.getFinancialStatus().clone();
		else financialStatus = null;
		documents = original.getDocuments();
	}
	
	public Data clone() {
		try {
			Data temp = (Data) super.clone();
			if(passport != null)
				temp.setPassport((Passport)passport.clone());
			if(photo != null)
				temp.setPhoto((Photo)photo.clone());
			if(financialStatus != null)
				temp.setFinancialStatus((FinancialStatus)financialStatus.clone());
			temp.setDocument(getDocuments());
			return temp;
		} catch(CloneNotSupportedException e) {
			System.out.println("Error was occured.");
			e.printStackTrace();
			return null;
		}
	}
	
	// Setters
	public void setPassport(Passport passport) {
		this.passport = passport;
	}
	public void setPhoto(Photo photo) {
		this.photo = photo;
	}
	public void setFinancialStatus(FinancialStatus financialStatus) {
		this.financialStatus = financialStatus;
	}
	public void setDocument(ArrayList<Document> documents) {
		this.documents = documents;
	}
	public void addDocuments(Document document) {
		documents.add(document);
	}
	
	// Getters
	public Passport getPassport() {
		if(passport == null) {
			return null;
		}
		return (Passport) passport.clone();
	}
	public Photo getPhoto() {
		if(photo == null) {
			return null;
		}
		return (Photo) photo.clone();
	}
	public FinancialStatus getFinancialStatus() {
		if(financialStatus == null) {
			return null;
		}
		return (FinancialStatus) financialStatus.clone();
	}
	public ArrayList<Document> getDocuments() {
		ArrayList<Document> temp = new ArrayList<Document>();
		for(Document doc : documents) {
			temp.add(doc.clone());
		}
		return temp;
	}
	
}
