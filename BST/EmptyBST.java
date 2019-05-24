package BST;
/*
* @author David W. Clendenning Jr.
*/

public class EmptyBST<T extends Comparable> implements Tree<T>{
    
	public EmptyBST() {
		
	}
	
	public boolean isEmpty() {
		return true;
	}
	
	public int cardinality() {
		return 0;
	}
	
	public boolean member(T element) {
		return false;
	}
	
	public NonEmptyBST<T> add(T element){
		return new NonEmptyBST<T>(element);
	}
}
