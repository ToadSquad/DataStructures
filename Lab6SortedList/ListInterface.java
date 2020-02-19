package Lab6SortedList;

public interface ListInterface <T> {
	void add(T entry);
	void add(int pos,T entry);
	T remove(int pos);
	boolean remove(T entry);
	void clear();
	T replace(int pos,T entry);
	T getEntry(int pos);
	Object[] toArray();
	boolean contains(T entry);
	int getLength();
	boolean isEmpty();
 }