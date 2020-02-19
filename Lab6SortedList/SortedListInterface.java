package Lab6SortedList;

public interface SortedListInterface<T extends Comparable<? super T>>{
    public void addEntry(T entry);
    public int getPosition( T entry);
    public T getEntry(int pos);
    public boolean contains (T entry);
    public T remove (int pos);
    public void clear();
    public int getLength();
    public boolean isEmpty();
    public Object[] toArray();

}
