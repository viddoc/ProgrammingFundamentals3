
interface List<T>
{
    public void append(T data);
    public void prepend(T data);
    public void insert(T data, int index);
    public T set(int index, T data);
    public T remove(T data);
    public T remove(int index);
    public T removeFirst();
    public T removeLast();
    public T getData(int index);
    public int getIndex(T data);
    public boolean contains(T data);
    public boolean isEmpty();
    public int size();
    public void print();
    public void clear();

}
