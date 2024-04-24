// Tommy Hudson Stack.java for GenealogyTree Lab COSC-2436
import java.util.ArrayList;
import java.util.NoSuchElementException;
/**
 * This is a custom implementation of a stack data structure for use in the GenealogyTree lab.
 */
public class Stack 
{
    private int top;        // Top of the stack
    private ArrayList<TreeNode> array; // Array to hold the stack
    

    /**
     * Constructor for Stack
     */
    public Stack()
    {
        this.top = -1;
        this.array = new ArrayList<>();
    }

    /**
     * Method to add an item to the stack
     * @param node Item to add to the stack
     */
    public void push(TreeNode node)
    {
        this.array.add(node);
        this.top = this.top + 1;
    }

    /**
     * Method to remove an item from the stack
     * @return TreeNode Item removed from the stack
     */
    public TreeNode pop() throws NoSuchElementException
    {
        try
        {
            if (isEmpty()) return null;
            TreeNode node = this.array.get(this.top);
            this.array.remove(this.top);
            this.top = this.top - 1;
            return node;
        }
        catch (Exception e)
        {
            throw new NoSuchElementException("No such element in stack");
        }
    }

    /**
     * Method to get the top item of the stack
     * @return TreeNode Top item of the stack
     */
    public TreeNode peek() throws NoSuchElementException
    {
        try
        {
            if (isEmpty()) return null;
            return this.array.get(this.top);
        }
        catch (Exception e)
        {
            throw new NoSuchElementException("No such element in stack");
        }
    }

    /**
     * Method to get the size of the stack
     * @return int Size of the stack
     */
    public int size()
    {
        return this.top + 1;
    }

    /**
     * Method to check if the stack is empty
     * @return boolean True if the stack is empty, false otherwise
     */
    public boolean isEmpty()
    {
        return size() == 0;
    }

    
}
