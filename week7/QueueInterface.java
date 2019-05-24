package week7;

//David W. Clendenning Jr. - Week 7
public interface QueueInterface<T> {
	/**
	 * Inserts the specified element into this queue.
	 */
	public void enqueue(T obj);
	
	/**
	 * Retrieves and removes the head of this queue, or returns null if this queue is empty.
	 */
	public T dequeue();
	
	/**
	 * Retrieves, but does not remove, the head of this queue, or returns null if this queue is empty.
	 */
	public T getFront();
	
	/**
	 * Checks if there are any elements in the queue.
	 * @return true if, and only if, the queue is empty.
	 */
	public boolean isEmpty();
	
	
	/**
	 * @return appropriate string representing the queue
	 */
	@Override
	public String toString();
}
