// Tommy Hudson Queue.java for GenealogyTree Lab COSC-2436
import java.util.ArrayList;
import java.util.NoSuchElementException;
/**
 * This is a custom implementation of a queue data structure for use in the GenealogyTree lab.
 */
public class Queue
{
    /**
     * Inner class to represent a node in the queue
     */
    private static class Node
    {
        @SuppressWarnings("unused")
        TreeNode data;  // Data of the node
        Node next;      // Next node in the queue
    }

    private Node front;      // Front of the queue
    private Node rear;       // Rear of the queue
    private int size;        // Size of the queue
    private ArrayList<TreeNode> array; // Array to hold the queue

    /**
     * Constructor for Queue
     */
    public Queue()
    {
        this.front = null;
        this.rear = null;
        this.size = 0;
        this.array = new ArrayList<>();
    }

    /**
     * Method to add an item to the queue
     * @param node Item to add to the queue
     */
    public void enqueue(TreeNode node)
    {
        Node newNode = new Node();
        newNode.data = node;
        newNode.next = null;
        if (this.front == null)
        {
            this.front = newNode;
        }
        else
        {
            this.rear.next = newNode;
        }
        this.rear = newNode;
        this.size = this.size + 1;
        this.array.add(node);
    }

    /**
     * Method to remove an item from the queue
     * @return TreeNode Item removed from the queue
     */
    public TreeNode dequeue() throws NoSuchElementException
    {
        try
        {
            if (isEmpty()) return null;
            TreeNode node = this.array.get(0);
            this.array.remove(0);
            this.front = this.front.next;
            this.size = this.size - 1;
            return node;
        }
        catch (Exception e)
        {
            throw new NoSuchElementException("No such element in queue");
        }
    }

    /**
     * Method to get the front item of the queue
     * @return TreeNode Front item of the queue
     */
    public TreeNode peek() throws NoSuchElementException
    {
        try
        {
            if (isEmpty()) return null;
            return this.array.get(0);
        }
        catch (Exception e)
        {
            throw new NoSuchElementException("No such element in queue");
        }
    }

    /**
     * Method to get the size of the queue
     * @return int Size of the queue
     */
    public int size()
    {
        return this.size;
    }

    /**
     * Method to check if the queue is empty
     * @return boolean True if the queue is empty, false otherwise
     */
    public boolean isEmpty()
    {
        return size() == 0;
    }
}
