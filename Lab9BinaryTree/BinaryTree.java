package Lab9BinaryTree;

import java.util.Iterator;

public class BinaryTree<T> implements BinaryTreeInterface<T>{
	private BinaryNode<T> root;
	
	BinaryTree(){
		root = null;
	}
	BinaryTree(T rootData){
		root = new BinaryNode<T>(rootData);
		
	}
	BinaryTree(T rootData,BinaryNodeInterface<T> left,BinaryNodeInterface<T> right){
		this.initializeTree(rootData,left,right);
	}
	private void initializeTree(T rootData,BinaryNodeInterface<T> left,BinaryNodeInterface<T> right) {
		root = new BinaryNode<T>(rootData);
		root.setLeftChild(left);
		root.setRightChild(right);
	}
	@Override
	public T getRootData() {
		// TODO Auto-generated method stub
		
		return root.getData();
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
		return root.getNumberOfNodes()==0;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		this.root = null;
	}

	@Override
	public Iterator<T> getPreorderIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<T> getPostorderIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<T> getInorderIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<T> getLevelorderIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setTree(T rootData) {
		// TODO Auto-generated method stub
		root = new BinaryNode(rootData);
		
	}

	@Override
	public void setTree(T rootData, BinaryNodeInterface<T> leftTree, BinaryNodeInterface<T> rightTree) {
		// TODO Auto-generated method stub
		this.initializeTree(rootData, leftTree, rightTree);
	}
	
}
