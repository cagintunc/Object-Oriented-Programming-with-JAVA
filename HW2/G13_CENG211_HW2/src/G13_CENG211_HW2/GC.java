package G13_CENG211_HW2;

public class GC implements Document, Cloneable {
	private int id;
	private String docType;
	private int durationInMonths;
	
	public GC(int id, String docType) {
		this(id, docType, -1);
	}
	
	public GC(int id, String docType, int durationInMonths) {
		this.id = id;
		this.docType = docType;
		this.durationInMonths = durationInMonths;
	}
	
	public GC getDocument() {
		return this.clone();
	}
	public GC clone() {
		try {
			return (GC) super.clone();
		} catch(CloneNotSupportedException e) {
			System.out.println("Error was occured.");
			e.printStackTrace();
			return null;
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDocType() {
		return docType;
	}

	public void setDocType(String docType) {
		this.docType = docType;
	}

	public int getDurationInMonths() {
		return durationInMonths;
	}

	public void setDurationInMonths(int durationInMonths) {
		this.durationInMonths = durationInMonths;
	}
}
