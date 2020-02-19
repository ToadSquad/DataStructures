package Project5Tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
/*For each node in a binary search tree,
•	The data in a node is greater than or equal to the data in the node’s left subtree
•	The data in a node is less than or equal to the data in the node’s right subtree
Provide a method that searches the tree for a given entry and returns the first one it finds.
Also, provide a method that returns a list of all entries that match the given one.
Searching for a duplicate must allow a search in both subtrees.

*/
public class BinarySearchTree <T extends Comparable < ? super T>> extends BinaryTree <T> implements SearchTreeInterface <T>  {
	
	
	
	BinarySearchTree(){
		super();
	}
	BinarySearchTree(T root){
		super(root);
	}
	@Override
	public void setTree(T root) {
		throw new UnsupportedOperationException();
	}
	@Override
	public void setTree(T rootData, BinaryNode<T> leftTree, BinaryNode<T> rightTree) {
		throw new UnsupportedOperationException();
	}
	/** Searches for a specific entry in the tree
	 * @param entry An object to be found
	 * @return true if the object is in the tree; false otherwise
	 */
	///MODIFY
	private T findEntry(BinaryNode<T> root,T entry) {
		T entryRes = null;
		while(root != null) {
			if(root.hasLeftChild()&&root.getLeftChild().getData().compareTo(entry)==0) {
				return root.getLeftChild().getData();
			}
			else if(root.hasLeftChild()&&root.getLeftChild().getData().compareTo(entry)==1) {
				root = root.getLeftChild();
			}
			else if(root.hasRightChild()&&root.getRightChild().getData().compareTo(entry)==0) {
				return root.getLeftChild().getData();
			}
			else if(root.hasRightChild()&&root.getRightChild().getData().compareTo(entry)==1) {
				root = root.getRightChild();
			}
				
		}
		
		return entryRes;
		
	}
	private ArrayList<T> findAllEntrys(BinaryNode<T> root,T entry) {
		ArrayList<T> entryRes = new ArrayList<>();
			if(root.getData().compareTo(entry)==0) {
				entryRes.add(root.getData());
			
			}
			if(root.hasLeftChild()) {
				entryRes.addAll(findAllEntrys(root.getLeftChild(),entry));
			}
			if(root.hasRightChild()) {
				entryRes.addAll(findAllEntrys(root.getRightChild(),entry));
			}
			
		return entryRes;	
	}

	@Override
	public boolean contains(T entry) {
		// TODO Auto-generated method stub
		return (getEntry (entry) != null);
	}
	/** Retrieves a specific entry in the tree
	 * @param entry An object to be found
	 * @return the object that was found or null, if it was not found
	 * NEEDS TO BE MODIFIED TO RETURN LIST OF ENTRYS. ||||||||||||||||||||||||||||||||||||||||||||
	 */
	@Override
	public T getEntry(T entry) {
		// TODO Auto-generated method stub
		return findEntry(this.getRoot(), entry);
	}
	
	public ArrayList<T> getAllEntrys(T entry){
		return findAllEntrys(this.getRoot(),entry);
	}
	/** Adds a new entry to the tree, if it does not match an 
	 *  existing object;
	 * replaces the existing object with the new entry.
	 * @param newEntry An object to be added
	 * @return null if newEntry was added, and the old entry in case 
	 * of replacement
	 */
	@Override
	public T add(T newEntry) {
		// TODO Auto-generated method stub
		   T result = null;
		   if (isEmpty()) {
		      this.setRoot(new BinaryNode<T>(newEntry));
		   }
		   else {
		       result = addEntry(this.getRoot(), newEntry);
		   }
		   return result;

	}
	//NEEDS TO BE MODIFIED TO ALLOW DUPLICATE ENTRYS ||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
	//Right Node is Greater than or Equal to Left Node.
	private T addEntry ( BinaryNode <T> rootNode, T newEntry){
		   assert rootNode != null;
		   T result = null;
		   int comparison = newEntry.compareTo(rootNode.getData());
		        
		   if(comparison == 0){
			   Random r  = new Random();
			   comparison = r.nextInt(2);
			   if(comparison==0) {
				   comparison = -1;
			   }
			  
		   }
		   if(comparison < 0){
		      if(rootNode.hasLeftChild()){
		         result = addEntry((BinaryNode<T>)rootNode.getLeftChild(),newEntry);
		      }
		      else{
		         rootNode.setLeftChild(new BinaryNode<T>(newEntry));
		         }
		   }
		   else{
		      if(rootNode.hasRightChild()){
		         result = addEntry((BinaryNode<T>)rootNode.getRightChild(),newEntry);
		         }
		      else{
		         rootNode.setRightChild(new BinaryNode<T>(newEntry));
		      }
		   } // end if
		   return result;
		}

	/** Removes a specific entry from the tree.
	 * @param entry An object to be removed.
	 * @return either the object that was removed, or null if no such 
	 * object exists
	 *|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
	 */
	@Override
	public T remove(T entry) {
		// TODO Auto-generated method stub
		return null;
	}
	/** Creates an iterator that traverses all entries in the tree.
	 * @return An iterator that provides sequential and ordered 
	 * access to the entries in the tree
	 * |||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
	 */
	public Iterator<T> getInorderIterator(){
		return super.getInorderIterator();
		
	
	}
	public T getEntryIterative (T entry) {
		BinaryNode <T> startNode = this.getRoot();
		T currData;
		if(startNode == null)
			return null;
		int comparison;
		do{
			currData = startNode.getData();
			comparison = entry.compareTo(currData);
			if (comparison == 0)
				return currData;
			else if (comparison < 0)
				startNode = (BinaryNode<T>) startNode.getLeftChild();
			else 
				startNode = (BinaryNode<T>) startNode.getRightChild();
		} while (startNode != null);
		return null;
	 }


}
