package G13_CENG211_HW2;

import java.time.*;
import java.time.temporal.ChronoUnit;

public class Date {
	private String dateAsString;
	private String currentDate;
	private long numOfMonths;
	
	public Date(String dateAsString) {
		this.dateAsString = dateAsString;
		currentDate = LocalDate.now().toString();
		calculateMonth();
	}
	private final void calculateMonth() {
		numOfMonths = ChronoUnit.MONTHS.between(LocalDate.parse(currentDate), LocalDate.parse(dateAsString));
	}
	public long getMonthNumber() {
		return numOfMonths;
	}
	
}
