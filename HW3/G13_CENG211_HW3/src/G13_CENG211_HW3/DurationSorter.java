package G13_CENG211_HW3;

import java.util.Comparator;


//sort content's remain duration to decide which is evaluated first 
public class DurationSorter implements Comparator<Content> {

	@Override
	public int compare(Content o1, Content o2) {
		// TODO Auto-generated method stub
		return o1.getRemainDuration()-o2.getRemainDuration();
	}
	
}
