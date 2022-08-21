package G13_CENG211_HW2;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class SelectionSort {
	public void sort(Comparable[] array) {
		int index, indexOfNextMin;
		for(index = 0; index < array.length-1; index++) {
			indexOfNextMin = getIndexOfNextMin(index, array);
			interchange(index, indexOfNextMin, array);
		}
	}
	private int getIndexOfNextMin(int index, Comparable[] array) {
		Comparable min = array[index];
		int minIndex = index;
		for(int i = index+1; i < array.length; i++) {
			if(min.compareTo(array[i]) > 0) {
				min = array[i];
				minIndex = i;
			}
		}
		return minIndex;
	}
	private void interchange(int index, int minIndex, Comparable[] array) {
		Comparable temp = array[index];
		array[index] = array[minIndex];
		array[minIndex] = temp;
	}
}
