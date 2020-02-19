package Project5Tree;

import java.util.Iterator;

public class test {
	
	public static void main(String[] args) {
		BinaryNode<String> B = new BinaryNode<>("B");
		B.setLeftChild(new BinaryNode<>("D"));
		B.setRightChild(new BinaryNode<>("E"));
		
		B.getLeftChild().setLeftChild(new BinaryNode<>("H"));
		B.getLeftChild().setRightChild(new BinaryNode<>("I"));
		B.getLeftChild().getRightChild().setRightChild(new BinaryNode<>("L"));
		
		BinaryNode<String> C = new BinaryNode<>("B");
		C.setLeftChild(new BinaryNode<>("F"));
		C.setRightChild(new BinaryNode<>("G"));
		C.getRightChild().setLeftChild(new BinaryNode<>("J"));
		C.getRightChild().setRightChild(new BinaryNode<>("K"));
		
		BinaryTree<String> A = new BinaryTree<>("A",B,C);
		System.out.println("Height: " + A.getHeight());
		System.out.println("Number of nodes: " + A.getNumberOfNodes());
		System.out.println("LEAFS: " + A.getLeafCount());
		
		
		System.out.println("-[PRE ORDER]-");
		Iterator<String> iter = A.getPreorderIterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		System.out.println("-[POST ORDER]-");
		Iterator<String> iter2 = A.getPostorderIterator();
		while (iter2.hasNext()) {
			System.out.println(iter2.next());
		}
		
		
		System.out.println("-[LEVEL ORDER]-");
		Iterator<String> iter3 = A.getLevelorderIterator();
		while (iter3.hasNext()) {
			System.out.println(iter3.next());
		}
		
		System.out.println("-[IN ORDER]-");
		Iterator<String> iter4 = A.getInorderIterator();
		while (iter4.hasNext()) {
			System.out.println(iter4.next());
		}
	}

}
