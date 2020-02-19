package Lab6SortedList;


public class SortedLinkedList<T extends Comparable <? super T>> extends LinkedChainBase <T> implements SortedListInterface <T>
{
	private ListInterface<T> list;
	

	SortedLinkedList(){
		list = new LinkedList<T>();
	}
    private Node getNodeBefore (T anEntry) {
	     Node curNode = getFirstNode();
	     Node nodeBefore = null;
	     while (curNode != null && 
			!anEntry.equals(curNode.getData())){
		   nodeBefore = curNode;
		   curNode = curNode.getNext();
		}
	     return nodeBefore;
}

	@Override
	public void addEntry(T entry) {
		// TODO Auto-generated method stub
		list.add(entry);
		Node before = getNodeBefore (entry);
		Node toInsert = new Node(entry);
		if (before == null) {
			addFirstNode(entry);
			}
		else { 
			addAfterNode(before, toInsert);
		}
	}

	@Override
	public int getPosition(T entry) {
    	int position = 0;
        int length = getLength();
        Node curNode = getFirstNode();  
        while (position < length && 
               !entry.equals(curNode.getData())) {
            position ++;
            curNode = curNode.getNext();
        }
        if (position >= length ||
               (!(entry.equals(curNode.getData()))))
            position = -1 - position;
        return position;
	}

	@Override
	public T getEntry(int pos) {
		// TODO Auto-generated method stub
		return list.getEntry(pos);
	}

	@Override
	public T remove(int pos) {
		// TODO Auto-generated method stub
		return list.remove(pos);
	}


}
