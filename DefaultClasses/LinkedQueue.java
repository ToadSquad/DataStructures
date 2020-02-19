package DefaultClasses;


public class LinkedQueue<T> implements QueueInterface<T>{
	Node front;
	private Node back;
	
	
	public LinkedQueue(){
		front = null;
		back = null;
	}
	
	
	@Override
	public void enqueue(T entry) {
		// TODO Auto-generated method stub
		if(isEmpty()) {
			front = new Node(entry);
			back = front;
		}
		else {
			Node nodeNew = new Node(entry);
			back.setNext(nodeNew);
			back = nodeNew;
		}
	}

	@Override
	public T dequeue() {
		// TODO Auto-generated method stub
		if(isEmpty()) {throw new EmptyQueueException();}
		T front = (T) this.front.getData();
		this.front = this.front.getNext();
		if(this.front.equals(null)) {
			this.back = null;
		}
		
		return front;
	}

	@Override
	public T getFront() {
		// TODO Auto-generated method stub
		if(isEmpty()) {throw new EmptyQueueException();}
		return (T) this.front.getData();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (front==null)&&(back==null);
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		this.front = null;
		this.back = null;
	}
	

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
