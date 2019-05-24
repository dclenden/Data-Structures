//David W. Clendenning Jr. - Week 7
package week7;

public class LinkedQueue<T> {
	Node front;
	Node back;
	
	public LinkedQueue() {
		front = null;
		back = null;
	}
	
	public void enqueue(T obj) {
		if (isEmpty()) {
			Node node = new Node(obj, null, null);
			front = node;
			back = node;
		} else {
			Node node = new Node(obj, null, back);
			back.setNext(node);
			back = node;
		}
	}

	public T dequeue() {
		// TODO Implement dequeue
		// Now we have to be careful to make sure we think of the various scenarios
		// and update the prev and next links accordingly
		 if(front == null) {
			 back = null;
			 return null;
		 }
		 else {
			 /*
			  * setting front to front.next then using an if statement to check if null,
			  * this is to makeup for the case that front.next == null
			  */
			 T data = front.data;
			 front = front.next;
			 if(front != null) {
				 front.prev = null;
			 }
			 return data;
		 }
			
	}

	public T getFront() {
		// TODO Implement getFront
		if(front == null) {
			return null;
		}
		else {
			return front.data;
		}
	}

	public boolean isEmpty() {
		// TODO Implement isEmpty
		
		return front == null;
	}
	
	/* toString that traverses through the Doubly Linked List */
	@Override
	public String toString() {
		// TODO Implement toString method
		StringBuilder sb = new StringBuilder();
		Node current = front;
		sb.append("Queue: ");
		if(current == null) {
			sb.append("Queue is empty");
		}
		while(current != null) {
			sb.append(current.getData());
			sb.append(" ");
			current = current.getNext();
		}
		return sb.toString();
	}
	
	// Nested class Node
	// For queues, it is helpful to implement this as a doubly linked list
	// Therefore, we keep track of both next and previous nodes
	private class Node {
		T data;
		Node next;
		Node prev;
		
		// Constructor for inner class Node
		Node(T data, Node next, Node prev) {
			this.data = data;
			this.next = next;
			this.prev = prev;
		}
		
		// Setters & Getters for inner class Node
		public T getData() {
			return data;
		}
		public void setData(T data) {
			this.data = data;
		}
		public Node getNext() {
			return next;
		}
		public void setNext(Node next) {
			this.next = next;
		}
		public Node getPrev() {
			return prev;
		}
		public void setPrev(Node prev) {
			this.prev = prev;
		}
	}
}
