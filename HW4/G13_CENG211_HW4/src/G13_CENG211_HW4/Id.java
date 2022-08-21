package G13_CENG211_HW4;

public class Id<T> {
	private T[] id;
	
	@SuppressWarnings("unchecked")
	public Id(T first, T second) {
		id = (T[])(new Object[2]);
		id[0] = first;
		id[1] = second;
	}
	
	public T[] getId() {
		return id;
	}
	
	public T getFirst() {
		return id[0];
	}
	
	public T getSecond() {
		return id[1];
	}
}
