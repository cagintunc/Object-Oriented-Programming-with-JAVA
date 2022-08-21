package G13_CENG211_HW3;

import java.util.Comparator;
//class for sorting movie and game name 
public class NameSorter implements Comparator<Content> {

	  @Override
	  public int compare(Content o1, Content o2) {
		
		  return o1.getName().compareToIgnoreCase(o2.getName());
	  }	

}
