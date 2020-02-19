

package DefaultClasses;

import java.util.ArrayList;

public class LinkedBag<T> implements BagInterface<T> {
	private Node start;
	private int numberOfEntrys;

		
		

		

	
	public T[] toArray() {
		   @SuppressWarnings("unchecked")
		   T[] result = (T[])new Object[numberOfEntrys];
		   int idx = 0;
		   for (Node currentNode = start; currentNode != null;
		       currentNode = currentNode.getNext()) {
			   
		      result[idx ++] = (T) currentNode.getData();
		    }
		   return result;
		}



	public  int getSize() {
		return numberOfEntrys;
	}

	public void setSize(int size) {
		this.numberOfEntrys = size;
	}

	public LinkedBag(){
		start = null;
		numberOfEntrys = 0;
	}
	//gets current size
	@Override
	public int getCurrentSize() {
		// TODO Auto-generated method stub
		return this.numberOfEntrys;
	}
	//Checks if the bag is empty
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if(start == null) {
			assert(numberOfEntrys==0);
			return true;
		}
		return false;
	}
	//adds a partiular element
	@Override
	public boolean add(T newEntry) {
		// TODO Auto-generated method stub	

			Node add = new Node(newEntry);
			add.setNext(start);
			start = add;
			numberOfEntrys++;
			
			return true;

	}
	//Removes a specific element once
	@Override
	public boolean remove(T anEntry) {
		// TODO Auto-generated method stub
	
		   for (Node currentNode = start; currentNode != null;
		       currentNode = currentNode.getNext()) {
				if(currentNode.getData().equals(anEntry)) {
					currentNode.setData(start.getData());
					start = start.getNext();
					numberOfEntrys--;
					break;
				}
		    }

		return false;
	}
	//Removes last element added
	@Override
	public T remove() {
		// TODO Auto-generated method stub
		if(isEmpty()==false) {
		start = start.getNext();
		numberOfEntrys--;
		}
		return null;
	}

	@Override
	public void clear() {

		this.start = null;
		numberOfEntrys = 0;
		
		
	}
	
	//Test whether they equal eachother without order
	public boolean equals(LinkedBag<T> a) {
		if(!(a.numberOfEntrys==this.numberOfEntrys)) {return false;}
		boolean found = false;
		for (Node currentNode = start; currentNode != null;
			       currentNode = currentNode.getNext()) {
			T data = (T) currentNode.getData();
			found = false;
			
			for (Node currentNodeA = a.start; currentNodeA != null;
		       currentNodeA = currentNodeA.getNext()) {
				if(data == currentNodeA.getData()) {
					found = true;
				}
		    }
			if (!found) {return false;}
			
		}

		return true;
		
		
	}
	public LinkedBag<T> union(LinkedBag<T> a) {
		T[] dataarray = (T[]) new Object[(a.numberOfEntrys+this.numberOfEntrys)];
		int count =0;
		for (Node currentNode = start; currentNode != null;
			       currentNode = currentNode.getNext()) {
			T data = (T) currentNode.getData();
			dataarray[count] = data;
			count++;
		    }
		for (Node currentNodeA = a.start; currentNodeA != null;
			       currentNodeA = currentNodeA.getNext()) {
				T data = (T) currentNodeA.getData();
				dataarray[count] = data;
				count++;
					}
		
		LinkedBag<T> newlink = new LinkedBag<T>();
		
		for(T data:dataarray) {
			newlink.add(data);
		}
			
		return newlink;	
		}
		
	//Gets Intersection with min of both for duplicates
	public LinkedBag<T> intersection(LinkedBag<T> a) {
		T[] dataarray = (T[]) new Object[Math.max(a.numberOfEntrys, this.numberOfEntrys)];
		int count =0;
		ArrayList<T> elements = new ArrayList<T>();
		for (Node currentNode = start; currentNode != null;
			       currentNode = currentNode.getNext()) {
			T data = (T) currentNode.getData();
			
			for (Node currentNodeA = a.start; currentNodeA != null;
		       currentNodeA = currentNodeA.getNext()) {
				if(data == currentNodeA.getData()&&(!(elements.contains(data)))) {
					dataarray[count]=(T) currentNodeA.getData();
					elements.add((T) currentNodeA.getData()); 
					count++;
					
					
				}
		    }
		
			
			
			
		}
		LinkedBag<T> newlink = new LinkedBag<T>();
		
		for(int x=0;x<count;x++) {
			newlink.add(dataarray[x]);
		}
		
		
		return newlink;
		
		
	}
	
	
}
