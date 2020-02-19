package Lab6SortedList;

import Lab3.Node;

abstract class LinkedChainBase <T>{
	private Node first;
	private int size;
	//clear, getLength, isEmpty, remove, contains and toArray are here
	LinkedChainBase(){
		initializeDataFields();
	}
	public void clear() {
		for(Node cur=first;cur!=null;cur=cur.getNext()) {
			cur = null;
		}
	}
	public int getLength() {
		int size = this.size;
		return size;
		
	}
	public boolean isEmpty() {
		return (size==0);
		
	}
	public boolean remove (T entry) {
		if (isEmpty()) {throw new NullPointerException();}
		Node curNode = null;
		Node first = getFirstNode();
		if (entry.equals(first.getData())) {
			removeFirstNode();
			return true;
		}
		for (Node nextNode = first; nextNode != null; 
				nextNode = curNode.getNext()) {
			if (entry.equals(nextNode.getData())) {
				removeAfterNode(curNode);
				return true;
			}
			curNode = nextNode;
		}
		return false;
	}

	
		
	public boolean contains(T object) {
		for(Node cur=first;cur!=null;cur=cur.getNext()) {
			if(cur.getData().equals(object)) {
				return true;
			}
			
		}
		return false;
		
	}
	public Object[] toArray() {
		T[] array = (T[]) new Object[size];
		int x=0;
		for(Node cur=first;cur!=null;cur=cur.getNext()) {
			array[x] = (T) cur.getData();
			x++;
			}
			
		
		
		return array;
		
	}
	
	private void initializeDataFields() {
		// TODO Auto-generated method stub
		first = null;
		size = 0;
		
	}
	/*protected final methods getFirstNode, addFirstNode, addAfterNode, removeFirstNode, removeAfterNode,
	 *  getNodeAt, and initializeDataFields are here 
	 */
	protected final Node getFirstNode() {
		
		return first;
	}
	protected final void addFirstNode(T data) {
		Node newNode = new Node(data);
		newNode.setNext(first);
		first = newNode;
		size++;
	}
	protected final void addAfterNode(Node toAdd,Node after) {
		after.setNext(toAdd.getNext());
		toAdd.setNext(after);
		size++;

	}
	protected final void removeFirstNode() {
		first = first.getNext();
	}
	protected final void removeAfterNode(Node after) {
		after.setNext(after.getNext().getNext());
	}
	protected final Node getNodeAt(int pos) {
		if(pos<0||pos>=size) {throw new IndexOutOfBoundsException();}
		Node curr = getFirstNode();
		for(int x=0;x<size;x++) {
			if(x==pos) {
				return curr;
			}
			curr = curr.getNext();
		}
		return null;
	}
	
	//NODE
	public class Node<T>{
		private T data;
		private Node next;
		
		
		Node(T data,Node next){
			this.data = data;

			this.next = next;
		}
		public T getData() {
			return data;
		}
		public void setData(T data) {
			this.data = data;
		}
		public Node getNext() {
			return next;
		}
		public void setNext(Node next) {
			this.next = next;
		}
		Node(T data){
			this.data = data;
			this.next = null;
		}
		

	}
	
	
	
}
