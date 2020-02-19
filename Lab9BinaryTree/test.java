package Lab9BinaryTree;

public class test {
	
	public static void main(String[] args) {
		BinaryNode<String> z = new BinaryNode<>("Left");
		z.setLeftChild(new BinaryNode<>("Left"));
		z.setRightChild(new BinaryNode<>(""));
		BinaryNode<String> x = new BinaryNode<>("Right");
		BinaryTree<String> s = new BinaryTree<>("Start",z,x);
		System.out.println(s.getHeight());
		System.out.println(s.getNumberOfNodes());
	}

}
