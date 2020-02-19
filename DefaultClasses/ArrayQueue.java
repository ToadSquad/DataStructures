package DefaultClasses;

public class ArrayQueue<T> implements QueueInterface<T> {
	private int capacity;
	private final static int DEFUALT_CAPCITY = 50;
	private int frontIndex;
	private int backIndex;
	private T[] array;
	
	ArrayQueue(){
		this(DEFUALT_CAPCITY);
	}
	ArrayQueue(int capacity){
		this.capacity = capacity;
		T[] newArray = (T[]) new Object[capacity];
		this.array = newArray;
		this.frontIndex = 0;
		this.backIndex = capacity-1;
	}
	
	
	
	@Override
	public T dequeue() {
		// TODO Auto-generated method stub
		if(isEmpty()) {throw new EmptyQueueException();}
		T front = array[frontIndex];
		array[frontIndex] = null;
		frontIndex = frontIndex++%capacity;
		if(isEmpty()) {clear();}
		return front;
	}

	@Override
	public T getFront() {
		// TODO Auto-generated method stub
		if(isEmpty()) {throw new EmptyQueueException();}
		return array[frontIndex];
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (frontIndex==0&&backIndex==this.capacity-1);
	}
	public boolean isFull() {
		return (backIndex+2%capacity==frontIndex);
		
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		if(capacity>this.DEFUALT_CAPCITY) {
		this.capacity = this.DEFUALT_CAPCITY;
		}
		T[] newArray = (T[]) new Object[capacity];
		this.array = newArray;
		this.frontIndex = 0;
		this.backIndex = capacity-1;
		
	}

	@Override
	public void enqueue(T entry) {
		// TODO Auto-generated method stub
		if(isFull()) {ensureCapacity();}
		backIndex = backIndex++%capacity;
		array[backIndex]=entry;
		
	}
	public void ensureCapacity() {
		T[] newArray = (T[]) new Object[capacity*2];
		int y = 0;
		for(int x=frontIndex;x!=backIndex++%capacity;x=x++%capacity) {
			newArray[y] = array[x];
			y++;
		}
		this.array = newArray;
		
	}

}
