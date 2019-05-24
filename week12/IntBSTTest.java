/*
* @author David W. Clendenning Jr.
*/
package week12;

public class IntBSTTest {
	public static void main(String[] args) { 
		IntBST tree = new IntBST(); 

		/* Let us create following BST 
       50 
     /   \ 
	30	 70 
   / \   / \ 
  20 40 60 80
		 */
		tree.insert(50); 
		tree.insert(30); 
		tree.insert(20); 
		tree.insert(40); 
		tree.insert(70); 
		tree.insert(60); 
		tree.insert(80); 

		// print inorder traversal of the BST 
		tree.inorder(); 

		// search array holds various integers to look for in the BST
		int search[] ={0, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
		for (int i = 0; i < search.length; i++) {
			if (tree.find(search[i])) {
				System.out.println(search[i] + " was found in the BST.");
			} else {
				System.out.println(search[i] + " was NOT found in the BST.");
			}
		}
	} 
}