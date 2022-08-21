package G13_CENG211_HW2;

public class Passport implements Cloneable {
	private int id;
	private String passportNumber;
	private String expirationData;
	
	public Passport(int id, String passportNumber, String expirationData) {
		this.id = id;
		this.passportNumber = passportNumber;
		this.expirationData = expirationData;
	}
	
	public Passport clone() {
		try {
			return (Passport) super.clone();
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

	public String getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

	public String getExpirationData() {
		return expirationData;
	}

	public void setExpirationData(String expirationData) {
		this.expirationData = expirationData;
	}
	public boolean isPassportValid() {
		if(passportNumber.length() != 10)
			return false;
		if(!(passportNumber.charAt(0) == 'P'))
			return false;
		String lastThree = passportNumber.substring(7, 10);
		try {
			@SuppressWarnings("unused")
			int number = Integer.parseInt(lastThree);
		} catch(NumberFormatException e) {
			return false;
		}
		return true;
	}
	public boolean checkExpirationDate() {
		Date date = new Date(expirationData);
		return date.getMonthNumber() >= 6;
	}
	public long getExpirationDate() {
		Date date = new Date(expirationData);
		return date.getMonthNumber();
	}
}
