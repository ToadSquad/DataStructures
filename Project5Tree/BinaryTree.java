package Project5Tree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree<T> implements BinaryTreeInterface<T>{
	private BinaryNode<T> root;
	
	BinaryTree(){
		root = null;
	}
	BinaryTree(T rootData){
		root = new BinaryNode<T>(rootData);
		
	}
	BinaryTree(T rootData,BinaryNode<T> left,BinaryNode<T> right){
		this.initializeTree(rootData,left,right);
	}
	private void initializeTree(T rootData,BinaryNode<T> left,BinaryNode<T> right) {
		root = new BinaryNode<T>(rootData);
		root.setLeftChild(left);
		root.setRightChild(right);
	}
	@Override
	public T getRootData() {
		return root.getData();
	}
	
	public int getLeafCount() {
		return root.getLeafCount();
	}

	@Override	
	public int getHeight() {
		// TODO Auto-generated method stub
		int height = root.getHeight();
		return height;
	}

	@Override
	public int getNumberOfNodes() {
		// TODO Auto-generated method stub
		return root.getNumberOfNodes();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		
		return root==null;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		this.root = null;
	}

	@Override
	public Iterator<T> getPreorderIterator() {
		return new PreorderIterator();
	}

	@Override
	public Iterator<T> getPostorderIterator() {
		return new PostorderIterator();
	}

	@Override
	public Iterator<T> getInorderIterator() {
		return new InorderIterator(); 
	}

	@Override
	public Iterator<T> getLevelorderIterator() {
		return new LevelOrderIterator();
	}

	@Override
	public void setTree(T rootData) {
		// TODO Auto-generated method stub
		root = new BinaryNode(rootData);
		
	}

	@Override
	public void setTree(T rootData, BinaryNode<T> leftTree, BinaryNode<T> rightTree) {
		// TODO Auto-generated method stub
		this.initializeTree(rootData, leftTree, rightTree);
	}
	
	private class PreorderIterator implements Iterator <T> {
		private Stack <BinaryNode<T>> nodeStack;
		
		public PreorderIterator() {
			nodeStack = new Stack <> ();
			addToStack (root);
		}
			
		private void addToStack (BinaryNode <T> aNode) {
			if (aNode == null)
				return;
		     BinaryNode <T> right = 
	                         (BinaryNode <T>)aNode.getRightChild();
			BinaryNode <T> left = 
	                         (BinaryNode <T>)aNode.getLeftChild();	
			addToStack (right);
			addToStack (left);
			nodeStack.push(aNode);
		}
		
		public boolean hasNext() {
			return (!nodeStack.isEmpty());
		}
			
		public T next() {
			return nodeStack.pop().getData();
		}

	      public void remove() {
			throw new UnsupportedOperationException();
		}
			
	}
	
	private class PostorderIterator implements Iterator <T> {
		private Stack <BinaryNode<T>> nodeStack;
		
		public PostorderIterator() {
			nodeStack = new Stack <> ();
			addToStack (root);
		}
			
		private void addToStack (BinaryNode <T> aNode) {
			if (aNode == null)
				return;
		     BinaryNode <T> right = 
	                         (BinaryNode <T>)aNode.getRightChild();
			BinaryNode <T> left = 
	                         (BinaryNode <T>)aNode.getLeftChild();
			nodeStack.push(aNode);
			addToStack (left);
			addToStack (right);
			
			
		}
		
		public boolean hasNext() {
			return (!nodeStack.isEmpty());
		}
			
		public T next() {
			return nodeStack.pop().getData();
		}

	      public void remove() {
			throw new UnsupportedOperationException();
		}
			
	}
	
	private class InorderIterator implements Iterator <T> {
		private Stack <BinaryNode<T>> nodeStack;
		
		public InorderIterator() {
			nodeStack = new Stack <> ();
			addToStack (root);
		}
			
		private void addToStack (BinaryNode <T> aNode) {
			if (aNode == null)
				return;
		     BinaryNode <T> right = (BinaryNode <T>)aNode.getRightChild();
			BinaryNode <T> left = (BinaryNode <T>)aNode.getLeftChild();	
			addToStack (right);
			nodeStack.push(aNode);
			addToStack (left);
		}
		
		public boolean hasNext() {
			return (!nodeStack.isEmpty());
		}
			
		public T next() {
			return nodeStack.pop().getData();
		}

	      public void remove() {
			throw new UnsupportedOperationException();
		}
			
	}
	
	private class LevelOrderIterator implements Iterator <T> {
		Queue<BinaryNode<T>> que;
		
		public LevelOrderIterator() {
			que = new LinkedList<>(); 
			addToQue(root);
		}

		private void addToQue (BinaryNode <T> aNode) {
			if (aNode == null)
				return;
		    BinaryNode <T> right = (BinaryNode <T>)aNode.getRightChild();
			BinaryNode <T> left = (BinaryNode <T>)aNode.getLeftChild();	
			que.add(aNode);
			
			addToQue(right);
			addToQue(left);
			
			

		}
		public boolean hasNext() {
			return (!que.isEmpty());
		}
			
		public T next() {
			return (T) que.remove().getData();
		}

	      public void remove() {
			throw new UnsupportedOperationException();
		}
			
	}
	public BinaryNode<T> getRoot(){
		return this.root;
	}
	public void setRoot(BinaryNode<T> root){
	 this.root = root;
	}


	
}
