/*
* @author David W. Clendenning Jr.
*/
package week12;

public class IntBST { 

	/* Class containing left and right child of current node and key value*/
	class Node { 
		int key; 
		Node left, right; 

		public Node(int item) { 
			key = item; 
			left = right = null; 
		} 
	} 

	// Root of BST 
	Node root; 
	int comparisonCount;

	// Constructor 
	IntBST() { 
		root = null; 
	} 

	// This method mainly calls insertRec() 
	void insert(int key) { 
		root = insertRec(root, key); 
	} 

	/* A recursive function to insert a new key in BST */
	Node insertRec(Node root, int key) { 

		/* If the tree is empty, return a new node */
		if (root == null) { 
			root = new Node(key); 
			return root; 
		} 

		/* Otherwise, recur down the tree */
		if (key < root.key) 
			root.left = insertRec(root.left, key); 
		else if (key > root.key) 
			root.right = insertRec(root.right, key); 

		/* return the (unchanged) node pointer */
		return root; 
	} 

	public boolean find(int key) {
		comparisonCount = 0;
		Node node = search(root, key);
		System.out.println(comparisonCount + " comparisons made by the find method.");
		// Where would comparisonCount need to be incremented?
		
		if (node != null) {
			return true; 
		} else {
			return false;
		}
	}

	//https://www.geeksforgeeks.org/binary-search-tree-set-1-search-and-insertion/
	public Node search(Node root, int key) 
	{ 
		comparisonCount++;
		// Base Cases: root is null or key is present at root 
		if (root==null || root.key==key) 
			return root; 

		// val is greater than root's key 
		if (root.key > key) 
			return search(root.left, key); 

		// val is less than root's key 
		return search(root.right, key); 
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