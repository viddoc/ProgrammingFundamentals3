
/**
 * This is a class for a custom implementation of a doubly linked list. I am making it generic so that it can be used for any type of data.
 */
public class DoublyLinkedList<T> implements List<T>
{
    
    Node<T> head;   // The head of the linked list.
    Node<T> tail;   // The tail of the linked list.
    int size;       // The size of the linked list.

    /**
     * This is the node inner class which is used to create the nodes of the linked list.
     */
    private static final class Node<T>
    {
        T data;            // The data to be stored in the node.
        Node<T> next;      // The reference to the next node in the list.
        @SuppressWarnings("unused")
        Node<T> prev;      // The reference to the previous node in the list.
        /**
         * This is the constructor for the node class which initializes the data of the node and sets the next and previous nodes to null.
         * @param data The data to be stored in the node.
         */
        Node(T data)
        {
            this.data = data;
        }
    }
    
    
    
    /**
     * This is the default constructor for the linked list class which initializes the head and tail of the list to null.
     */
    public DoublyLinkedList()
    {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * This method is used to insert a new node with the specified data at the end of the list.
     * @param data The data to be inserted in the node.
     */
    public void append(T data)
    {
        Node<T> newNode = new Node<>(data); // Create a new node with the specified data.
        // If the list is empty, then the new node is the head of the list.
        if(head == null)
        {
            head = newNode;
            tail = newNode;
        }
        // Else, traverse the list to find the last node and insert the new node at the end.
        else
        {
            Node<T> last = head; // Start from the head of the list.
            // Traverse the list to find the last node.
            while(last.next != null)
            {
                last = last.next; // Move to the next node.
            }
            last.next = newNode; // Insert the new node at the end of the list.
            newNode.prev = last; // Set the previous of the new node to the last node.
            tail = newNode; // Set the new node as the tail of the list.
        }
        size++;
    }

    /**
     * This method is used to insert a new node with the specified data at the beginning of the list.
     * @param data The data to be inserted in the node.
     */
    public void prepend(T data)
    {
        Node<T> newNode = new Node<>(data); // Create a new node with the specified data.
        if (head == null) // If the list is empty, then the new node is the head of the list.
        {
            head = newNode;
            tail = newNode;
        }
        else
        {
            newNode.next = head; // Set the next of the new node to the head of the list.
            head.prev = newNode; // Set the previous of the head to the new node.
            head = newNode; // Set the new node as the head of the list.
        }
        size++;
    }

    /**
     * This method is used to insert a new node with the specified data at the specified index in the list.
     * @param index The index at which the new node is to be inserted.
     * @param data The data to be inserted in the node.
     */
    public void insert(T data, int index)
    {
        Node<T> newNode = new Node<>(data); // Create a new node with the specified data.
        Node<T> current = head; // Start from the head of the list.
        // If the index is 0, then insert the new node at the beginning of the list.
        if (index == 0)  
        {
            prepend(data); 
        }
        // Else if the index is the size of the list, then insert the new node at the end of the list.
        else if (index == size) 
        {
            append(data);
        }
        // Else, traverse the list to find the node at the specified index.
        else 
        {
            // Traverse the list to find the node at the specified index.
            for(int i = 0; i < index-1; i++)
            {
                current = current.next; // Move to the next node.
            }
            newNode.next = current.next; // Set the next of the new node to the next of the current node.
            current.next.prev = newNode; // Set the previous of the node after the current node to the new node.
            current.next = newNode; // Set the next of the current node to the new node.
            newNode.prev = current; // Set the previous of the new node to the current node.
            size++;
        }
    }

    /**
     * This method is used to modify the data of the node at the specified index in the list.
     * @param index The index of the node to be set.
     * @param data The data to be set in the node.
     */
    public T set(int index, T data)
    {
        T old = getData(index); // Store the old data of the node.
        getNode(index).data = data; // Set the data of the node at the specified index.
        return old; // Return the old data of the node.
    }

    /**
     * This method is used to remove the node with the specified data from the list.
     * @param data The data to be removed from the list.
     */
    public T remove(T data)
    {
        Node<T> current = head; // Start from the head of the list.
        // If the head of the list contains the specified data, then remove the head of the list.
        if(head.data == data)
        {
            removeFirst();
            return current.data; // Return the data of the removed node.
        }
        // Else, traverse the list to find the node with the specified data and remove it from the list.
        else
        {
            // Traverse the list to find the node with the specified data.
            while(current.next != null)
            {
                // If the current node contains the specified data, then remove it from the list.
                if(current.next.data == data)
                {
                    current.next = current.next.next; // Set the next of the current node to the next of the next node.
                    current.next.prev = current; // Set the previous of the node after the current node to the current node.
                    size--;
                    return current.data; // Return the data of the removed node.
                }
                current = current.next; // Move to the next node.
            }
            System.out.println("Data not found.");
            return null; // Return null if the specified data is not found in the list.
        }
    }

    /**
     * This method is used to remove the first node from the list.
     */
    public T removeFirst()
    {
        head = head.next; // Set the next of the head as the new head of the list.
        head.prev = null; // Set the previous of the new head to null.
        size--;
        return head.data; // Return the data of the removed node.
    }

    /**
     * This method is used to remove the last node from the list.
     */
    public T removeLast()
    {
        Node<T> current = head; // Start from the head of the list.
        // Traverse the list to find the second last node.
        while(current.next.next != null)
        {
            current = current.next; // Move to the next node.
        }
        current.next = null; // Set the next of the second last node to null.
        tail = current; // Set the second last node as the tail of the list.
        size--;
        return current.data; // Return the data of the removed node.
    }

    /**
     * This method is used to delete the node at the specified index in the list.
     */
    public T remove(int index)
    {
        Node<T> current = head; // Start from the head of the list.
        // If the index is out of bounds, then return null.
        if(index < 0 || index >= size)
        {
            System.out.println("Index out of bounds.");
            return null;
        }
        // Else if the index is 0, then remove the head of the list.
        else if(index == 0)
        {
            removeFirst();
            return current.data; // Return the data of the removed node.
        }
        // Else, if the index is the size of the list, then remove the last node from the list.
        else if(index == size-1)
        {
            removeLast();
            return current.data; // Return the data of the removed node.
        }
        // Else, traverse the list to find the node at the specified index and remove it from the list.
        else
        {
            // Traverse the list to find the node at the specified index.
            for(int i = 0; i < index-1; i++)
            {
                current = current.next; // Move to the next node.
            }
            current.next = current.next.next; // Set the next of the current node to the next of the next node.
            current.next.prev = current; // Set the previous of the node after the current node to the current node.
            size--;
            return current.data; // Return the data of the removed node.
        }
    }

    /**
     * This method is used to print the elements of the list.
     */
    public void print()
    {
        Node<T> current = head; // Start from the head of the list.
        // Traverse the list to print the elements of the list.
        while(current != null)
        {
            System.out.print(current.data + " "); // Print the data of the current node.
            current = current.next; // Move to the next node.
        }
        System.out.println(); // Print a new line.
    }

    /**
     * This method is used to get the size of the list.
     * @return The size of the list.
     */
    public int size()
    {
        return size; // Return the size of the list.
    }

    /**
     * This method is used to check if the list is empty.
     * @return True if the list is empty, false otherwise.
     */
    public boolean isEmpty()
    {
        return size == 0; // Return true if the size of the list is 0, false otherwise.
    }

    /**
     * This method is used to check if the list contains the specified data.
     */
    public boolean contains(T data)
    {
        Node<T> current = head; // Start from the head of the list.
        // Traverse the list to find the node with the specified data.
        while(current != null)
        {
            // If the current node contains the specified data, then return true.
            if(current.data == data)
            {
                return true;
            }
            current = current.next; // Move to the next node.
        }
        return false; // Return false if the specified data is not found in the list.
    }

    /**
     * This method is used to get the Node at the specified index in the list. 
     * Starts at the tail or head depending on the index passed.
     * @param index The index of the data to be retrieved.
     * @return The Node at the specified index in the list.
     */
    public Node<T> getNode(int index)
    {
        Node<T> current;
        // Traverse the list to find the node at the specified index.
        // If the index is in the first half start from the head, else start from the tail
        if (index < size / 2)
        {
            current = head; // Start from the head of the list.
            while (index-- > 0)
            {
            current = current.next;
            }
        }
        else
        {
            current = tail;
            // n greater than size/2, iterate from end
            while (++index < size)
            {
                current = current.prev;
            }
        }
        return current; // Return the data of the node at the specified index.
    }

    /**
     * This method is used to get the data at the specified index in the list.
     * @param index The index of the data to be retrieved.
     * @return The data at the specified index in the list.
     */
    public T getData(int index)
    {
        return getNode(index).data; // Return the data of the node at the specified index.
    }

    /**
     * This method is used to get the index of the specified data in the list.
     * @param data The data to be searched in the list.
     */
    public int getIndex(T data)
    {
        Node<T> current = head; // Start from the head of the list.
        int index = 0; // Initialize the index to 0.
        // Traverse the list to find the node with the specified data.
        while(current != null)
        {
            // If the current node contains the specified data, then return the index.
            if(current.data == data)
            {
                return index;
            }
            current = current.next; // Move to the next node.
            index++; // Increment the index.
        }
        return -1; // Return -1 if the specified data is not found in the list.
    }

    /**
     * This method is used to clear the list.
     */
    public void clear()
    {
        head = null; // Set the head of the list to null.
        tail = null; // Set the tail of the list to null.
        size = 0; // Set the size of the list to 0.
    }
}
