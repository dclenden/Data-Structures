//David W. Clendenning Jr. - CIS211 - week 4-5
package week4;

public interface StackInterface<T> {
	/** Push an element onto the top of the stack. 
	 * @param item The element being pushed onto the stack. */ 
	public void push(T item);
	
	/** Remove and return the element at the top of the stack. 
	 * @return The element at the top of the stack. */ 
	public T pop();
	
	/** @return A copy of the top element. */ 
	public T peek();

	/** @return how many items are in the stack */
	public int length();
	
	@Override
	public String toString();
}
