package Lab6SortedList;
/*
 * John Smith
 * Justin parker
 * Muhammed
 */
public class LinkedList <T> extends LinkedChainBase<T> implements ListInterface<T>{
	
	private Node firstNode;
	private int numberOfEntries;
	
	LinkedList(){
		super();
	}
	
	@Override
	public void add(T entry) {
	       Node add = new Node(entry); 
	 	  if (isEmpty()) {
	 		  addFirstNode(entry);
	 		  }
	 	  else {
	 		  Node lastNode = getNodeAt(getLength() - 1);
	 		  addAfterNode(lastNode,add);
	 	  }

	}
	@Override
	public void add(int pos, T entry) {
		// TODO Auto-generated method stub
		  if (pos < 0 || pos > getLength()) {throw new IndexOutOfBoundsException();}
		  Node toAdd = new Node (entry);
		  if (pos == 0)
			  addFirstNode(entry);
		  else {
			  Node nodeBefore = getNodeAt(pos - 1);
			  addAfterNode(nodeBefore, toAdd);
		  }


	}

	@Override
	public T remove(int pos) {
		// TODO Auto-generated method stub
		T entry = this.getEntry(pos);
		super.remove(this.getEntry(pos));
		return entry;
	}

	@Override
	public T replace(int pos, T entry) {
		// TODO Auto-generated method stub
		this.add(pos, entry);
		T replaced = this.getEntry(pos--);
		this.remove(pos--);
		return replaced;
	}

	@Override
	public T getEntry(int pos) {
		// TODO Auto-generated method stub
		return (T) super.getNodeAt(pos).getData();
	}
	


}