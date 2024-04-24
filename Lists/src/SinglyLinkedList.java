// Tommy Hudson singlyLinkedList class

/**
 * This class will be used to implement a custom singly linked list. I am making it generic so that it can be used for any type of data.
 */
public class SinglyLinkedList<T> implements List<T>
{
    
    Node<T> head; // The head of the linked list.
    int size;     // The size of the linked list.

    /**
     * This is the node inner class which is used to create the nodes of the linked list.
     */
    private static final class Node<T>
    {
        T data;    // The data to be stored in the node.
        Node<T> next;      // The reference to the next node in the list.    
        /**
         * This is the constructor for the node class which initializes the data of the node and sets the next node to null.
         * @param data The data to be stored in the node.
         */
        Node(T data)
        {
            this.data = data;
        }
        
    }
       
    /**
     * This is the default constructor for the linked list class which initializes the head of the list to null.
     */
    public SinglyLinkedList()
    {
        this.head = null;
        this.size = 0;
    }

    /**
     * This method is used to insert a new node with the specified data at the end of the list.
     * @param data The data to be inserted in the node.
     */
    public void append(T data)
    {
        Node<T> newNode = new Node<>(data); // Create a new node with the specified data.
        newNode.next = null; // Set the next of the new node to null.
        // If the list is empty, then the new node is the head of the list.
        if(head == null)
        {
            head = newNode;
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
        if(head == null)
        {
            newNode.next = null; // Set the next of the new node to null.
        }
        else
        {
            newNode.next = head; // Set the next of the new node to the head of the list.
        }
        head = newNode; // Set the new node as the head of the list.
        size++;
    }

    /**
     * This method is used to insert a new node with the specified data at the specified position in the list.
     * @param data The data to be inserted in the node.
     * @param position The position at which the new node is to be inserted.
     */
    public void insert(T data, int index)
    {
        Node<T> newNode = new Node<>(data); // Create a new node with the specified data.
        Node<T> currentNode = head; // Start from the head of the list.
        // If the position is 0, then insert the new node at the beginning of the list.
        if(index == 0)
        {
            prepend(data);
        }
        // Else, if the position is the size of the list, then insert the new node at the end of the list.
        else if(index == size)
        {
            append(data);
        }
        // Else, traverse the list to find the node at the specified position and insert the new node at that position.
        else
        {
            // Traverse the list to find the node at the specified position.
            for(int i = 0; i < index - 1; i++)
            {
                currentNode = currentNode.next; // Move to the next node.
            }
            newNode.next = currentNode.next; // Set the next of the new node to the next of the current node.
            currentNode.next = newNode; // Set the new node as the next of the current node.
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
        Node<T> currentNode = head; // Start from the head of the list.
        Node<T> prev = null; // The previous node of the current node.
        // If the head node contains the data to be removed, then remove the head node.
        if(currentNode != null && currentNode.data == data)
        {
            head = currentNode.next; // Set the next node as the head of the list.
        }
        // Else, traverse the list to find the node with the specified data and remove it.
        while(currentNode != null && currentNode.data != data)
        {
            prev = currentNode; // Set the previous node to the current node.
            currentNode = currentNode.next; // Move to the next node.
        }
        // If the data is not found in the list, then return the list as it is.
        if(currentNode == null)
        {
            System.out.println("The data is not found in the list.");
            return null;
        }
        prev.next = currentNode.next; // Remove the current node from the list.
        size--;
        return currentNode.data; // Return the data of the removed node.
    }

    /**
     * This method is used to remove the node at the specified index from the list.
     * @param index The index of the node to be removed from the list.
     */
    public T remove(int index)
    {
        Node<T> currentNode = head; // Start from the head of the list.
        // If the index is out of bounds, then return null.
        if (index >= size || index < 0) 
        {
            System.out.println("Index out of bounds");
            return null;
        }
        // Else, if the index is 0, then remove the head node.
        else if(index == 0)
        {
            removeFirst();
            return currentNode.data; // Return the data of the removed node.
        }
        // Else, traverse the list to find the node at the specified index and remove it.
        else
        {
            // Traverse the list to find the node at the specified index.
            for(int i = 0; i < index - 1; i++)
            {
                currentNode = currentNode.next; // Move to the next node.
            }
            currentNode.next = currentNode.next.next; // Remove the node at the specified index from the list.
            size--;
            return currentNode.data; // Return the data of the removed node.
        }
    }

    /**
     * This method is used to remove the first node from the list.
     */
    public T removeFirst()
    {
        Node<T> currentNode = head; // Start from the head of the list.
        head = currentNode.next; // Set the next node as the head of the list.
        size--;
        return currentNode.data; // Return the data of the removed node.
    }

    /**
     * This method is used to remove the last node from the list.
     */
    public T removeLast()
    {
        Node<T> currentNode = head; // Start from the head of the list.
        Node<T> prev = null; // The previous node of the current node.
        // Traverse the list to find the last node.
        while(currentNode.next != null)
        {
            prev = currentNode; // Set the previous node to the current node.
            currentNode = currentNode.next; // Move to the next node.
        }
        prev.next = null; // Remove the last node from the list.
        size--;
        return currentNode.data; // Return the data of the removed node.
    }

    /**
     * This method is used to check if the list is empty.
     * @return True if the list is empty, false otherwise.
     */
    public boolean isEmpty()
    {
        return size == 0;
    }

    /**
     * This method is used to check if the list contains the specified data.
     * @param data The data to be checked.
     * @return True if the data is in the list, false otherwise.
     */
    public boolean contains(T data)
    {
        Node<T> currentNode = head; // Start from the head of the list.
        // Traverse the list to find the node with the specified data.
        while(currentNode != null)
        {
            if(currentNode.data == data)
            {
                return true; // Return true if the data is found in the list.
            }
            currentNode = currentNode.next; // Move to the next node.
        }
        return false; // Return false if the data is not found in the list.
    }

    /**
     * This method is used to get the size of the list.
     * @return The size of the list.
     */
    public int size()
    {
        return size;
    }

    /**
     * This method is used to print the list.
     */
    public void print()
    {
        Node<T> currentNode = head; // Start from the head of the list.
        // Traverse the list and print the data of each node.
        while(currentNode != null)
        {
            System.out.print(currentNode.data + " -> "); // Print the data of the current node.
            currentNode = currentNode.next; // Move to the next node.
        }
    }

    /**
     * This method is used to reverse the list.
     */
    public void reverse()
    {
        Node<T> prev = null; // The previous node of the current node.
        Node<T> next = null; // The next node of the current node.
        Node<T> currentNode = head; // Start from the head of the list.
        // Traverse the list and reverse the links of each node.
        while(currentNode != null)
        {
            next = currentNode.next; // Set the next node to the next of the current node.
            currentNode.next = prev; // Set the next of the current node to the previous node.
            prev = currentNode; // Set the previous node to the current node.
            currentNode = next; // Move to the next node.
        }
        head = prev; // Set the last node as the head of the list.
    }

    /**
     * This method is used to get the data at the specified index in the list.
     * @param index The index of the data to be retrieved.
     * @return The data at the specified index.
     */
    public Node<T> getNode(int index)
    {
        Node<T> currentNode = head; // Start from the head of the list.
        // Traverse the list to find the node at the specified index.
        for(int i = 0; i < index; i++)
        {
            currentNode = currentNode.next; // Move to the next node.
        }
        return currentNode; // Return the data of the node at the specified index.
    }

    /**
     * This method is used to get the data at the specified index in the list.
     * @param index The index of the data to be retrieved.
     */
    public T getData(int index)
    {
        return getNode(index).data;
    }

    /**
     * This method is used to find the index of the specified data in the list.
     * @param data The data to be searched.
     * @return The index of the data in the list.
     */
    public int getIndex(T data)
    {
        Node<T> currentNode = head; // Start from the head of the list.
        int index = 0; // The index of the current node.
        // Traverse the list to find the node with the specified data.
        while(currentNode != null)
        {
            if(currentNode.data == data)
            {
                return index; // Return the index of the data in the list.
            }
            currentNode = currentNode.next; // Move to the next node.
            index++; // Increment the index.
        }
        return -1; // Return -1 if the data is not found in the list.
    }

    /**
     * This method is used to clear the list.
     */
    public void clear()
    {
        head = null; // Set the head of the list to null.
        size = 0; // Set the size of the list to 0.
    }
}
