package G13_CENG211_HW2;

// The interface Document, which will be implemented by some document types
public interface Document {
	
	/**
	 Getting the associated documents.
	 @return Document object which includes all the document information.
	 */
	public Document getDocument();
	
	/**
	 Covariant return type clone method. To do that we enforce every Document type has an implementation
	 of the clone method.
	 */
	public Document clone();
	
	/**
	 Gets the name of the document type.
	 @return String which includes the document type name
	 */
	public String getDocType();
	
	/**
	 Sets the document type to the document type name given as an argument.
	 @param String docType that which indicates the intended document type.
	 */
	public void setDocType(String docType);
	
	/**
	 Gets the id associated with the document
	 @return integer which is the id.
	 */
	public int getId();
	
	/**
	 Setting the document id (For the future use) to the argument given to the method.
	 @param Integer id that will be the id of the associated document.
	 */
	public void setId(int id);
	
	/**
	 Gets the duration in terms of months.
	 @return Integer that indicates the month number.
	 */
	public int getDurationInMonths();
	
	/**
	 Sets the duration of the month to the argument given to the method.
	 @param Integer durationInMonths that will be the duration in terms of months.
	 */
	public void setDurationInMonths(int durationInMonths);
	
}
