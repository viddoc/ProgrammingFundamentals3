//Tommy Hudson dynamicArray class

/**
 * This class will be used to implement a custom dynamic array as a list. I am making it generic so that it can be used for any type of data.
 * It is just an exploration of how to implement a dynamic array from scratch and to understand the underlying concepts.
 */
public class dynamicArray<T>
{
    private Object[] arr;
    private int size;
    private int capacity;
    
    /**
     * This method is used to check if the array is full and needs to be resized.
     */
    private void checkSize()
    {
        if(size == capacity)
        {
            resize();
        }
    }
    /**
     * This method is used to resize the array when it is full.
     */
    private void resize()
    {
        Object[] newData = new Object[capacity*2];
        for(int i = 0; i < capacity; i++)
        {
            newData[i] = arr[i];
        }
        arr = newData;
        capacity *= 2;
    }

    /**
     * This is the default constructor for the dynamicArray class. It initializes the array with an initial capacity of the array to 10.
     */
    public dynamicArray()
    {
        this.capacity = 10;
        arr = new Object[capacity];
        this.size = 0;
    }
    /**
     * This is the constructor for the dynamicArray class with capacity passed. It initializes the array with the initial capacity specified.
     * @param capacity The initial capacity of the array.
     */
    public dynamicArray(int capacity)
    {
        this.capacity = capacity;
        arr = new Object[capacity];
        this.size = 0;
    }
    /**
     * This is the constructor for the dynamicArray class with the objects passed. It initializes the initial capacity of the array to twice the number of objects 
     * and adds the specified objects to the array.
     * @param objs The objects to be added to the array.
     */
    public dynamicArray(Object... objs)
    {
        this.capacity = objs.length*2;
        arr = new Object[capacity];
        for(int i = 0; i < objs.length; i++)
        {
            arr[i] = objs[i];
            size++;
        }
    }
    /**
     * This method returns the object at the specified index.
     * @param index The index of the object to be returned.
     * @return The object at the specified index.
     */
    public Object get(int index)
    {
        return arr[index];
    }
    /**
     * This method modifies the object at the specified index.
     * @param index The index of the object to be modified.
     * @param obj The new object to be placed at the specified index.
     */
    public void set(int index, Object obj)
    {
        arr[index] = obj;
    }
    /**
     * This method adds an object to the end of the array.
     * @param obj The object to be added.
     */
    public void append(Object obj)
    {
        checkSize();
        arr[size] = obj;
        size++;
    }
    /**
     * This method adds an object at the index specified.
     * @param index The index at which the object is to be added.
     * @param obj The object to be added.
     */
    public void insert(int index, Object obj)
    {
        checkSize();
        for(int i = size; i > index; i--)
        {
            arr[i] = arr[i-1];
        }
        arr[index] = obj;
        size++;
    }
    /**
     * This method adds an object to the beginning of the array.
     * @param obj The object to be added.
     */
    public void prepend(Object obj)
    {

        insert(0, obj);

    }
    /**
     * This method deletes the object at the specified index.
     * @param index The index of the object to be deleted.
     */
    public void delete(int index)
    {
        for(int i = index; i < size-1; i++)
        {
            arr[i] = arr[i+1];
        }
        size--;
    }
    /**
     * This method checks if the array is empty.
     * @return True if the array is empty, false otherwise.
     */
    public boolean isEmpty()
    {
        return size == 0;
    }
    /**
     * This method is used to check if the array contains the specified object.
     * @param obj The object to be checked.
     * @return True if the object is in the array, false otherwise.
     */
    public boolean contains(Object obj)
    {
        for(int i = 0; i < size; i++)
        {
            if(arr[i].equals(obj))
            {
                return true;
            }
        }
        return false;
    }
    /**
     * This method returns the size of the array.
     * @return The size of the array.
     */
    public int size()
    {
        return size;
    }
    
    /**
     * This method is used to search for an object in the array.
     * @param obj The object to be searched for.
     */
    public void search(Object obj)
    {
        for(int i = 0; i < size; i++)
        {
            if(arr[i].equals(obj))
            {
                System.out.println("The object is at index " + i);
                return;
            }
        }
        System.out.println("The object is not in the array.");
    }
    /**
     * This method is used to clear the array.
     */
    public void clear()
    {
        arr = new Object[capacity];
        size = 0;
    }
    /**
     * This method is used to print the array.
     */
    public void print()
    {
        for(int i = 0; i < size; i++)
        {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
