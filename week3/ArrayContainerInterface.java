//David W. Clendenning Jr. - CIS211 - Week 3
package week3;

public interface ArrayContainerInterface<T> {
	/**
	 * This method adds objects into container
	 * @param item
	 */
	public void add(T item);

	/**
	 * This method checks if the container is full - in other words, if more items cannot be added
	 * @return true if it is full, false otherwise
	 */
	public boolean isFull();
	
	@Override
	public String toString();
}
