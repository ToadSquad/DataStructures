package DefaultClasses;

public interface BagInterface <T> {
	public int getCurrentSize();
	public boolean isEmpty();
	public boolean add(T newEntry);
	public boolean remove(T anEntry);
	public T remove();
	public void clear();
}