/*
* @author David W. Clendenning Jr.
*/
package week12;

public class PokemonBST {
	int comparisonCount = 0;

	/* Class containing left and right child of current node and key value*/
	// Basic changes already made, so the original code that only works with ints can now
	// work with Pokemon objects
	class Node { 
		// int key;
		Pokemon key; 
		Node left, right; 

		//public Node(int item) { 
		public Node(Pokemon item) { 
			key = item; 
			left = right = null; 
		} 
	} 

	// Root of BST 
	Node root; 

	// Constructor 
	PokemonBST() { 
		root = null; 
	} 


	/**
	 * @param name - String of pokemon name we are looking for in the BST
	 * @return a pokemon object that matches that name
	 * 
	 * This findPokemon implementation is a bit different than a traditional search.
	 * When we search for something, the answer is usually, "Yes - we found it."  Perhaps,
	 * it is even followed by an answer of where we found it.
	 * However, in this method, we are returning the object that matches that description.
	 * This method is like retrieving something from a data structure, because the
	 * return type is an object of that type rather than a boolean or location.
	 */
	public Pokemon findPokemon(String name) {
		comparisonCount = 0;
		// TODO: Where does comparisonCount need to be incremented?
		// The goal is to see how efficient the BST is.
		// Another way of asking this question is - how deep did we have to go down the BST
		// in order to find what we were looking for?

		// Try/catch used, since the recursive search method may return null
		try {
			// Since the compareTo method compares two pokemon, we can either change
			// the code every time a comparison is made OR
			// we can create a temporary/dummy pokemon with the property we are most
			// concerned about and use the compareTo method using two
			// Pokemon objects
			Pokemon temp = search(root, new Pokemon(name, 0, 0)).key;
			System.out.println("Comparisons made: " + comparisonCount);
			return temp;
		} catch (NullPointerException e) {
			System.out.println("Pokemon not found!");
			System.out.println("Comparisons made: " + comparisonCount);
			return null;
		}

	}

	// https://www.geeksforgeeks.org/binary-search-tree-set-1-search-and-insertion/
	// TODO: What changes need to be made here to work with Pokemon instead of int?
	public Node search(Node root, Pokemon key) 
	{ 
		comparisonCount++;
		// Base Cases: root is null or key is present at root 
		if (root==null || root.key.compareTo(key) == 0) 
			return root; 

		// val is greater than root's key 
		if (root.key.compareTo(key) > 0) 
			return search(root.left, key); 

		// val is less than root's key 
		return search(root.right, key); 
	}

	// This method mainly calls insertRec() 
	// TODO: What changes need to be made to work with Pokemon instead of int?
	void insert(Pokemon key) { 
		root = insertRec(root, key); 
	} 

	/* A recursive function to insert a new key in BST */
	// TODO: What changes need to be made to work with Pokemon instead of int?
	Node insertRec(Node root, Pokemon key) { 

		/* If the tree is empty, return a new node */
		if (root == null) { 
			root = new Node(key); 
			return root; 
		} 

		/* Otherwise, recur down the tree */
		if (key.compareTo(root.key) < 0) 
			root.left = insertRec(root.left, key); 
		else if (key.compareTo(root.key) > 0) 
			root.right = insertRec(root.right, key); 

		/* return the (unchanged) node pointer */
		return root; 
	}

	// This method mainly calls InorderRec() 
	void inorder() { 
		inorderRec(root); 
	} 

	// A utility function to do inorder traversal of BST 
	void inorderRec(Node root) { 
		if (root != null) { 
			inorderRec(root.left); 
			System.out.println(root.key); 
			inorderRec(root.right); 
		} 
	} 
}
