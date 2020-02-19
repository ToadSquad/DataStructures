package Lab9BinaryTree;

public class BinaryNode<T> implements BinaryNodeInterface<T>{
	private T data;
	private BinaryNode<T> left;
	private BinaryNode<T> right;
	BinaryNode(){
		this.data = null;
	}
	BinaryNode(T data){
		this.data = data;
	}
	@Override
	public T getData() {
		// TODO Auto-generated method stub
		return data;
	}

	@Override
	public void setData(T newData) {
		// TODO Auto-generated method stub
		this.data = newData;
	}

	@Override
	public BinaryNodeInterface<T> getLeftChild() {
		// TODO Auto-generated method stub
		return left;
	}

	@Override
	public BinaryNodeInterface<T> getRightChild() {
		// TODO Auto-generated method stub
		return right;
	}

	@Override
	public void setLeftChild(BinaryNodeInterface<T> leftChild) {
		// TODO Auto-generated method stub
		this.left = (BinaryNode<T>) leftChild;
	}

	@Override
	public void setRightChild(BinaryNodeInterface<T> rightChild) {
		// TODO Auto-generated method stub
		this.right = (BinaryNode<T>) rightChild;
	}

	@Override
	public boolean hasLeftChild() {
		// TODO Auto-generated method stub
		return this.left!=null;
	}

	@Override
	public boolean hasRightChild() {
		// TODO Auto-generated method stub
		return this.right!=null;
	}

	@Override
	public boolean isLeaf() {
		// TODO Auto-generated method stub
		return this.right==null&&this.left==null;
	}

	//Number of Nodes left in Tree
	@Override
	public int getNumberOfNodes() {
		// TODO Auto-generated method stub 
		int leftHeight = 0;
		int rightHeight = 0;
		int nodes = 0;
		BinaryNode<T> left = this.left;
		BinaryNode<T> leftRight = this.left;
		if(this.hasLeftChild()) {
			leftHeight = this.left.getHeight();
			leftHeight++;
		}
		if(this.hasRightChild()) {
			rightHeight = this.right.getHeight();
			leftHeight++;
		}
		if(this.isLeaf()) {
			nodes++;
		}
		
		return (leftHeight+rightHeight+nodes);
	}
	//Returns overall tree height
	@Override
	public int getHeight() {
		int leftHeight = 0;
		int rightHeight = 0;
		if(this.hasLeftChild()) {
			leftHeight = this.left.getHeight();
		}
		if(this.hasRightChild()) {
			rightHeight = this.right.getHeight();
		}
		int height = 1+Math.max(leftHeight, rightHeight);
		// TODO Auto-generated method stub
		return height;
	}

	@Override
	public BinaryNodeInterface<T> copy() {
		BinaryNode<T> newTree = new BinaryNode(this.data);
		if(this.left!=null) {
			newTree.left = (BinaryNode<T>) this.left.copy();
		}
		if(this.right!=null) {
			newTree.right = (BinaryNode<T>) this.right.copy();
		}
		// TODO Auto-generated method stub
		return newTree;
	}

}
