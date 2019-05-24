//David W. Clendenning Jr. - CIS211 - Week 3
package week3;

public class ArrayContainer<T> implements ArrayContainerInterface<T> {
	private T[] container;
	private int defaultSize = 25;
	private int numItems;
	public ArrayContainer() {
		container = (T[]) new Object[defaultSize];
		numItems = 0;
	}
	
	@Override
	public void add(T item) {
		if(numItems < defaultSize) {
			container[numItems] = item;
			numItems++;
		}
	}

	/**
	 * This method checks if the container is full - in other words, if more items cannot be added
	 * @return true if it is full, false otherwise
	 */
	public boolean isFull() {
		if(numItems < defaultSize) {
			/* Not sure if you wanted this implemented or not
			 * System.out.println("There is still space within this array!");
			 */
			return false;
		}
		else {
			/* See above
			 * System.out.println("There is no more space within this array!");
			 */
			return true;
		}
	}
	
	@Override
	public String toString() {
		StringBuilder br = new StringBuilder();
		for(T item: container) {
			if(item != null) {
			    br.append(item);
			    br.append("\n");
			}
		}
		return br.toString();
	}
}
