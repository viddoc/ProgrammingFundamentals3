// Tommy Hudson SortedNumberList.java
public class SortedNumberList 
{
	public Node head;
	public Node tail;

	public SortedNumberList() 
	{
		head = null;
		tail = null;
	}
	/**
	 * This method is used to test the size of the list.
	 * @return count
	 */
	private int testSize()
	{
		Node current = head;
		int count = 0;
		while (current != null)
		{
			count++;
			current = current.getNext();
		}
		return count;
	}
	/**
     Inserts the number into the list in the correct position such that the
	 list remains sorted in ascending order.
	 */
	public void insert(double number) 
	{
		// Create a new node with the specified number value.
		Node newNode = new Node(number);	
		// If the list is empty, set the new node as the head and tail.
		if (head == null) 
		{					
			head = newNode;
			tail = newNode;
		} 
		// If the number is less than the head, set the new node as the head.
		else if (head.getData() > number)	 	
		{
			newNode.setNext(head);
			head.setPrevious(newNode);
			head = newNode;
		} 
		// If the number is greater than the tail, set the new node as the tail.
		else if (tail.getData() < number) 	
		{
			newNode.setPrevious(tail);
			tail.setNext(newNode);
			tail = newNode;
		} 
		// Otherwise, find the correct position to insert the new node.
		else 								
		{
			Node current = head;
			// Find the first node with a number greater than the specified number.
			while (current.getData() < number) 
			{
				current = current.getNext();
			}
			newNode.setNext(current);					// Set the new node's next reference to the current node.
			newNode.setPrevious(current.getPrevious()); // Set the new node's previous reference to the current node's previous reference.
			current.getPrevious().setNext(newNode);		// Set the current node's previous node's next reference to the new node.
			current.setPrevious(newNode);				// Set the current node's previous reference to the new node.
		}
	}
	/**
	Removes the node with the specified number value from the list. Returns
	true if the node is found and removed, false otherwise.
	*/
	public boolean remove(double number) 
	{
		// If the list is empty, return false.
		Node current = head;
		// Find the node with the specified number value.
		while (current != null) 
		{
			// If the list has only one node, remove it and set the head and tail to null.
			if (testSize() == 1)
			{
				if (current.getData() == number)
				{
					head = null;
					tail = null;
					return true;
				}
				else
				{
					return false;
				}
			}
			// If the node is found, remove it from the list.
			if (current.getData() == number) 
			{
				// If the node is the head or tail, set the head or tail to the next or previous node.
				if (current == head) 
				{
					head = current.getNext();
					head.setPrevious(null);
				} 
				// If the node is the tail, set the tail to the previous node.
				else if (current == tail) 
				{
					tail = current.getPrevious();
					tail.setNext(null);
				} 
				// Otherwise, set the previous node's next reference to the current node's next reference and the next node's previous reference to the current node's previous reference.
				else 
				{
					current.getPrevious().setNext(current.getNext());
					current.getNext().setPrevious(current.getPrevious());
				}
				return true;
			}
			// Move to the next node.
			current = current.getNext();
		}
		// If the node is not found, return false.
		return false;
	}
}
