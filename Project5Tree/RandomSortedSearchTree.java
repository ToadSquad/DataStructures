package Project5Tree;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class RandomSortedSearchTree {
	public static void main(String[] args) throws FileNotFoundException {
		//Randomly Built Tree with N Nodes and Integers 2^h+1 where h is randomly (4-10)
		Random random = new Random();
		BinarySearchTree<Integer> newTree = null;
		int loopFor = random.nextInt(50)+1;
		for(int x = 0;x<loopFor;x++) {
			int h = random.nextInt(7)+4;
			int root = (int) (Math.pow(2, h)-1);
			if(newTree == null) {
				newTree = new BinarySearchTree<>(root);
			}
			else {
				newTree.add(root);
			} 
			
		}
		
		Iterator<Integer> tree = newTree.getInorderIterator();
		//OUTPUT USING INORDER ITERATOR
		int actual = 0;
		while(tree.hasNext()) {
			System.out.println(tree.next());
			actual++;
		}		
		System.out.println("Number of Nodes: "+actual+" Expected: "+loopFor);
		//COMPARE HEIGHT WITH SHORTEST HEIGHT
		double shortest = Math.floor(Math.log(loopFor)/Math.log(2));
		System.out.println("Tree Height: "+newTree.getHeight()+" Shortest Height: "+shortest);
		//Search Tree of Name built from file
		BinarySearchTree<Name<Name>> newTree2 = null;
		Scanner s = new Scanner(new File("C:\\Users\\parkerj12\\Desktop\\Summer\\DataStructures\\src\\names.txt"));
		while(s.hasNextLine()) {
			Name newName = new Name(s.nextLine());
			if(newTree2 == null) {
				newTree2 = new BinarySearchTree<>(newName);
			}
			else {
				newTree2.add(newName);
			}
		}
		//Print All
		//Iterator<Name<Name>> tree2 = newTree2.getInorderIterator();
		//while(tree2.hasNext()) {
		//	System.out.println(tree2.next().toString());
		//}
		//Get All Johns
		Name comp = new Name("John S");
		ArrayList<Name> a = newTree2.getAllEntrys(comp);
		System.out.println("Johns: 3"+" Actual: "+a.size());
		for(Name names:a) {
			System.out.println(names.toString());
		}
	}
}
