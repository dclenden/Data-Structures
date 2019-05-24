//David W. Clendenning Jr. - CIS211 - week 4-5
package week4;

public class LinkedStack<T> implements StackInterface<T> {
	
		Node head;
		
		public void push(T item) {
			if (head == null) {
				// The stack is empty
				Node newNode = new Node(item, null);
				head = newNode;
			} else {
				// Stack is not empty, create a new node at the top of the stack
				// The new item's next link goes to the "old" head
				Node newNode = new Node(item, head);
				
				// Now we can re-assign the link to the new head
				head = newNode;
			}
		}
        /* returns data of 'popped' (head) node and removes it from the stack. */
		public T pop() {
            if(head != null) {
			    Node tempNode = head;
                head = head.getNext();
                return tempNode.getData();
            }
            else {
            	return null;
            }
		}
        /* returns the content of top of stack or the 'head' */
		public T peek() {
			// TODO: Write code to add peek functionality
			if(head == null) {
				/* not sure if I should be printing out a command line here 
				 * System.out.println("Stack is empty");
				 * I would normally have this method just return head.data because it will return null
				 * if it is empty, but i have the if statement here for the console command of 
				 * "Stack is empty".
				*/
				return null;
			}
			else {
			    return head.data;
			}

		}
		
		public int length() {
	        Node n = head; 
	        int length = 0;
	        while (n != null) 
	        { 
	            length++; 
	            n = n.next; 
	        }
	        return length;
		}
		
		/*
		 * Concatenate multiple strings to a single string for representation of object
		 */
		@Override
		public String toString() {
			StringBuilder result = new StringBuilder();
			Node current = head;
			result.append("[");
			while(current != null) {
				result.append(current.getData());
				result.append(", ");
				current = current.getNext();
			}
			result.append("]");
			result.delete(result.length() - 3, result.length() - 1);
			return result.toString();
		}
		
		/* This function prints contents of linked list starting from head */
		// Adapted from https://www.geeksforgeeks.org/linked-list-set-1-introduction/
		// Included for testing purposes
	    public void printList() 
	    { 
	        Node n = head; 
	        while (n != null) 
	        { 
	            System.out.print(n.data+" \n"); 
	            n = n.next; 
	        } 
	    }
		
		// Nested class Node
		private class Node {
			T data;
			Node next;
			
			// Constructor for inner class Node
			Node(T data, Node next) {
				this.data = data;
				this.next = next;
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
		}

	
}
