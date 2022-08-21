package G13_CENG211_HW4;

@SuppressWarnings("serial")
public class IdFormatNotProperException extends Exception {
	public IdFormatNotProperException() {
		super("Id is not in appropriate format.");
	}
	public IdFormatNotProperException(String message) {
		super(message);
	}
}
